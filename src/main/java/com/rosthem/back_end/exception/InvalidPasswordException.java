package com.rosthem.back_end.exception;

// Excepción personalizada para contraseña no válida
public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException() {}

    public InvalidPasswordException(String message) {super(message);}

    public InvalidPasswordException(String message, Throwable cause) {super(message, cause);}
}
