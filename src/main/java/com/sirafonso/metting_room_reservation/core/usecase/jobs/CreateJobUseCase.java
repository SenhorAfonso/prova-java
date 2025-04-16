package com.sirafonso.metting_room_reservation.core.usecase.jobs;

import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.jobs.CreateJobInputPort;
import com.sirafonso.metting_room_reservation.core.port.in.users.SaveUserInputPort;
import com.sirafonso.metting_room_reservation.core.port.out.UserPersistenceOutputPort;
import com.sirafonso.metting_room_reservation.core.usecase.users.UsersBaseUseCase;

public class CreateJobUseCase implements CreateJobInputPort {
    public CreateJobUseCase(JobPersistenceAdapter jobPersistenceAdapter) { super(jobPersistenceAdapter); }

    @Override
    public JobModelOut execute(JobModelIn newJob) {
        return this.jobPersistenceAdapter.
    }
}


public class SaveUserUseCase extends UsersBaseUseCase implements SaveUserInputPort {

    public SaveUserUseCase(UserPersistenceOutputPort userPersistenceAdapter) {
        super(userPersistenceAdapter);
    }

    @Override
    public UserModelOut execute(UserModelIn newUser) {
        return this.userPersistenceAdapter.saveUser(newUser);
    }
}
