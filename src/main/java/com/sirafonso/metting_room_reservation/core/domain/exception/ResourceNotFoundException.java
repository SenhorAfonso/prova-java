package com.sirafonso.metting_room_reservation.core.domain.exception;

public class ResourceNotFoundException extends APICustomError {
    public ResourceNotFoundException(
        String message,
        String errorCode
    ) {
        super(message, 404, errorCode);
    }

}
