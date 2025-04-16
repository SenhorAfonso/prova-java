package com.sirafonso.metting_room_reservation.core.domain.dto.jobs;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelIn;

public record JobModelIn (
    String name,
    String end
) {
    public static class Builder {
        private String name;
        private String end;

        public JobModelIn.Builder name(String name) {
            this.name = name;
            return this;
        }

        public JobModelIn.Builder end(String end) {
            this.end = end;
            return this;
        }

        public JobModelIn build() {
            return new JobModelIn(
                    name = this.name,
                    end = this.end
            );
        }
    }

    public static JobModelIn.Builder builder() {
        return new JobModelIn.Builder();
    }
}


