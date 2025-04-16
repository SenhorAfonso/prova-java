package com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelIn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CreateUserRequest(
        String cpf,

        @Min(0)
        @Max(99)
        int age
) {
    public UserModelIn toUserModelIn() {
        return UserModelIn.builder()
                .cpf(this.cpf())
                .age(this.age())
                .build();
    }
}
