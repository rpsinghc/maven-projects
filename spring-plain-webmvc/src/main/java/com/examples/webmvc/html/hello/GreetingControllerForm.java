package com.examples.webmvc.html.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingControllerForm {

    @GetMapping("/greeting-form")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting-form";
    }

    @PostMapping("/greeting-form")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "formresult";
    }
}
