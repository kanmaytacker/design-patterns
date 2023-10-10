package com.scaler.lld.design.assignments.facade.models;

public class BookingResult {

    private BookingStatus status;
    private BookingConfirmation confirmation;
    private String errorMessage;

    private BookingResult(BookingStatus status, BookingConfirmation confirmation, String errorMessage) {
        this.status = status;
        this.confirmation = confirmation;
        this.errorMessage = errorMessage;
    }

    public static BookingResult success(BookingConfirmation confirmation) {
        return new BookingResult(BookingStatus.SUCCESS, confirmation, null);
    }

    public static BookingResult notAvailable(String errorMessage) {
        return new BookingResult(BookingStatus.NOT_AVAILABLE, null, errorMessage);
    }

    public static BookingResult paymentFailed(String errorMessage) {
        return new BookingResult(BookingStatus.PAYMENT_FAILED, null, errorMessage);
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BookingConfirmation getConfirmation() {
        return confirmation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}