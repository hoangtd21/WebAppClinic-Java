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

import net.springboot.javaguides.entity.BacSy;
import net.springboot.javaguides.repository.BacSyRepository;

@Controller
@RequestMapping("/bacsys/")
public class BacSyController {
	@Autowired
	private BacSyRepository bacSyRepository;

	@GetMapping("showFormBacSy")
	public String showBacSyForm(BacSy bacsy) {
		return "add-bacsy";
	}

	@GetMapping("list")
	public String bacsys(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("bacsys", this.bacSyRepository.findByKeyword(keyword));
		} else {
			model.addAttribute("bacsys", this.bacSyRepository.findAll()); // show bang bacsy
		}
		return "dsbacsy";
	}

	@PostMapping("add")
	public String addBacSy(@Valid BacSy bacsy, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-bacsy";
		}

		this.bacSyRepository.save(bacsy);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		BacSy bacsy = this.bacSyRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bacsy id : " + id));

		model.addAttribute("bacsy", bacsy);
		return "update-bacsy";
	}

	@PostMapping("update/{id}")
	public String updateBacSy(@PathVariable("id") long id, @Valid BacSy bacsy, BindingResult result, Model model) {
		if (result.hasErrors()) {
			bacsy.setId(id);
			return "update-bacsy";
		}
		// update y ta
		bacSyRepository.save(bacsy);

		// get all y ta ( with update)
		model.addAttribute("bacsys", this.bacSyRepository.findAll());
		return "dsbacsy";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBacSy(@PathVariable ("id") long id, Model model) {
		
		BacSy bacsy = this.bacSyRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bacsy id : " + id));
		
		this.bacSyRepository.delete(bacsy);
		model.addAttribute("bacsys", this.bacSyRepository.findAll()); 
		return "dsbacsy";
		
}
}
