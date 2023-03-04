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
public class MetaData {

    private Locale lang;
    private String title;
    private String charset;
    private Map<Meta, String> metas;

    private String id;
    private String className;

    public static class MetaDataBuilder {
        private Locale lang;
        private String title;
        private String charset;
        private Map<Meta, String> metas;

        private String id;
        private String className;

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

        public MetaDataBuilder metas(Map<Meta, String> metas) {
            this.metas = metas;
            return this;
        }

        public MetaDataBuilder addMeta(Meta key, String value) {
            this.metas.put(key, value);
            return this;
        }

        public MetaDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public MetaDataBuilder className(String className) {
            this.className = className;
            return this;
        }

        public MetaData build() {
            return new MetaData(
                    lang, title, charset, metas, id, className
            );
        }
    }
}
