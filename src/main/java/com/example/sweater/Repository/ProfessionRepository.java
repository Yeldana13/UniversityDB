package com.example.sweater.Repository;

import com.example.sweater.domain.Basic;
import com.example.sweater.domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfessionRepository extends JpaRepository<Profession,Long>{

    @Query(value = "Select p from Profession p where p.key like %:sp%")
    List<Profession> findBySp(@Param("sp") String speciality);

}

