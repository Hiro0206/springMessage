package com.example;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessageController {

  // TODO:同じパッケージに属していないとDIされないらしいのだが、どうすればよいのか？
  private final MessageService service;

  MessageController(MessageService service) {
    this.service = service;
  }

  @GetMapping
  public String messages(Model model) {
    model.addAttribute("messageForm", new MessageForm());

    List<Message> messages = service.getRecentMessages(100);
    model.addAttribute("messages", messages);

    return "messages";
  }

  @PostMapping
  public String messagesPost(Model model, @Valid MessageForm messageForm, BindingResult bindingResult, HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
      List<Message> messages = service.getRecentMessages(100);
      model.addAttribute("messages", messages);
      return "messages";
    }

    service.save(new Message(messageForm.getName(), messageForm.getText(), request.getRemoteAddr()));
    return "redirect:/messages";
  }
}
