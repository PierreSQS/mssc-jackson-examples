package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Modified by Pierrot on 2022-12-07.
 */
@JsonTest
class BeerDtoTest extends BaseTest{

    @Test
    void testSerializeDto() throws IOException {
        BeerDto beerDto = getDto();
        JsonContent<BeerDto> beerDtoJsonContent = beerDtoJacksonTester.write(beerDto);

        String jsonString = objectMapper.writeValueAsString(beerDto);

        assertThat(beerDtoJsonContent).hasJsonPathStringValue("$.createdDate");

        assertThat(beerDtoJsonContent)
                .extractingJsonPathStringValue("$.createdDate")
                .contains(LocalDate.now().toString());

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2019-06-03T21:01:53-0400\",\"lastUpdatedDate\":\"2019-06-03T21:01:53.628287-04:00\",\"myLocalDate\":\"20190603\",\"beerId\":\"8ed4c7eb-ef3a-437e-823e-a26497ed7e71\"}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        assertThat(dto.getCreatedDate().toString()).contains("2019-06-04T01:01");

        System.out.println(dto);

    }
}