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

    public GeneralTag(String name) {
        this.metaData = GeneralMetaData.defaultGeneralMetaData(name);
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

        builder.append(">");

        for (GeneralTag child : children) {
            builder.append(child.build());
        }

        builder.append("</").append(metaData.getName()).append(">");
        return builder.toString();
    }
}