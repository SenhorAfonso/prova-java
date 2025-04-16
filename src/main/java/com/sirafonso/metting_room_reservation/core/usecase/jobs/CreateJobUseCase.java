package com.sirafonso.metting_room_reservation.core.usecase.jobs;

import com.sirafonso.metting_room_reservation.adapters.out.persistence.JobPersistenceAdapter;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;
import com.sirafonso.metting_room_reservation.core.port.in.jobs.CreateJobInputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateJobUseCase implements CreateJobInputPort {
    @Autowired
    private final JobPersistenceAdapter jobPersistenceAdapter;

    public CreateJobUseCase (JobPersistenceAdapter jobPersistenceAdapter) {
        this.jobPersistenceAdapter = jobPersistenceAdapter;
    }

    @Override
    public JobModelOut execute(JobModelIn newJob) {
        return this.jobPersistenceAdapter.createJob(newJob);
    }
}
