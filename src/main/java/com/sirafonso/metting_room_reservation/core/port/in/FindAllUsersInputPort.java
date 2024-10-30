package com.sirafonso.metting_room_reservation.core.port.in;

import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FindAllUsersInputPort {
    List<UserModelOut> execute();
}
