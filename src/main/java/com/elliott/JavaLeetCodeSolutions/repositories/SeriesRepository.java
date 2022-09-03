package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {
}
