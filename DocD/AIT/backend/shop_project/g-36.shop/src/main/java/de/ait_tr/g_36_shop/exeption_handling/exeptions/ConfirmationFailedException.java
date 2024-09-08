package de.ait_tr.g_36_shop.exeption_handling.exeptions;

public class ConfirmationFailedException extends RuntimeException{
  public ConfirmationFailedException(String message) {
    super(message);
  }
}
