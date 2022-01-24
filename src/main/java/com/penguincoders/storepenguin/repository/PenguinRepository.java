package com.penguincoders.storepenguin.repository;

import com.penguincoders.storepenguin.model.Penguin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenguinRepository extends JpaRepository<Penguin,Integer> {
}
