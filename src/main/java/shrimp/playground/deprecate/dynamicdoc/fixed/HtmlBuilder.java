package shrimp.playground.deprecate.dynamicdoc.fixed;

import shrimp.playground.deprecate.dynamicdoc.process.TagProcess;
import shrimp.playground.deprecate.dynamicdoc.types.Components;
import shrimp.playground.deprecate.dynamicdoc.types.HeadMetaData;

public class HtmlBuilder {
    private final HeadMetaData headMetaData;
    private TagProcess tagProcess;

    public HtmlBuilder(HeadMetaData headMetaData) {
        this.headMetaData = headMetaData;
        this.tagProcess = TagProcess.DefaultProcess;
    }

    public HtmlBuilder(HeadMetaData headMetaData, TagProcess tagProcess) {
        this.headMetaData = headMetaData;
        this.tagProcess = tagProcess;
    }

    public void setTagProcess(TagProcess tagProcess) {
        this.tagProcess = tagProcess;
    }

    public String build() {
        //<!DOCTYPE html><html lang="ko">
        StringBuilder builder = new StringBuilder(Components.DOCTYPE).append(Components.HTMLSTART);

        if (headMetaData.getLang() != null) {
            builder.append("lang=\"").append(headMetaData.getLang().toString()).append("\"");
        }

        // <head> </head>
        builder.append(">").append(HeadBuilder.build(headMetaData));

        // <body> </body>
        BodyBuilder body = new BodyBuilder(tagProcess);
        builder.append(body.build());

        // </html>
        builder.append(Components.HTMLEND);
        return builder.toString();
    }
}
