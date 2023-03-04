package shrimp.playground.dynamicdoc.component;

import shrimp.playground.dynamicdoc.types.GeneralMetaData;

import java.util.LinkedList;
import java.util.List;

public class Tag {

    private final GeneralMetaData metaData;
    private final List<Tag> children;

    private Tag(GeneralMetaData metaData) {
        this.metaData = metaData;
        this.children = new LinkedList<>();
    }

    public static Tag builder(GeneralMetaData metaData) {
        return new Tag(metaData);
    }

    public Tag addChild(Tag child) {
        this.children.add(child);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder("<").append(metaData.getName()).append(" ");

        if (metaData.getId() != null) {
            builder.append("id=\"").append(metaData.getId()).append("\" ");
        }

        if (metaData.getClassName() != null) {
            builder.append("id=\"").append(metaData.getClassName()).append("\" ");
        }

        builder.append(">");

        for (Tag child : children) {
            builder.append(child.build());
        }

        builder.append("</").append(metaData.getName()).append(">");
        return builder.toString();
    }
}