package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.users.UpdateUserInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;

import java.util.UUID;

public class UpdateUserUseCase extends UsersBaseUseCase implements UpdateUserInputPort {

    public UpdateUserUseCase(UserPersistenceOutputPort userPersistenceAdapter) {
        super(userPersistenceAdapter);
    }

    @Override
    public UserModelOut execute(UUID userId, UserModelIn newUserData) {
        return this.userPersistenceAdapter.updateUserById(userId, newUserData);
    }
}
