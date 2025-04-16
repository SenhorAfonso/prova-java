package com.sirafonso.metting_room_reservation.adapters.in.web.controllers.dto.request.jobs;

import com.sirafonso.metting_room_reservation.core.domain.dto.jobs.JobModelIn;

public record CreateJobRequest(
    String name,
    String end
) {
    public JobModelIn toUserModelIn() {
        return JobModelIn.builder()
                .name(this.name())
                .end(this.end())
                .build();
    }
}
