/**
 * 要素が空であるかを示す真偽値です。
 * @param el
 * @returns {boolean}
 */
let isEmpty = el => el != null && el.value == "";

// 必要な項目が入力された場合に、ボタンを活性にする。
let removeDisabled = (id, pass, inputEl) => {
  if (!isEmpty(id) && !isEmpty(pass)) {
    inputEl.disabled = false
  }
}

/**
 * 必須項目が入力されたとき、ボタンを活性化する。
 * @param id ログインID
 * @param pass パスワード　
 * @param inputEl ログインボタン
 */
let activatesButton = (id, pass, inputEl) => {
  if (!isEmpty(id) && !isEmpty(pass)) {
    inputEl.disabled = false;
    inputEl.classList.add('active');
    inputEl.classList.remove('active');
  }
}

/**
 * 入力された文字列の長さが上限に達するまで、文字列のカウントを行う。
 *
 * @param elString 文字数
 * @param inputEl カウント文字列
 * @param maxLength 最大文字数
 */
// javascriptでエラーメッセージを設定する方法はあるのか？
let countMaxLength = (elString, inputEl, maxLength) => {
  let length = inputEl.value.length;
  if (length <= maxLength) {
    document.getElementById(elString).innerHTML = length + '/' + maxLength;
  } else {

  }
}

document.addEventListener('DOMContentLoaded', function () {
  let id = document.getElementById("id");
  let pass = document.getElementById("pass");
  let inputEl = document.getElementById('login');
  console.log(isEmpty(id));
  console.log(isEmpty(pass));

  document.getElementById("length").innerHTML = '0/10';

  if (isEmpty(id) || isEmpty(pass)) {
    inputEl.disabled = true;
  }

  id.addEventListener("keyup" ,function () {
    activatesButton(id, pass, inputEl);
    countMaxLength("length", id, 10);
  });

  pass.addEventListener("keyup" ,function () {
    activatesButton(id, pass, inputEl);
  });
})

