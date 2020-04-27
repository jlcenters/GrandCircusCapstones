package co.grandcircus.Capstone7;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.Capstone7.Entities.FavoriteRecipe;
import co.grandcircus.Capstone7.Entities.Recipe;
import co.grandcircus.Capstone7.Entities.SearchResult;
import co.grandcircus.Capstone7.dao.FavoritesDao;

@Controller
public class RecipeController {

	private List<Recipe> currentResults;
	private String dietLabelsRoot;
	private String healthLabelsRoot;
	@Autowired
	private FavoritesDao fDao;

	@Autowired
	private ApiService apiServ;

	@RequestMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("index");
	}

	@RequestMapping("/search")
	public ModelAndView showSearch() {
		return new ModelAndView("search");
	}

	@PostMapping("/search")
	public ModelAndView showResults(@RequestParam String lbl, @RequestParam(required = false) String dietLbls,
			@RequestParam(required = false) String healthLbls, @RequestParam(required = false) Integer from,
			RedirectAttributes redir) {
		try {
			if (currentResults != null) {
				currentResults.clear();
			}

			if (dietLbls != null) {
				dietLabelsRoot = dietLbls;
			}

			if (healthLbls != null) {
				healthLabelsRoot = healthLbls;
			}

			SearchResult results = apiServ.findByCriteria(lbl, dietLabelsRoot, healthLabelsRoot, from);
			currentResults = apiServ.getRecipeList(results);
			ModelAndView mav = new ModelAndView("results");
			mav.addObject("list", currentResults);
			mav.addObject("searchResults", results);

			return mav;

		} catch (RestClientException e) {
			e.printStackTrace();
			redir.addFlashAttribute("message", "No results found!");
			return new ModelAndView("redirect:/search");
		}
	}

	@PostMapping("/fav/add")
	public ModelAndView addFav(RedirectAttributes redir, @RequestParam int arrayIndex) {
		Recipe rec = currentResults.get(arrayIndex);
		FavoriteRecipe fav = apiServ.convert(rec);
		fDao.save(fav);
		redir.addFlashAttribute("message", "Added to Favorites!");
		return new ModelAndView("redirect:/search");
	}

	@RequestMapping("/fav")
	public ModelAndView showFavorites(RedirectAttributes redir) {
		List<FavoriteRecipe> favList = fDao.findAll();
		if (favList.size() == 0) {
			redir.addFlashAttribute("message", "No Favorites Found");
			return new ModelAndView("redirect:/search");
		}
		return new ModelAndView("favorites", "list", favList);
	}

	@RequestMapping("/display")
	public ModelAndView showSingle(RedirectAttributes redir, @RequestParam("recipeUri") String recipeUri) {
		Recipe test = apiServ.getOneRecipe(recipeUri);
		return new ModelAndView("display", "recipe", test);
	}

//	@PostMapping("/display")
//	public ModelAndView redirectRecipe(String url) {
//		return new ModelAndView("redirect:" + url);
//	public ModelAndView showSingle(RedirectAttributes redir, @RequestParam(required = false) String uri) {
//		if (uri.isEmpty() || uri == null) {
//			redir.addFlashAttribute("message", "Recipe not found");
//			return new ModelAndView("redirect:/search");
//		}
//		return new ModelAndView("display", "uri", uri);
//	}
}