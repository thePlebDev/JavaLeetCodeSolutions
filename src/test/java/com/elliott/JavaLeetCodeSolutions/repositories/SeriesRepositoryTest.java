package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.Series;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository underTest;

//    @Test
//    public void getByNaturalIdTest(){
//        //GIVEN
//        String EXAMPLE_TITLE = "BOB";
//        Series series = new Series(EXAMPLE_TITLE);
//
//        //WHEN
//        underTest.save(series);
//        Series foundSeries = underTest.findByTitle(EXAMPLE_TITLE);
//
//        //THEN
//        assertThat(foundSeries.getTitle()).isEqualTo(EXAMPLE_TITLE);
//
//    }
}
