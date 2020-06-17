package com.example;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  private final LoginService service;

  private final MessageSource source;

  // DIコンテナで管理しているBeanが複数ある場合はどうすればよいか？
  // 同じ型で依存関係のあるクラスが複数ある場合はどうすればよいか?
  public LoginController(LoginService service, @Qualifier("messageSource") MessageSource source) {
    this.service = service;
    this.source = source;
  }

  // ログイン画面を作りたいならユーザー登録画面も作らないといけないのでは？
  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("loginForm", new LoginForm());
    return "login";
  }

  // ログイン画面を作りたいならユーザー登録画面も作らないといけないのでは？
  // 画面に入力された文字列を連携するためには？→formで連携する？
  // 入力された文字列が条件に沿うものでなかった場合、エラーを画面に表示するには？
  // バリデーションチェックの結果を画面に表示するには？→hibernate validatorライブラリをインポートする
  // なぜエラーメッセージの設定をしていないのに日本語でメッセージが表示されるのか？→おそらくエディタの設定で自動的にhibernate validator
  // の日本語メッセージリソースが読み込まれるようになっているのだと思われる。
  // エラーメッセージが表示される順番はどのようにして決まっているのか？
  // エラーメッセージを一箇所にまとめて表示するには？
  @PostMapping("/login")
  public String postLogin(
      @Validated LoginForm form,
      BindingResult bindingResult,
      Model model) {

    if (!service.canLogin(form.getId(), form.getPass())) {
      String errorMessage = source.getMessage("invalid-login", new String[]{}, Locale.JAPAN);
      model.addAttribute("error", errorMessage);
      return "login";
    }

    String message = source.getMessage("success-login", new String[]{form.getId()}, Locale.JAPAN);
    model.addAttribute("success", message);
    bindingResult.hasErrors();
    return "login";
  }
}
