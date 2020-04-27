package co.grandcircus.capstone6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.capstone6.daos.UserRepo;
import co.grandcircus.capstone6.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo urepo;

	@RequestMapping("/register")
	public ModelAndView signUp() {
		return new ModelAndView("register");
	}

	@PostMapping("/register")
	public ModelAndView signUp(@RequestParam("user") String username, @RequestParam("pass1") String pass1,
			@RequestParam("pass2") String pass2, RedirectAttributes rdr) {
		User userCheck = urepo.findByUsernameIgnoreCase(username);
		if (userCheck == null) {
			if (pass1.equals(pass2)) {
				boolean eightChar = false;
				boolean caps = false;
				boolean num = false;

				for (int i = 0; i < pass1.length(); ++i) {
					String ch = Character.toString(pass1.charAt(i));
					if ((i + 1) >= 8) {
						eightChar = true;
					}
					if (ch.matches("[A-Z]")) {
						caps = true;
					}
					if (ch.matches("[0-9]")) {
						num = true;
					}
				}

				if (eightChar && caps && num) {
					User user = new User(username, pass1);
					urepo.save(user);
					Long userId = user.getId();
					ModelAndView mv = new ModelAndView("home","userId",userId);
					mv.addObject("message", "Welcome to the Task Manager, " + username + "!");
					mv.addObject("user",user);
					return mv;
				} else {
					rdr.addFlashAttribute("message",
							"Make sure your password includes at LEAST: 8 characters, 1 capital letter, and 1 number");
					return new ModelAndView("redirect:/user/register");
				}

			} else {
				rdr.addFlashAttribute("message", "Passwords do not match. Please try again.");
				return new ModelAndView("redirect:/user/register");
			}
		} else {
			rdr.addFlashAttribute("message", username + " is already in use by another employee. Please try again.");
			return new ModelAndView("redirect:/user/register");
		}
	}

}
