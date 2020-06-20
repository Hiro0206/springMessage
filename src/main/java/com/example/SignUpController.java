package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

  private final SignUpService service;

  SignUpController(SignUpService service) {
    this.service = service;
  }

  @GetMapping
  public String index(Model model) {
    model.addAttribute("signUpForm", new SignUpForm());
    return "signup";
  }

  @PostMapping
  public String createUser(SignUpForm form, Model model) {
    service.createUser(form.getId(), form.getPass());
    model.addAttribute("success", "ユーザー登録成功");

    return "redirect:messages";
  }

}
