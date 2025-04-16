package com.sirafonso.metting_room_reservation.core.port.in.users;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;

public interface SaveUserInputPort {
    UserModelOut execute(UserModelIn newUser);
}
