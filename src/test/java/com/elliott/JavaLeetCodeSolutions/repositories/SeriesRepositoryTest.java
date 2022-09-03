package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.Series;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository underTest;

    @Test
    public void getByNaturalIdTest(){
        //GIVEN
        String EXAMPLE_NAME = "BOB";
        Series series = new Series(EXAMPLE_NAME);

        //WHEN
        underTest.save(series);
       // Series foundSeries = underTest.
    }
}
