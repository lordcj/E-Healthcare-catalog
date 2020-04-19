package devops.medical.controller;

import java.util.List;

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

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;
import devops.medical.model.Doctor;
import devops.medical.model.Patient;
import devops.medical.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	public AdminService adminservice;
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
	public ModelAndView adminlogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("AdminLogin");
		mav.addObject(new Admin());
		return mav;
	}
	
	@RequestMapping(value="/adminloginprocess", method=RequestMethod.POST)
	public String adminloginprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("admin") AdminLogin adminlogin, RedirectAttributes redirectAttrs) {
		Admin admin = adminservice.check(adminlogin);
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
	
	@RequestMapping(value="admin/doctors", method=RequestMethod.GET)
	public ModelAndView doctorsList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("DoctorsList");
		List<Doctor> doctorslist = adminservice.getAllDoctors();
		mav.addObject("doctorslist", doctorslist);
		return mav;
	}
	
	@RequestMapping(value="/labs", method=RequestMethod.GET)
	public ModelAndView labsList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("LabsList");
		return mav;
	}
	
	@RequestMapping(value="admin/doctoradd", method=RequestMethod.GET)
	public ModelAndView doctoradd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("DoctorAdd");
		mav.addObject("doctor", new Doctor());
		return mav;
	}
	
	@RequestMapping(value="admin/doctoraddprocess", method=RequestMethod.POST)
	public String doctoraddprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("doctor") Doctor doctor, RedirectAttributes redirectAttrs) {
		Doctor user = adminservice.validateDoctor(doctor);
		if(user != null) {
			redirectAttrs.addFlashAttribute("message", "id already exists");
			return "redirect:/admin/doctoradd";
		}else {
			adminservice.registerDoctor(doctor);
			return "redirect:/admin/doctors";
		}
	}
	
	@RequestMapping(value="admin/doctoredit/{id}", method=RequestMethod.GET)
	public ModelAndView doctoredit(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") String id) {
		ModelAndView mav = new ModelAndView("DoctorEdit");
		Doctor doctor = adminservice.getDoctor(id);
		mav.addObject("doctor", doctor);
		return mav;
	}
	
	
	@RequestMapping(value="admin/doctoredit/doctorsave", method=RequestMethod.POST)
	public String doctorsave(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("doctor") Doctor doctor, RedirectAttributes redirectAttrs) {
		adminservice.updateDoctor(doctor);
		return "redirect:/admin/doctors";
	}
	
	@RequestMapping(value="admin/doctordelete/{id}", method=RequestMethod.GET)
	public String doctordelete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") String id) {
		adminservice.deleteDoctor(id);
		return "redirect:/admin/doctors";
	}

	
	
}
