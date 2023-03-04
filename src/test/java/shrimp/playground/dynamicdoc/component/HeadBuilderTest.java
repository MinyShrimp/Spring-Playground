package shrimp.playground.dynamicdoc.component;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import shrimp.playground.dynamicdoc.types.Meta;
import shrimp.playground.dynamicdoc.types.MetaData;

import java.util.Locale;

@Slf4j
class HeadBuilderTest {

    @Test
    void nothingTest() {
        MetaData metaData = MetaData.MetaDataBuilder.builder().build();

        String header = HeadBuilder.build(metaData);
        Assertions.assertThat(header).isEqualTo(
                "<head ></head>"
        );
    }

    @Test
    void buildTest1() {
        MetaData metaData = MetaData.MetaDataBuilder.builder()
                .title("Spring API Docs")
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .build();

        String header = HeadBuilder.build(metaData);
        Assertions.assertThat(header).isEqualTo(
                "<head ><title>Spring API Docs</title><meta charset=\"UTF-8\"></head>"
        );
    }

    @Test
    void buildTest2() {
        MetaData metaData = MetaData.MetaDataBuilder.builder()
                .title("Spring API Docs")
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .addMeta(Meta.AUTHOR, "새우")
                .addMeta(Meta.KEYWORDS, "API")
                .addMeta(Meta.DESCRIPTION, "설명")
                .build();

        String header = HeadBuilder.build(metaData);
        Assertions.assertThat(header).isEqualTo(
                "<head ><title>Spring API Docs</title><meta charset=\"UTF-8\"><meta name=\"AUTHOR\" content=\"새우\"><meta name=\"KEYWORDS\" content=\"API\"><meta name=\"DESCRIPTION\" content=\"설명\"></head>"
        );
    }
}