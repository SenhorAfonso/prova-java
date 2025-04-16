package com.sirafonso.metting_room_reservation.core.port.in.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;

import java.util.List;

public interface FindAllUsersInputPort {
    List<UserModelOut> execute();
}
