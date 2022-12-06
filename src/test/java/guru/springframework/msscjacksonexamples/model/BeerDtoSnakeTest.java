package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Modified by jt on 2022-12-06.
 */
@ActiveProfiles("snake")
@JsonTest
class BeerDtoSnakeTest extends BaseTest {

    @Test
    void testSnake() throws IOException {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);
        System.out.println(json);

        assertThat(jacksonTester.write(dto)).hasJsonPathStringValue("$.beer_name");
    }
}
