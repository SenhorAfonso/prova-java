package com.sirafonso.metting_room_reservation.core.port.out;

import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import com.sirafonso.metting_room_reservation.core.domain.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserPersistenceOutputPort {
    UserModelOut saveUser(UserModelIn newUser);
    UserModelOut updateUserById(UUID userId, UserModelIn newUserData);
    void deleteUser(UUID userId);
    List<UserModelOut> findAllUsers();
    UserModelOut findUserById(UUID userId);
}
