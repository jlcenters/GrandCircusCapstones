package co.grandcircus.Capstone7;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.grandcircus.Capstone7.Entities.FavoriteRecipe;
import co.grandcircus.Capstone7.Entities.Hit;
import co.grandcircus.Capstone7.Entities.Recipe;
import co.grandcircus.Capstone7.Entities.SearchResult;

@Component
public class ApiService {

	private RestTemplate rt;

	// initialization block that runs when a new instance of the class is created
	// loaded before the constructor
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "ooeeee!");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor, new RequestResponseLoggingInterceptor()).build();
	}

	public Recipe displayRecipeSite(String uri) {
		String url = "https://api.edamam.com/search?q=" + uri + "&app_id=1aba9e71&app_key=d55c2a63a55637683ce6dc1e71f0a369";

		Recipe recipe = rt.getForObject(url, Recipe.class);
		return recipe;
	}
	
	public FavoriteRecipe convert(Recipe orig) {
		FavoriteRecipe returnRec = new FavoriteRecipe();
		returnRec.setUrl(orig.getUrl());
		returnRec.setLbl(orig.getLbl());
		returnRec.setImg(orig.getImg());
		returnRec.setSrc(orig.getSrc());
		return returnRec;
	}
	
	public Recipe getOneRecipe(String uri) {
		try {
			System.out.println("Test in try loop");
			uri = URLEncoder.encode(uri, "UTF-8");
			System.out.println("Encoded");
		} catch (UnsupportedEncodingException e) {
			System.out.println("test in exception");
			throw new RuntimeException(e);
		}
		String uri = "http://www.edamam.com/ontologies/edamam.owl#recipe_b79327d05b8e5b838ad6cfd9576b30b6";
		
		String baseUrl = "https://api.edamam.com/search?app_id=1aba9e71&app_key=d55c2a63a55637683ce6dc1e71f0a369";
		URI url = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("r", uri).build().toUri();
		System.out.println(url.toString());
		
		Recipe[] result = rt.getForObject(url, Recipe[].class);
		System.out.println("success");
		System.out.println(result[0]);
//		return null;
		return result[0];
	}


	public SearchResult findByCriteria(String label, String dietLbls, String healthLbls, Integer fromInt){
		Integer toInt = fromInt + 10;
		String url = "https://api.edamam.com/search?q=" + label + "&app_id=1aba9e71&app_key=d55c2a63a55637683ce6dc1e71f0a369";
		if (!dietLbls.equals("")) {
			url = url + "&diet=" + dietLbls;
		}
		
		if(!healthLbls.equals("")) {
			url = url + "&health=" + healthLbls;
		}
		url += "&from=" + fromInt + "&to=" + toInt;
		System.out.println(url);
		SearchResult returnResult = rt.getForObject(url, SearchResult.class);
		return returnResult;
	}
	
	public List<Recipe> getRecipeList(SearchResult results){
		List<Hit> hitList = results.getHits();
		
		List<Recipe> recipeList = new ArrayList<>();
		for (Hit hit : hitList) {
			recipeList.add(hit.getRecipe());
		}
		
		return recipeList;
	}

}
