package com.example;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MessageService {

  private final MessageRepository repository;

  MessageService(MessageRepository repository) {
    this.repository = repository;
  }

  public List<Message> getRecentMessages(Integer n) {
    return repository.findByOrderByIdDesc(PageRequest.of(2, n));
  }

  public void save(Message message) {
    repository.save(message);
  }
}
