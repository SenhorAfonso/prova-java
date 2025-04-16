package com.sirafonso.metting_room_reservation.core.port.in.users;

import java.util.UUID;

public interface DeleteUserInputPort {
    void execute(UUID userId);
}
