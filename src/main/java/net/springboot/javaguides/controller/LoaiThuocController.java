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

import net.springboot.javaguides.entity.LoaiThuoc;
import net.springboot.javaguides.repository.LoaiThuocRepository;


@Controller
@RequestMapping("/loaithuocs/")
public class LoaiThuocController {
	@Autowired
	private LoaiThuocRepository loaiThuocRepository;

	@GetMapping("showFormLoaiThuoc")
	public String showLoaiThuocForm(LoaiThuoc loaithuoc) {
		return "add-loaithuoc";
	}

	@GetMapping("list")
	public String loaithuocs(Model model) {
		model.addAttribute("loaithuocs", this.loaiThuocRepository.findAll()); // show bang loaithuoc
		return "dsloaithuoc";
	}

	@PostMapping("add")
	public String addLoaiThuoc(@Valid LoaiThuoc loaithuoc, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-loaithuoc";
		}

		this.loaiThuocRepository.save(loaithuoc);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		LoaiThuoc loaithuoc = this.loaiThuocRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid loaithuoc id : " + id));

		model.addAttribute("loaithuoc", loaithuoc);
		return "update-loaithuoc";
	}

	@PostMapping("update/{id}")
	public String updateLoaiThuoc(@PathVariable("id") long id, @Valid LoaiThuoc loaithuoc, BindingResult result, Model model) {
		if (result.hasErrors()) {
			loaithuoc.setId(id);
			return "update-loaithuoc";
		}
		// update y ta
		loaiThuocRepository.save(loaithuoc);

		// get all y ta ( with update)
		model.addAttribute("loaithuocs", this.loaiThuocRepository.findAll());
		return "dsloaithuoc";
	}
	
	@GetMapping("delete/{id}")
	public String deleteLoaiThuoc(@PathVariable ("id") long id, Model model) {
		
		LoaiThuoc loaithuoc = this.loaiThuocRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid loaithuoc id : " + id));
		
		this.loaiThuocRepository.delete(loaithuoc);
		model.addAttribute("loaithuocs", this.loaiThuocRepository.findAll()); //bang loaithuoc
		return "dsloaithuoc";
		
}

}
