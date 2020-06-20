package com.example;

import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm implements Serializable {

  private static final long serialVersionUID = 1L;

  @Size(max = 10)
  private String id;

  @Size(max = 20)
  private String pass;
}
