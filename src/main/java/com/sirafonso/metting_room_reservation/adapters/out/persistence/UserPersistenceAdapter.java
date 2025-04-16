package com.sirafonso.metting_room_reservation.adapters.out.persistence;

import com.sirafonso.metting_room_reservation.adapters.out.mapper.UserMapper;
import com.sirafonso.metting_room_reservation.adapters.out.repository.UserEntityRepository;
import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.UserEntity;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.domain.exception.ResourceNotFoundException;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
                .cpf(newUser.cpf())
                .age(newUser.age())
                .build();

        UserEntity savedUser = this.userRepository.save(userEntity);
        return this.userMapper.userEntityToUserModelOut(savedUser);
    }

    @Override
    public UserModelOut updateUserById(UUID userId, UserModelIn newUserData) {

        UserEntity updatedUser = this.userRepository.findById(userId)
            .map(user -> {
                user.setCpf(newUserData.cpf());
                user.setAge(newUserData.age());
                return this.userRepository.save(user);
            }).orElseThrow(() -> new RuntimeException("User not found"));

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
        UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found", "Users.userNotFound"));

        return this.userMapper.userEntityToUserModelOut(user);
    }
}
