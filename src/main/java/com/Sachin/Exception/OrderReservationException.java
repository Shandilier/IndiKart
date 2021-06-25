package com.Sachin.Exception;

public class OrderReservationException extends Exception{
    private String exception;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public OrderReservationException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "OrderReservationException{" +
                "exception='" + exception + '\'' +
                '}';
    }
}
