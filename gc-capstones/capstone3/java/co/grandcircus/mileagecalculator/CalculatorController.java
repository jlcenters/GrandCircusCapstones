package co.grandcircus.mileagecalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/haha")
	public ModelAndView animation() {
		return new ModelAndView("haha");
	}
	
	@RequestMapping("/mileage-form")
	public ModelAndView mileageForm() {
		return new ModelAndView("form");
	}
	
	@RequestMapping("/mileage-result")
	public ModelAndView mileageResult(
			@RequestParam("gallons") int gallons,
			@RequestParam("mpg") int mpg) {
		
		int result = gallons * mpg;
		
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("gallons", gallons);
		mav.addObject("mpg", mpg);
		mav.addObject("result", result);
		return mav;
	}
}
