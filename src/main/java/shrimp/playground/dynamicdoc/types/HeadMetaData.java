package shrimp.playground.dynamicdoc.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class HeadMetaData {

    private Locale lang;
    private String title;
    private String charset;
    private Map<Meta, String> metas;

    public static HeadMetaData defaultHeadMetaData() {
        return MetaDataBuilder.builder()
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .build();
    }

    public static class MetaDataBuilder {
        private final Map<Meta, String> metas;
        private Locale lang;
        private String title;
        private String charset;

        private MetaDataBuilder() {
            this.metas = new EnumMap<>(Meta.class);
        }

        public static MetaDataBuilder builder() {
            return new MetaDataBuilder();
        }

        public MetaDataBuilder lang(Locale lang) {
            this.lang = lang;
            return this;
        }

        public MetaDataBuilder title(String title) {
            this.title = title;
            return this;
        }

        public MetaDataBuilder charset(String charset) {
            this.charset = charset;
            return this;
        }

        public MetaDataBuilder addMeta(Meta key, String value) {
            this.metas.put(key, value);
            return this;
        }

        public HeadMetaData build() {
            return new HeadMetaData(
                    lang, title, charset, metas
            );
        }
    }
}
