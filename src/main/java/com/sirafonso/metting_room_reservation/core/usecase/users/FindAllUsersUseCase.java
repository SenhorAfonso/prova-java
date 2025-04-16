package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.users.FindAllUsersInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;

import java.util.List;

public class FindAllUsersUseCase extends UsersBaseUseCase implements FindAllUsersInputPort {

    public FindAllUsersUseCase(UserPersistenceOutputPort userPersistenceAdapter) {
        super(userPersistenceAdapter);
    }

    @Override
    public List<UserModelOut> execute() {
        return this.userPersistenceAdapter.findAllUsers();
    }
}
