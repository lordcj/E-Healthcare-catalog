package devops.medical.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;
import devops.medical.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	public AdminService AdminService;

	
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
	public ModelAndView adminlogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("AdminLogin");
		mav.addObject(new Admin());
		return mav;
	}
	
	@RequestMapping(value="/adminloginprocess", method=RequestMethod.POST)
	public String adminloginprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("admin") AdminLogin adminlogin, RedirectAttributes redirectAttrs) {
		Admin admin = AdminService.check(adminlogin);
		if(admin==null) {
			redirectAttrs.addFlashAttribute("message", "ID or password is incorrect");
			return "redirect:/adminlogin";
		}else {
			String id = admin.getId();
			return "redirect:/admin/"+id;
		}
	}
	
	@RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
	public ModelAndView admincatalog(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") String id) {
		ModelAndView mav = new ModelAndView("AdminCatalog");
		mav.addObject("id", id);
		return mav;
	}

	
	
}
