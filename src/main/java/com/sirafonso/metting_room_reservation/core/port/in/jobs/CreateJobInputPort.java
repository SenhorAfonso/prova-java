package com.sirafonso.metting_room_reservation.core.port.in.jobs;

import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelIn;
import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelOut;

public interface CreateJobInputPort {
    JobModelOut execute(JobModelIn newJob);
}
