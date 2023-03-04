package shrimp.playground.dynamicdoc.fixed;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import shrimp.playground.dynamicdoc.types.HeadMetaData;
import shrimp.playground.dynamicdoc.types.Meta;

import java.util.Locale;

@Slf4j
class HeadBuilderTest {

    @Test
    void nothingTest() {
        HeadMetaData headMetaData = HeadMetaData.MetaDataBuilder.builder().build();

        String header = HeadBuilder.build(headMetaData);
        Assertions.assertThat(header).isEqualTo(
                "<head ></head>"
        );
    }

    @Test
    void buildTest1() {
        HeadMetaData headMetaData = HeadMetaData.MetaDataBuilder.builder()
                .title("Spring API Docs")
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .build();

        String header = HeadBuilder.build(headMetaData);
        Assertions.assertThat(header).isEqualTo(
                "<head ><title>Spring API Docs</title><meta charset=\"UTF-8\"></head>"
        );
    }

    @Test
    void buildTest2() {
        HeadMetaData headMetaData = HeadMetaData.MetaDataBuilder.builder()
                .title("Spring API Docs")
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .addMeta(Meta.AUTHOR, "새우")
                .addMeta(Meta.KEYWORDS, "API")
                .addMeta(Meta.DESCRIPTION, "설명")
                .build();

        String header = HeadBuilder.build(headMetaData);
        Assertions.assertThat(header).isEqualTo(
                "<head ><title>Spring API Docs</title><meta charset=\"UTF-8\"><meta name=\"author\" content=\"새우\"><meta name=\"keywords\" content=\"API\"><meta name=\"description\" content=\"설명\"></head>"
        );
    }
}