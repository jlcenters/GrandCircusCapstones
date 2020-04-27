package co.grandcircus.capstone6.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.capstone6.daos.UserRepo;
import co.grandcircus.capstone6.entities.User;

@Controller
public class LoginController {

	@Autowired
	private UserRepo urepo;
	@Autowired
	private HttpSession ssn;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "loginPrompt",
				"Log in or Register to view, add, edit and delete the company tasks!");
	}
	@PostMapping("/")
	public ModelAndView index(@RequestParam("user") String username, @RequestParam("pass") String password,
			RedirectAttributes rdr) {
		User user = urepo.findByUsernameIgnoreCase(username);
		if ((user == null) || (!password.equals(user.getPassword()))) {
			rdr.addFlashAttribute("message","Sorry, your login credentials are incorrect. Please try again.");
			return new ModelAndView("redirect:/");
		} else {
			ssn.setAttribute("user", user);
			Long userId = user.getId();
			rdr.addFlashAttribute("message", "Welcome Back, " + user.getUsername() + "!");
			ModelAndView mv = new ModelAndView("redirect:/home","userId", userId);
			return mv;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(RedirectAttributes rdr) {
		ssn.invalidate();
		rdr.addFlashAttribute("message", "Logged out. Goodbye!");
		return new ModelAndView("redirect:/");
	}
}
