package com.sirafonso.metting_room_reservation.adapters.out.mapper;

import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.JobEntity;
import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.UserEntity;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;
import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;

public class JobMapper {

    JobModelOut jobEntityToModelOut(JobEntity job) {
        return JobModelOut.build()
                .end(job.getEnd())
                .name(job.getNome())
                .build();
    }
}
