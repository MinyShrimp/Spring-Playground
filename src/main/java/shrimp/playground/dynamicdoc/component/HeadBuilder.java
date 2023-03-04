package shrimp.playground.dynamicdoc.component;


import shrimp.playground.dynamicdoc.types.Components;
import shrimp.playground.dynamicdoc.types.Meta;
import shrimp.playground.dynamicdoc.types.MetaData;

import java.util.Map;

public class HeadBuilder {

    public static String build(MetaData metaData) {

        StringBuilder builder = new StringBuilder(Components.HEADSTART).append(">");

        if (metaData.getTitle() != null) {
            builder.append("<title>")
                    .append(metaData.getTitle())
                    .append("</title>");
        }

        if (metaData.getCharset() != null) {
            builder.append("<meta charset=\"")
                    .append(metaData.getCharset())
                    .append("\">");
        }

        if (metaData.getMetas().size() != 0) {
            builder.append(MetaBuilder.build(metaData.getMetas()));
        }

        builder.append(Components.HEADEND);
        return builder.toString();
    }

    private static class MetaBuilder {
        public static String build(Map<Meta, String> metas) {
            StringBuilder builder = new StringBuilder();

            for (var entry : metas.entrySet()) {
                builder.append("<meta ")
                        .append("name=\"")
                        .append(entry.getKey())
                        .append("\" content=\"")
                        .append(entry.getValue())
                        .append("\">");
            }

            return builder.toString();
        }
    }
}
