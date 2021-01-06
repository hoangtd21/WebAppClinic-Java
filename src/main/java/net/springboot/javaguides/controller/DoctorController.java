package net.springboot.javaguides.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springboot.javaguides.entity.Doctor;
import net.springboot.javaguides.repository.DoctorRepository;

@Controller
@RequestMapping("/doctors/")
public class DoctorController{
	@Autowired 
	private DoctorRepository doctorRepository;
	
	@GetMapping("showFormDoctor")
	public String showDoctorForm(Doctor doctor) {
		return "add-doctor";
	}
	
	@GetMapping("list")
	public String doctors(Model model, String keyword) {
		if(keyword != null) {
			model.addAttribute("doctors", this.doctorRepository.findByKeyword(keyword));
		}
		else {
			model.addAttribute("doctors", this.doctorRepository.findAll());
		}
		return "dsdoctor";
	}
	
	@PostMapping("add")
	public String addDoctor(@Valid Doctor doctor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-doctor";
		}
		this.doctorRepository.save(doctor);
		return "redirect:list";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long  id, Model model) {
		Doctor doctor = this.doctorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id khong hop le: " + id));
		model.addAttribute("doctor", doctor);
		return "update-doctor";
	}
}
