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

document.addEventListener('DOMContentLoaded', function () {
  let id = document.getElementById("id");
  let pass = document.getElementById("pass");
  let inputEl = document.getElementById('login');
  console.log(isEmpty(id));
  console.log(isEmpty(pass));

  if (isEmpty(id) || isEmpty(pass)) {
    inputEl.disabled = true;
  }

  id.addEventListener("keyup" ,function () {
    activatesButton(id, pass, inputEl);
  });

  pass.addEventListener("keyup" ,function () {
    activatesButton(id, pass, inputEl);
  });
})

