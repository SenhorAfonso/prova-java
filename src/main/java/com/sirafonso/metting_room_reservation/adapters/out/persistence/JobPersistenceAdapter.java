package com.sirafonso.metting_room_reservation.adapters.out.persistence;

import com.sirafonso.metting_room_reservation.adapters.out.mapper.JobMapper;
import com.sirafonso.metting_room_reservation.adapters.out.repository.JobEntityRepository;
import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.JobEntity;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;
import com.sirafonso.metting_room_reservation.core.port.out.JobPersistenceOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobPersistenceAdapter implements JobPersistenceOutputPort {

    private final JobEntityRepository jobRepository;
    private final JobMapper jobMapper;

    @Autowired
    public JobPersistenceAdapter (
            JobEntityRepository jobRepository,
            JobMapper jobMapper
    ) {
        this.jobMapper = jobMapper;
        this.jobRepository = jobRepository;
    }

    @Override
    public JobModelOut createJob(JobModelIn newJob) {
        JobEntity entity = JobEntity.builder().end(newJob.end()).nome(newJob.name()).build();
        JobEntity job = this.jobRepository.save(entity);

        return this.jobMapper.jobEntityToModelOut()
    }
}
