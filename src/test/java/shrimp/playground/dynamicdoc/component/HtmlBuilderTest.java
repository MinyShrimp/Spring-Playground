package shrimp.playground.dynamicdoc.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import shrimp.playground.dynamicdoc.types.HeadMetaData.MetaDataBuilder;
import shrimp.playground.dynamicdoc.types.Meta;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class HtmlBuilderTest {

    @Test
    void buildTest1() {
        String html = HtmlBuilder.build(
                MetaDataBuilder.builder()
                        .lang(Locale.KOREA)
                        .charset("UTF-8")
                        .title("테스트")
                        .build()
        );

        assertThat(html).isEqualTo(
                "<!DOCTYPE HTML><html lang=\"ko_KR\"><head ><title>테스트</title><meta charset=\"UTF-8\"></head><body ></body></html>"
        );
    }

    @Test
    void buildTest2() {
        String html = HtmlBuilder.build(
                MetaDataBuilder.builder()
                        .lang(Locale.KOREA)
                        .charset("UTF-8")
                        .title("테스트")
                        .addMeta(Meta.AUTHOR, "새우")
                        .addMeta(Meta.DESCRIPTION, "설명")
                        .addMeta(Meta.KEYWORDS, "키워드")
                        .build()
        );

        assertThat(html).isEqualTo(
                "<!DOCTYPE HTML><html lang=\"ko_KR\"><head ><title>테스트</title><meta charset=\"UTF-8\"><meta name=\"author\" content=\"새우\"><meta name=\"keywords\" content=\"키워드\"><meta name=\"description\" content=\"설명\"></head><body ></body></html>"
        );
    }

    @Test
    void noBuildTest() {
        String html = HtmlBuilder.build(
                MetaDataBuilder.builder().build()
        );

        assertThat(html).isEqualTo(
                "<!DOCTYPE HTML><html ><head ></head><body ></body></html>"
        );
    }
}