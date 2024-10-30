package com.sirafonso.metting_room_reservation.adapters.out.mapper;

import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.UserEntity;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import com.sirafonso.metting_room_reservation.core.domain.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModelOut userEntityToUserModelOut(UserEntity userEntity) {
        if (userEntity == null) return null;

        return UserModelOut.build()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();

    }

}
