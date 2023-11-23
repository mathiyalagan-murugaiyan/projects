package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class DemoController {
	
	@GetMapping("/")
	@ResponseBody
    public String home() {
		return"<h1>HOME PAGE</h1>";
	}
	
	@GetMapping("add/{a}/{b}/{c}")
	@ResponseBody
	public int add(@PathVariable("a") int a,@PathVariable("b") int b,@PathVariable("c") int c)
	{
		return (a+b+c);
	}
	
	@GetMapping("/addtion")
	@ResponseBody
	public int addtion(@RequestParam("a") int a,@RequestParam(value = "b", defaultValue = "20") int b ) {
		
		return (a+b);
	}
	@GetMapping("/even")
	public String even() {
		return "welcome";
	}
	@GetMapping("/processEven")
	
	public String process(@RequestParam("number") int number, Model model) {
		
		model.addAttribute("number", number);
		if(number%2==0) {
			model.addAttribute("result", "Even");
		}else
		{
			model.addAttribute("result", "Not Even");
		}
		return "result";
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		return"<h1 style= color:red;>hello world</h1>";
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome";
	}
}
