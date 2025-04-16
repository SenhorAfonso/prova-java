package com.sirafonso.metting_room_reservation.adapters.out.repository;

import com.sirafonso.metting_room_reservation.adapters.out.repository.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobEntityRepository extends JpaRepository<JobEntity, UUID> { }