package com.sirafonso.metting_room_reservation.core.domain.dto.users;

public record UserModelIn (
        String cpf,
        Integer age
) {
    public static class Builder {
        private String cpf;
        private int age;

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public UserModelIn build() {
            return new UserModelIn(
                    cpf = this.cpf,
                    age = this.age
            );
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
