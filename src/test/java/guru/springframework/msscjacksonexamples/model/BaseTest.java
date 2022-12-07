package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Modified by Pierrot on 2022-12-07.
 */
public class BaseTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JacksonTester<BeerDto> beerDtoJacksonTester;

    BeerDto getDto(){
        return  BeerDto.builder()
                .beerName("BeerName")
                .beerStyle("Ale")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(123123123123L)
                .myLocalDate(LocalDate.now())
                .build();
    }
}
