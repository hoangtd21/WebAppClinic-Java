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

import net.springboot.javaguides.entity.YTa;
import net.springboot.javaguides.repository.YTaRepository;

@Controller
@RequestMapping("/ytas/")
public class YTaController {
	@Autowired
	private YTaRepository yTaRepository;

	@GetMapping("showFormYTa")
	public String showYTaForm(YTa yta) {
		return "add-yta";
	}

	@GetMapping("list")
	public String ytas(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("ytas", this.yTaRepository.findByKeyword(keyword));
		} else {
			model.addAttribute("ytas", this.yTaRepository.findAll()); // show bang yta
		}

		return "dsyta";
	}

	@PostMapping("add")
	public String addYTa(@Valid YTa yta, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-yta";
		}

		this.yTaRepository.save(yta);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		YTa yta = this.yTaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid yta id : " + id));

		model.addAttribute("yta", yta);
		return "update-yta";
	}

	@PostMapping("update/{id}")
	public String updateYTa(@PathVariable("id") long id, @Valid YTa yta, BindingResult result, Model model) {
		if (result.hasErrors()) {
			yta.setId(id);
			return "update-yta";
		}
		// update y ta
		yTaRepository.save(yta);

		// get all y ta ( with update)
		model.addAttribute("ytas", this.yTaRepository.findAll());
		return "dsyta";
	}
	
	@GetMapping("delete/{id}")
	public String deleteYTa(@PathVariable ("id") long id, Model model) {
		
		YTa yTa = this.yTaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid yta id : " + id));
		
		this.yTaRepository.delete(yTa);
		model.addAttribute("ytas", this.yTaRepository.findAll()); //bang yta
		return "dsyta";
		
}

}
