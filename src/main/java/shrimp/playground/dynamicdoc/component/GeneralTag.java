package shrimp.playground.dynamicdoc.component;

import shrimp.playground.dynamicdoc.types.GeneralMetaData;

import java.util.LinkedList;
import java.util.List;

public class GeneralTag {

    private final GeneralMetaData metaData;
    private final List<GeneralTag> children;

    public GeneralTag(GeneralMetaData metaData) {
        this.metaData = metaData;
        this.children = new LinkedList<>();
    }

    public GeneralTag(String name, String content) {
        this.metaData = new GeneralMetaData(name, content);
        this.children = new LinkedList<>();
    }

    public GeneralTag addChild(GeneralTag child) {
        this.children.add(child);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder("<").append(metaData.getName()).append(" ");

        if (metaData.getId() != null) {
            builder.append("id=\"").append(metaData.getId()).append("\" ");
        }

        if (metaData.getClassName() != null) {
            builder.append("class=\"").append(metaData.getClassName()).append("\" ");
        }

        builder.append(">\n");

        if (metaData.getContent() != null) {
            builder.append(metaData.getContent()).append("\n");
        }

        for (GeneralTag child : children) {
            builder.append(child.build());
        }

        return builder.append("</").append(metaData.getName()).append(">\n").toString();
    }
}