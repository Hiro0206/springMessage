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
@RequestMapping("/")
public class MessageController {

  // TODO:同じパッケージに属していないとDIされないらしいのだが、どうすればよいのか？
  private final MessageService service;

  MessageController(MessageService service) {
    this.service = service;
  }

  @GetMapping
  public String index() {return "redirect:messages";}

  @GetMapping("messages")
  public String getMessage(Model model) {
    model.addAttribute("messageForm", new MessageForm());

    List<Message> messages = service.getRecentMessages(100);
    model.addAttribute("messages", messages);

    return "messages";
  }

  @PostMapping("messages")
  public String postMessage(Model model, @Valid MessageForm messageForm, BindingResult bindingResult, HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
      List<Message> messages = service.getRecentMessages(100);
      model.addAttribute("messages", messages);
      return "messages";
    }

    service.save(
        new Message()
            .builder()
            .name(messageForm.getName())
            .text(messageForm.getText())
            .remoteAddr(request.getRemoteAddr())
            .build());
    return "redirect:/messages";
  }
}
