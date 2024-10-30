package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.FindAllUsersInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;
import org.springframework.data.domain.Page;

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
