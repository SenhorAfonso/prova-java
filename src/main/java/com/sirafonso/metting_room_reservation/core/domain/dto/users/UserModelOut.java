package com.sirafonso.metting_room_reservation.core.domain.dto.users;

import java.util.UUID;

public record UserModelOut(
        UUID id,
        String cpf,
        int age
) {
    public static class Builder {
        private UUID id;
        private String cpf;
        private int age;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }
        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public UserModelOut build() {
            return new UserModelOut(
                    id,
                    cpf,
                    age
            );
        }
    }

    public static Builder build() {
        return new Builder();
    }
}
