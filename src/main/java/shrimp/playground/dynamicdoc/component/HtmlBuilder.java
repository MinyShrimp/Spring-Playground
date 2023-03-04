package shrimp.playground.dynamicdoc.component;

import shrimp.playground.dynamicdoc.types.Components;
import shrimp.playground.dynamicdoc.types.HeadMetaData;

public class HtmlBuilder {

    public static String build(
            HeadMetaData headMetaData
    ) {
        //<!DOCTYPE html><html lang="ko">
        StringBuilder builder = new StringBuilder(Components.DOCTYPE).append(Components.HTMLSTART);

        if (headMetaData.getLang() != null) {
            builder.append("lang=\"").append(headMetaData.getLang().toString()).append("\"");
        }

        // <head> </head>
        builder.append(">").append(HeadBuilder.build(headMetaData));

        // <body> </body>
        builder.append(BodyBuilder.build());

        // </html>
        builder.append(Components.HTMLEND);
        return builder.toString();
    }
}
