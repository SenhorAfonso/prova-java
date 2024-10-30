package com.sirafonso.metting_room_reservation.core.domain.exception;

public class APICustomError extends RuntimeException {
    protected int httpStatus;
    protected  String errorCode;

    public APICustomError(
        String message,
        Integer httpStatus,
        String errorCode
    ) {
        super(message);
        this.httpStatus = (httpStatus != null) ? httpStatus : 500;
        this.errorCode = errorCode;
    }
}
