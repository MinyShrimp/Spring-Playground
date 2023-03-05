package shrimp.playground.deprecate.dynamicdoc.fixed;


import shrimp.playground.deprecate.dynamicdoc.types.Components;
import shrimp.playground.deprecate.dynamicdoc.types.HeadMetaData;
import shrimp.playground.deprecate.dynamicdoc.types.Meta;

import java.util.Map;

public class HeadBuilder {

    public static String build(HeadMetaData headMetaData) {

        StringBuilder builder = new StringBuilder(Components.HEADSTART).append(">");

        if (headMetaData.getTitle() != null) {
            builder.append("<title>")
                    .append(headMetaData.getTitle())
                    .append("</title>");
        }

        if (headMetaData.getCharset() != null) {
            builder.append("<meta charset=\"")
                    .append(headMetaData.getCharset())
                    .append("\">");
        }

        if (headMetaData.getMetas().size() != 0) {
            builder.append(MetaBuilder.build(headMetaData.getMetas()));
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
                        .append(entry.getKey().getDescription())
                        .append("\" content=\"")
                        .append(entry.getValue())
                        .append("\">");
            }

            return builder.toString();
        }
    }
}
