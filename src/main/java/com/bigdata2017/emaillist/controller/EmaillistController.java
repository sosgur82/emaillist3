package com.bigdata2017.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata2017.emaillist.dao.EmaillistDao;
import com.bigdata2017.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {

	@Autowired
	private EmaillistDao emaillistDao;

	@RequestMapping("/index")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistDao.getList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute EmaillistVo emaillistVo) {
		emaillistDao.insert(emaillistVo);
		return "redirect:/index";
	}
}
