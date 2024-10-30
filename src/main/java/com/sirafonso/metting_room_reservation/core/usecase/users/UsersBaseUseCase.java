package com.sirafonso.metting_room_reservation.core.usecase.users;

import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;

public class UsersBaseUseCase {
    protected UserPersistenceOutputPort userPersistenceAdapter;

    public UsersBaseUseCase(
            UserPersistenceOutputPort userPersistenceAdapter
    ) {
        this.userPersistenceAdapter = userPersistenceAdapter;
    }
}
