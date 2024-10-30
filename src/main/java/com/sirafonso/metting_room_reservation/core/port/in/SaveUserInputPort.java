package com.sirafonso.metting_room_reservation.core.port.in;

// TODO: adicionar tipo de erro que pode ser retornado
// TODO: adicionar tipo de retorno específico
// TODO: adicionar tipo de payload

import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;

public interface SaveUserInputPort {
    UserModelOut execute(UserModelIn newUser);
}
