package com.kovalenko.spring.controller;

import com.kovalenko.spring.model.Stormtrooper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StormtrooperController {

  private List<Stormtrooper> stormtroopers = new ArrayList<>();

  @GetMapping("/listStormtroopers")
  public String getAllStormtroopers(Model model) {
    model.addAttribute("listStormtroopers", stormtroopers);
    return "listStormtroopers";
  }

  @GetMapping("/addStormtrooper")
  public String getFromStormtrooper(Stormtrooper stormtrooper) {
    return "addStormtrooper";
  }

  @PostMapping("/addStormtrooper")
  public String addStormtrooper(Stormtrooper stormtrooper) {
    stormtroopers.add(stormtrooper);
    return "redirect:/listStormtroopers";
  }
}
