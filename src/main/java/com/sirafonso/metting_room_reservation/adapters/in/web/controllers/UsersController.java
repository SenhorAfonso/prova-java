package com.sirafonso.metting_room_reservation.adapters.in.web.controllers;

import com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.users.CreateUserRequest;
import com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.users.UpdateUserRequest;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.users.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UsersController {

    private final SaveUserInputPort saveUserUseCase;
    private final FindAllUsersInputPort findAllUsersUseCase;
    private final UpdateUserInputPort updateUserUseCase;
    private final DeleteUserInputPort deleteUserUseCase;
    private final FindUserByIdInputPort findUserByIdUseCase;

    public UsersController(
            SaveUserInputPort saveUserUseCase,
            FindAllUsersInputPort findAllUsersUseCase,
            UpdateUserInputPort updateUserUseCase,
            DeleteUserInputPort deleteUserUseCase,
            FindUserByIdInputPort findUserByIdUseCase
    ) {
        this.saveUserUseCase = saveUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
    }

    @PostMapping
    UserModelOut createUser(@Valid @RequestBody CreateUserRequest newUser) {
        return this.saveUserUseCase.execute(newUser.toUserModelIn());
    }

    @GetMapping
    List<UserModelOut> findAllUsers() {
        return this.findAllUsersUseCase.execute();
    }

    @GetMapping("/{userId}")
    UserModelOut getUserById(@PathVariable UUID userId) {
        return this.findUserByIdUseCase.execute(userId);
    }

    @PutMapping("/{userId}")
    public UserModelOut updateUser(
            @PathVariable UUID userId,
            @Valid @RequestBody UpdateUserRequest newUserData
    ) {
        return this.updateUserUseCase.execute(userId, newUserData.toUserModelIn());
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable UUID userId) {
        this.deleteUserUseCase.execute(userId);
    }

}
