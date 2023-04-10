package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Citizenplan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenPlanRepository extends JpaRepository<Citizenplan, Integer> {

    @Query("select distinct(planName) from Citizenplan")
    public List<String> getPlanNames();

    @Query("select distinct(planStatus) from Citizenplan")
    public List<String> getPlanStatus();

}
