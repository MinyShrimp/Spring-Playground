package shrimp.playground.dynamicdoc.component;

import shrimp.playground.dynamicdoc.MainTag;
import shrimp.playground.dynamicdoc.types.Components;

public class BodyBuilder {

    private static MainTag MAIN = new MainTag();

    public static String build() {
        StringBuilder builder = new StringBuilder(Components.BODYSTART);

        builder.append(">");

        builder.append(MAIN.process());

        builder.append(Components.BODYEND);
        return builder.toString();
    }
}
