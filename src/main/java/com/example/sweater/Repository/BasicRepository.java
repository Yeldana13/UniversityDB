package com.example.sweater.Repository;

import com.example.sweater.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BasicRepository extends JpaRepository<Basic,Long> {

    @Query(value = "Select b from Basic b where b.speciality like %:sp% and b.city like %:city%")
    List<Basic> findBySpecialityAndCity(@Param("sp") String speciality, @Param("city") String city);

    @Transactional
    @Query(value = "Select b from Basic b where b.speciality like %:sp%")
    List<Basic> findBySp(@Param("sp") String speciality);

    @Transactional
    @Query(value = "Select b from Basic b where b.name like %:name%")
    List<Basic> findByName(@Param("name") String name);

    @Transactional
    @Query(value = "Select b from Basic b " +
            "where b.name like %:value% " +
            " or b.university like %:value% " +
            " or b.university_id like %:value% " +
            " or b.street like %:value%" +
            " or b.number like %:value%" +
            " or b.url like %:value%" +
            " or b.city like %:value%" +
            " or b.speciality like %:value%")
    List<Basic> findByAll(@Param("value") String value);
}
