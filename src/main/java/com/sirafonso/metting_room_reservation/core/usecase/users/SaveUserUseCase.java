package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.SaveUserInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;

public class SaveUserUseCase extends UsersBaseUseCase implements SaveUserInputPort {

    public SaveUserUseCase(UserPersistenceOutputPort userPersistenceAdapter) {
        super(userPersistenceAdapter);
    }

    @Override
    public UserModelOut execute(UserModelIn newUser) {
        return this.userPersistenceAdapter.saveUser(newUser);
    }
}
