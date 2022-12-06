package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Pierrot on 2022-12-06.
 */
@ActiveProfiles("kebab")
@JsonTest
class BeerDtoKebabTest extends BaseTest {

    @Test
    void testKebap() throws IOException {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);

        assertThat(this.jacksonTester.write(dto)).hasJsonPathStringValue("beer-name");

        assertThat(this.jacksonTester.write(dto))
                .extractingJsonPathStringValue("$.beer-name")
                .isEqualTo("BeerName");

        assertThat(this.jacksonTester.write(dto))
                .extractingJsonPathStringValue("$.beer-style")
                .isEqualTo("Ale");

        System.out.println(json);
    }
}
