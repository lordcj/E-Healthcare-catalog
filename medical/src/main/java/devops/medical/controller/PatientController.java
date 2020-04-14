package devops.medical.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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

import devops.medical.model.Patient;
import devops.medical.service.PatientService;
import devops.medical.model.PatientLogin;
import devops.medical.model.BookedSlot;
import devops.medical.model.Doctor;
import devops.medical.model.DoctorSlots;

@Controller
public class PatientController {
	
	@Autowired
	public PatientService patientservice;
	
	@RequestMapping(value="/patientloginandsignup", method=RequestMethod.GET)
	public ModelAndView patientLoginandSignup(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("PatientLoginAndSignup");
		return mav;
	}
	
	@RequestMapping(value="/patientregister", method=RequestMethod.GET)
	public ModelAndView patientregister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("PatientRegister");
		mav.addObject("patient", new Patient());
		return mav;
	}
	
	@RequestMapping(value="/patientlogin", method=RequestMethod.GET)
	public ModelAndView patientlogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("PatientLogin");
		mav.addObject("patient", new PatientLogin());
		return mav;
	}
	
	@RequestMapping(value="/patient/{id}", method=RequestMethod.GET)
	public ModelAndView patientcatalog(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") String id) {
		ModelAndView mav = new ModelAndView("PatientCatalog");
		List<Doctor> doctors = patientservice.getAllDoctors();
		ArrayList<ArrayList<String> > available = new ArrayList<ArrayList<String>>();
		for(Doctor doctor: doctors) {
			ArrayList<String> slots = patientservice.validDates(doctor.getId());
			available.add(slots);
		}
		
		mav.addObject("id", id);
		mav.addObject("doctors", doctors);
		mav.addObject("slots", available);
		mav.addObject("bookedslots", new BookedSlot());
		return mav;
	}
	
	@RequestMapping(value="/patientloginprocess", method=RequestMethod.POST)
	public String patientloginprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("patient") PatientLogin patientlogin,RedirectAttributes redirectAttrs) {
		Patient user = patientservice.check(patientlogin);
		System.out.println("yes");
		if(user!=null) {
			String id = user.getId();
			return "redirect:/patient/"+id;
		}else {
			redirectAttrs.addFlashAttribute("message", "Id or Password is incorrect");
			return "redirect:/patientlogin";
		}
	}
	
	@RequestMapping(value="/patient/doctorbookingprocess", method=RequestMethod.POST)
	public String doctorbookingprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("bookedslots") BookedSlot bookedslot, RedirectAttributes redirectAttrs) {
		System.out.println(bookedslot.getBookedslot()+" ****** ");//bookedslot.getId());
		String id = bookedslot.getId();
		return "redirect:/patient/"+id;
	}
	
	@RequestMapping(value="/patientregisterprocess", method=RequestMethod.POST)
	public String patientregisterprocess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttrs) {
		Patient user = patientservice.validatePatient(patient);
		if(user != null) {
			redirectAttrs.addFlashAttribute("message", "id already exists");
			return "redirect:/patientregister";
		}else {
			patientservice.register(patient);
			String id = patient.getId();
			return "redirect:/patient/"+id;
		}
	}
	
}
