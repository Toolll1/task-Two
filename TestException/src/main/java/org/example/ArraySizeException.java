package org.example;

public class ArraySizeException extends Exception {

    public ArraySizeException() {

        super("В ArrayList не может быть больше 10 элементов");
    }

    public ArraySizeException(String message) {  // передача короткого описания ошибки

        super(message);
    }

    public ArraySizeException(final String message, final Throwable cause) {  //передача текста об ошибке и информации о её причине

        super(message, cause);
    }

    public ArraySizeException(final Throwable cause) {  //только с информацией о причине

        super(cause);
    }

    protected ArraySizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {

        return "В ArrayList не может быть больше 10 элементов";
    }

    @Override
    public String getLocalizedMessage() {

        return getMessage();
    }

    @Override
    public void printStackTrace() {
        System.out.println("Мой StackTrace");
    }
}