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

import net.springboot.javaguides.entity.BenhNhan;
import net.springboot.javaguides.repository.BenhNhanRepository;

@Controller
@RequestMapping("/benhnhans/")
public class BenhNhanController {
	@Autowired
	private BenhNhanRepository benhNhanRepository;

	@GetMapping("showFormBenhNhan")
	public String showBenhNhanForm(BenhNhan benhnhan) {
		return "add-benhnhan";
	}

	@GetMapping("list")
	public String benhnhans(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("benhnhans", this.benhNhanRepository.findByKeyword(keyword));
		} else {
			model.addAttribute("benhnhans", this.benhNhanRepository.findAll()); // show bang benhnhan
		}
		return "dsbenhnhan";
	}

	@PostMapping("add")
	public String addBenhNhan(@Valid BenhNhan benhnhan, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-benhnhan";
		}

		this.benhNhanRepository.save(benhnhan);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		BenhNhan benhnhan = this.benhNhanRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid benhnhan id : " + id));

		model.addAttribute("benhnhan", benhnhan);
		return "update-benhnhan";
	}

	@PostMapping("update/{id}")
	public String updateBenhNhan(@PathVariable("id") long id, @Valid BenhNhan benhnhan, BindingResult result, Model model) {
		if (result.hasErrors()) {
			benhnhan.setId(id);
			return "update-benhnhan";
		}
		// update y ta
		benhNhanRepository.save(benhnhan);

		// get all y ta ( with update)
		model.addAttribute("benhnhans", this.benhNhanRepository.findAll());
		return "dsbenhnhan";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBenhNhan(@PathVariable ("id") long id, Model model) {
		
		BenhNhan benhnhan = this.benhNhanRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid benhnhan id : " + id));
		
		this.benhNhanRepository.delete(benhnhan);
		model.addAttribute("benhnhans", this.benhNhanRepository.findAll()); //bang benhnhan
		return "dsbenhnhan";
		
}
}
