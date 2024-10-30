package com.sirafonso.metting_room_reservation.adapters.in.web.controllers.exception;

import com.sirafonso.metting_room_reservation.core.domain.exception.APICustomError;
import com.sirafonso.metting_room_reservation.core.domain.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(APICustomError.class)
    public void handleApiCustomError(APICustomError ex) {
        System.out.println(ex.getMessage());
    }

}
