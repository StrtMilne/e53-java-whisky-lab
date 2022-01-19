package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findDistilleryByRegion(String region);

    List<Distillery> findDistilleryByWhiskiesAge(int age);

}
