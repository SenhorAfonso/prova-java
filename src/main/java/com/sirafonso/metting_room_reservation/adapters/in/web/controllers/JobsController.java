package com.sirafonso.metting_room_reservation.adapters.in.web.controllers;

import com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.jobs.CreateJobRequest;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;
import com.sirafonso.metting_room_reservation.core.domain.models.UserModel;
import com.sirafonso.metting_room_reservation.core.port.in.jobs.CreateJobInputPort;
import com.sirafonso.metting_room_reservation.core.port.in.users.SaveUserInputPort;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jobs")
public class JobsController {

    private final CreateJobInputPort createJobUseCase;

    public JobsController(
        CreateJobInputPort createJobUseCase
    ) {
        this.createJobUseCase = createJobUseCase;
    }

    @PostMapping
    JobModelOut createJob(@RequestBody CreateJobRequest newJob) {
        return this.createJobUseCase.execute(newJob.toUserModelIn());
    }

}
