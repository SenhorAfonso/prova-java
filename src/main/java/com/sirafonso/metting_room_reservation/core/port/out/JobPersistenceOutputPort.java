package com.sirafonso.metting_room_reservation.core.port.out;

import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;

public interface JobPersistenceOutputPort {
    JobModelOut createJob(JobModelIn newJob);
}
