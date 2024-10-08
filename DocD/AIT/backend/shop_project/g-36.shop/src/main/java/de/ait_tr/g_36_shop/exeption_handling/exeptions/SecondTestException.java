package de.ait_tr.g_36_shop.exeption_handling.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// 2 способ обработки ошибок
// ПЛЮС - быстро и удобно без лишнего кода создаём
// глобальный обработчик данного исключения
// МИНУС - пользователь не видит ДЕТАЛИ сообщения об ошибке,
// следовательно, не понимает причин её возникновения
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SecondTestException extends RuntimeException {

  public SecondTestException(String message) {
    super(message);
  }

}
