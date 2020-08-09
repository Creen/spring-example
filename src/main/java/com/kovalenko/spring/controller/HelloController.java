package com.kovalenko.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //@RestController
//@RequestMapping("/api")
public class HelloController {

  //@RequestMapping(value = "/hello", method = RequestMethod.GET)
  @GetMapping("/hello") //@RequestMapping
  public String getHello(Model model) {
    model.addAttribute("hello", "helloString");
    return "index";
  }
}
