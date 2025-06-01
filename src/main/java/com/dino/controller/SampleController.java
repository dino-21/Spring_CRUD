package com.dino.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dino.domain.TestVO;
import com.dino.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
public class SampleController {
	private final SampleService service;


	@GetMapping("/read")                           //Model은 jsp화면에 값을 전달하고 싶을때 사용
	public String read(@RequestParam("id") int id, Model model) {
		log.info("read-------------");
		log.info("id >>> " + id);
		log.info("service === >>> " + service);
		TestVO vo = service.getOne(id); //vo값을 read.jsp전달하고 싶다.
		model.addAttribute("list", vo);
		
		//log.info("vo>>" + vo);
		return "read";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("get List ----------------- ");
		
		List<TestVO> lists = service.getList();
		model.addAttribute("list", lists);
                       return "list";
	}
	
	
	@PostMapping("/update")
	public String update(TestVO vo, RedirectAttributes redirectAttributes) {
		log.info("update = >" + vo);
		int result = service.update(vo);	    
		redirectAttributes.addFlashAttribute("msg", "수정이 완료되었습니다.");
		return "redirect:/list";
	}
	
	@PostMapping("/delete")
	public String delete(TestVO vo, RedirectAttributes redirectAttributes) {
		log.info("delete ==> " + vo.getId());
		service.delete(vo.getId());
		redirectAttributes.addFlashAttribute("msg", "삭제가 완료되었습니다.");
		return "redirect:/list";
	}
	
	
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("/insert")
	public String insertPOST(TestVO vo, RedirectAttributes redirectAttributes) {
		log.info("insertPost => " + vo);
		service.insert(vo);		
		redirectAttributes.addFlashAttribute("msg", "등록이 완료되었습니다.");
		return "redirect:/list";
	}
	
}
