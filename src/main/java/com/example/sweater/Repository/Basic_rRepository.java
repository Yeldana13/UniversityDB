package com.example.sweater.Repository;

import com.example.sweater.domain.Basic_r;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Basic_rRepository extends JpaRepository<Basic_r,Long> {
    @Query(value = "Select b from Basic_r b where b.prof1 like %:prof1% or b.prof2 like %:prof2%")
    List<Basic_r> findByProf1orProf2(@Param("prof1") String prof1, @Param("prof2") String prof2);
}
