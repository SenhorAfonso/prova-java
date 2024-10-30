package com.sirafonso.metting_room_reservation.adapters.out.persistence;

import com.sirafonso.metting_room_reservation.adapters.out.mapper.UserMapper;
import com.sirafonso.metting_room_reservation.adapters.out.repository.UserEntityRepository;
import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.UserEntity;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import com.sirafonso.metting_room_reservation.core.domain.exception.ResourceNotFoundException;
import com.sirafonso.metting_room_reservation.core.domain.models.UserModel;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserPersistenceAdapter implements UserPersistenceOutputPort {

    private final UserEntityRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserPersistenceAdapter(
            UserEntityRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserModelOut saveUser(UserModelIn newUser) {
        UserEntity userEntity = UserEntity.builder()
                .name(newUser.name())
                .username(newUser.username())
                .email(newUser.email())
                .password(newUser.password())
                .build();

        UserEntity savedUser = this.userRepository.save(userEntity);
        return this.userMapper.userEntityToUserModelOut(savedUser);
    }

    @Override
    public UserModelOut updateUserById(UUID userId, UserModelIn newUserData) {

        UserEntity updatedUser = this.userRepository.findById(userId)
            .map(user -> {
                user.setName(newUserData.name());
                user.setUsername(newUserData.username());
                user.setEmail(newUserData.email());
                user.setPassword(newUserData.password());
                return this.userRepository.save(user);
            }).orElseThrow(() -> new RuntimeException("TODO: Usuário não encontrado"));

        return this.userMapper.userEntityToUserModelOut(updatedUser);
    }

    @Override
    public void deleteUser(UUID userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public List<UserModelOut> findAllUsers() {
        List<UserModelOut> allUsers = this.userRepository.findAll().stream().map(this.userMapper::userEntityToUserModelOut).toList();

        if (allUsers.isEmpty()) throw new ResourceNotFoundException("There are no registered users.", "Users.userNotFound");

        return allUsers;
    }

    @Override
    public UserModelOut findUserById(UUID userId) {
        return null;
    }
}
