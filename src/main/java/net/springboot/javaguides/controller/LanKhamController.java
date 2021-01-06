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

import net.springboot.javaguides.entity.LanKham;
import net.springboot.javaguides.repository.LanKhamRepository;

@Controller
@RequestMapping("/lankhams/")
public class LanKhamController {
	@Autowired
	private LanKhamRepository lanKhamRepository;

	@GetMapping("showFormLanKham")
	public String showLanKhamForm(LanKham lankham) {
		return "add-lankham";
	}

	@GetMapping("list")
	public String lankhams(Model model) {
		model.addAttribute("lankhams", this.lanKhamRepository.findAll()); // show bang lankham
		return "dslankham";
	}

	@PostMapping("add")
	public String addlankhamKham(@Valid LanKham lankham, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-lankham";
		}

		this.lanKhamRepository.save(lankham);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		LanKham lankham = this.lanKhamRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid lankham id : " + id));

		model.addAttribute("lankham", lankham);
		return "update-lankham";
	}

	@PostMapping("update/{id}")
	public String updateLanKham(@PathVariable("id") long id, @Valid LanKham lankham, BindingResult result, Model model) {
		if (result.hasErrors()) {
			lankham.setId(id);
			return "update-lankham";
		}
		// update y ta
		lanKhamRepository.save(lankham);

		// get all y ta ( with update)
		model.addAttribute("lankhams", this.lanKhamRepository.findAll());
		return "dslankham";
	}
	
	@GetMapping("delete/{id}")
	public String deleteLanKham(@PathVariable ("id") long id, Model model) {
		
		LanKham lankham = this.lanKhamRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid lankham id : " + id));
		
		this.lanKhamRepository.delete(lankham);
		model.addAttribute("lankhams", this.lanKhamRepository.findAll()); //bang lankham
		return "dslankham";
		
}
}
