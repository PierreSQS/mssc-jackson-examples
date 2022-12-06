package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Modified by Pierrot on 2022-12-06.
 */
@ActiveProfiles("kebab")
@JsonTest
class BeerDtoKebabTest extends BaseTest {

    @Test
    void testKebab() throws IOException {
        BeerDto dto = getDto();

        JsonContent<BeerDto> beerDtoJsonContent = jacksonTester.write(dto);
        String json = objectMapper.writeValueAsString(dto);
        System.out.println(json);

        assertThat(beerDtoJsonContent).hasJsonPathStringValue("$.beerId");
        assertThat(beerDtoJsonContent).extractingJsonPathStringValue("$.beer-style").isEqualTo("Ale");

        assertThat(beerDtoJsonContent)
                .extractingJsonPathStringValue("$.created-date")
                .contains(LocalDate.now().toString());

    }
}
