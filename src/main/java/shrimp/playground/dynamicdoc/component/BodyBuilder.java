package shrimp.playground.dynamicdoc.component;

import shrimp.playground.dynamicdoc.types.Components;

public class BodyBuilder {

    public static String build() {
        StringBuilder builder = new StringBuilder(Components.BODYSTART);

        builder.append(">");

        builder.append(Components.BODYEND);
        return builder.toString();
    }
}
