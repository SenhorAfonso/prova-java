package com.sirafonso.metting_room_reservation.adapters.out.repository.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobEntity job;
}
