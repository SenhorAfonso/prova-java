package com.sirafonso.metting_room_reservation.core.port.in;

import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;

import java.util.UUID;

public interface UpdateUserInputPort {
    UserModelOut execute(UUID userId, UserModelIn newUserData);
}
