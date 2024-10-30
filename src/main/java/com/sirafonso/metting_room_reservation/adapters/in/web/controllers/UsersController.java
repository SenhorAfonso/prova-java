package com.sirafonso.metting_room_reservation.adapters.in.web.controllers;

import com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.CreateUserRequest;
import com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.UpdateUserRequest;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.DeleteUserInputPort;
import com.sirafonso.metting_room_reservation.core.port.in.FindAllUsersInputPort;
import com.sirafonso.metting_room_reservation.core.port.in.SaveUserInputPort;
import com.sirafonso.metting_room_reservation.core.port.in.UpdateUserInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public UsersController(
            SaveUserInputPort saveUserUseCase,
            FindAllUsersInputPort findAllUsersUseCase,
            UpdateUserInputPort updateUserUseCase,
            DeleteUserInputPort deleteUserUseCase
    ) {
        this.saveUserUseCase = saveUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PostMapping
    UserModelOut createUser(@Valid @RequestBody CreateUserRequest newUser) {
        return this.saveUserUseCase.execute(newUser.toUserModelIn());
    }

    @GetMapping
    List<UserModelOut> findAllUsers() {
        return this.findAllUsersUseCase.execute();
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
