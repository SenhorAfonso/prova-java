package com.sirafonso.metting_room_reservation.config;

import com.sirafonso.metting_room_reservation.core.port.in.users.*;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;
import com.sirafonso.metting_room_reservation.core.usecase.users.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputPortInjection {

    private UserPersistenceOutputPort userPersistenceAdapter;

    public InputPortInjection(
            UserPersistenceOutputPort userPersistenceAdapter
    ) {
        this.userPersistenceAdapter = userPersistenceAdapter;
    }

    @Bean
    public SaveUserInputPort saveUser() {
        return new SaveUserUseCase(this.userPersistenceAdapter);
    }

    @Bean
    public FindAllUsersInputPort findAllUsers() {
        return new FindAllUsersUseCase(this.userPersistenceAdapter);
    }

    @Bean
    public UpdateUserInputPort updateUser() {
        return new UpdateUserUseCase(this.userPersistenceAdapter);
    }

    @Bean
    public DeleteUserInputPort deleteUser() {
        return new DeleteUserUseCase(this.userPersistenceAdapter);
    }

    @Bean
    public FindUserByIdInputPort findUserById() { return new GetUserByIdUseCase(this.userPersistenceAdapter);
    };
}
