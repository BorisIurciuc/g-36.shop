package de.ait_tr.g_36_shop.exeption_handling.exeptions;

public class NoActiveProductsException extends RuntimeException{

  public NoActiveProductsException(String message){
    super(message);
  }
}