package devops.medical.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorLogin;
import devops.medical.service.DoctorService;

@Controller
public class DoctorController {
	
	@Autowired
	public DoctorService DoctorService;
	
	@RequestMapping(value="/doctorlogin", method=RequestMethod.GET)
	public ModelAndView doctorlogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("DoctorLogin");
		mav.addObject(new Doctor());
		return mav;
	}

	@RequestMapping(value="/doctor/{id}", method=RequestMethod.GET)
	public ModelAndView doctorcatalog(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") String id) {
		ModelAndView mav = new ModelAndView("DoctorCatalog");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping(value="/doctorloginprocess", method=RequestMethod.POST)
	public String doctorloginprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("doctor") DoctorLogin doctorlogin, RedirectAttributes redirectAttrs) {
		Doctor doctor = DoctorService.check(doctorlogin);
		if(doctor==null) {
			redirectAttrs.addFlashAttribute("message", "ID or password is incorrect");
			return "redirect:/doctorlogin";
		}else {
			String id = doctor.getId();
			return "redirect:/doctor/"+id;
		}
	}
	
}
