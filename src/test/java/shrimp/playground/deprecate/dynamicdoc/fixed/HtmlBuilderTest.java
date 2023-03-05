package shrimp.playground.deprecate.dynamicdoc.fixed;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import shrimp.playground.deprecate.dynamicdoc.types.HeadMetaData.MetaDataBuilder;
import shrimp.playground.deprecate.dynamicdoc.types.Meta;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class HtmlBuilderTest {

    @Test
    void buildTest1() {
        HtmlBuilder builder = new HtmlBuilder(
                MetaDataBuilder.builder()
                        .lang(Locale.KOREA)
                        .charset("UTF-8")
                        .title("테스트")
                        .build()
        );

        assertThat(builder.build()).isEqualTo(
                "<!DOCTYPE HTML><html lang=\"ko_KR\"><head ><title>테스트</title><meta charset=\"UTF-8\"></head><body></body></html>"
        );
    }

    @Test
    void buildTest2() {
        HtmlBuilder builder = new HtmlBuilder(
                MetaDataBuilder.builder()
                        .lang(Locale.KOREA)
                        .charset("UTF-8")
                        .title("테스트")
                        .addMeta(Meta.AUTHOR, "새우")
                        .addMeta(Meta.DESCRIPTION, "설명")
                        .addMeta(Meta.KEYWORDS, "키워드")
                        .build()
        );

        assertThat(builder.build()).isEqualTo(
                "<!DOCTYPE HTML><html lang=\"ko_KR\"><head ><title>테스트</title><meta charset=\"UTF-8\"><meta name=\"author\" content=\"새우\"><meta name=\"keywords\" content=\"키워드\"><meta name=\"description\" content=\"설명\"></head><body></body></html>"
        );
    }

    @Test
    void noBuildTest() {
        HtmlBuilder builder = new HtmlBuilder(
                MetaDataBuilder.builder().build()
        );

        assertThat(builder.build()).isEqualTo(
                "<!DOCTYPE HTML><html ><head ></head><body></body></html>"
        );
    }
}