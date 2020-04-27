package co.grandcircus.capstone6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.capstone6.daos.TaskRepo;
import co.grandcircus.capstone6.daos.UserRepo;
import co.grandcircus.capstone6.entities.Task;
import co.grandcircus.capstone6.entities.User;

@Controller
//@RequestMapping("/{username}")
public class TaskController {

	@Autowired
	private TaskRepo trepo;
	@Autowired
	private UserRepo urepo;

	@RequestMapping("/home")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("tasks", trepo.findAll());
		return mv;
	}

	@RequestMapping("/tasks")
	public ModelAndView showUserTasks(@RequestParam("userId") Long userId) {
		User user = urepo.findUserById(userId);
		ModelAndView mv = new ModelAndView("user-tasks","userId",userId);
		mv.addObject("tasks", trepo.findAllByUserId(user.getId()));
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("userId") String userId) {
		return new ModelAndView("add", "userId", userId);
	}

	@PostMapping("/add")
	public ModelAndView add(@RequestParam("descr") String descr, @RequestParam("date") String dueDate,
			@RequestParam("userId") Long userId) {
		User user = urepo.findUserById(userId);
		Task task = new Task(descr, dueDate, user);
		trepo.save(task);
		ModelAndView mv = new ModelAndView("redirect:/tasks?userId=" + userId,"userId",userId);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam("taskId") Long taskId, @RequestParam("userId") Long userId,
			@RequestParam("editDate") String date, @RequestParam("editCompl") String compl) {
		User user = urepo.findUserById(userId);
		ModelAndView mv = new ModelAndView("edit", "userId", userId);
		mv.addObject("user", user);
		return mv;
	}

	@PostMapping("/edit")
	public ModelAndView edit(@RequestParam("descr") String descr, @RequestParam("date") String dueDate,
			@RequestParam("userId") Long userId, @RequestParam("taskId") Long taskId) {
		User user = urepo.findUserById(userId);
		Task task = trepo.findTaskById(taskId);
		task.setDate(dueDate);
		task.setDescription(descr);
		trepo.update(task);
		ModelAndView mv = new ModelAndView("redirect:/tasks?userId=" + userId, "userId", userId);
		mv.addObject("user", user);
		return mv;

	}

	@RequestMapping("/remove")
	public ModelAndView remove(@RequestParam("taskId") Long taskId, @RequestParam("userId") Long userId,
			RedirectAttributes rdr) {
		User user = urepo.findUserById(userId);
		trepo.deleteById(taskId);
		rdr.addFlashAttribute("message", "Successfully removed");
		ModelAndView mv = new ModelAndView("redirect:/tasks?userId=" + userId, "user", user);
		mv.addObject("userId", userId);
		return mv;
	}

}
