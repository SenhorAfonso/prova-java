package com.sirafonso.metting_room_reservation.core.domain.dto.jobs;

import com.sirafonso.metting_room_reservation.core.domain.dto.users.UserModelOut;

import java.util.UUID;

public record JobModelOut (
    UUID id,
    String name,
    String end
) {
    public static class Builder {
        private UUID id;
        private String name;
        private String end;

        public JobModelOut.Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public JobModelOut.Builder name(String name) {
            this.name = name;
            return this;
        }

        public JobModelOut.Builder end(String end) {
            this.end = end;
            return this;
        }

        public JobModelOut build() {
            return new JobModelOut(
                    id,
                    name,
                    end
            );
        }
    }

    public static JobModelOut.Builder build() {
        return new JobModelOut.Builder();
    }
}
