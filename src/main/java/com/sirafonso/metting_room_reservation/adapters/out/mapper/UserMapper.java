package com.sirafonso.metting_room_reservation.adapters.out.mapper;

import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.UserEntity;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModelOut userEntityToUserModelOut(UserEntity userEntity) {
        if (userEntity == null) return null;

        return UserModelOut.build()
                .id(userEntity.getId())
                .cpf(userEntity.getCpf())
                .age(userEntity.getAge())
                .build();

    }

}
