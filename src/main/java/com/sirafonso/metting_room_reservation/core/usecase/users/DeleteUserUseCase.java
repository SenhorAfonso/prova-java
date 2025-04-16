package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.port.in.users.DeleteUserInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;

import java.util.UUID;

public class DeleteUserUseCase extends UsersBaseUseCase implements DeleteUserInputPort {

    public DeleteUserUseCase(UserPersistenceOutputPort userPersistenceAdapter) {
        super(userPersistenceAdapter);
    }

    @Override
    public void execute(UUID userId) {
        this.userPersistenceAdapter.deleteUser(userId);
    }
}
