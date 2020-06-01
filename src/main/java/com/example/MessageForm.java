package com.example;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageForm {

  @Size(max = 80)
  private String name;

  @Size(min = 1, max = 140)
  private String text;
}
