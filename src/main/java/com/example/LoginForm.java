package com.example;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  @NotEmpty
  @Size(min = 1, max = 20)
  private String pass;
}
