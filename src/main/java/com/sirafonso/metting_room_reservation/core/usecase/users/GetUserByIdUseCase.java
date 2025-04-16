package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.users.FindUserByIdInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;

import java.util.UUID;

public class GetUserByIdUseCase extends UsersBaseUseCase implements FindUserByIdInputPort {

    public GetUserByIdUseCase(UserPersistenceOutputPort userPersistenceAdapter) {
        super(userPersistenceAdapter);
    }

    @Override
    public UserModelOut execute(UUID userId) {
        return this.userPersistenceAdapter.findUserById(userId);
    }
}
