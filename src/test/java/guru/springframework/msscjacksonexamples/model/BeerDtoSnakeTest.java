package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jt on 2019-06-02.
 */
@ActiveProfiles("snake")
@JsonTest
class BeerDtoSnakeTest extends BaseTest {

    @Test
    void testSnake() throws IOException {
        BeerDto dto = getDto();
        JsonContent<BeerDto> beerDtoJsonContent = beerDtoJacksonTester.write(dto);

        String json = objectMapper.writeValueAsString(dto);
        System.out.println(json);

        assertThat(beerDtoJsonContent).hasJsonPathStringValue("$.created_date");

        LocalDate date = LocalDate.now();
        DateTimeFormatter yyyyMMddFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String text = date.format(yyyyMMddFormatter);

        assertThat(beerDtoJsonContent).extractingJsonPathValue("$.my_local_date")
                .isEqualTo(text);
    }
}
