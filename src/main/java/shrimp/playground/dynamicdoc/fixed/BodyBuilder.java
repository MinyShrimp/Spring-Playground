package shrimp.playground.dynamicdoc.fixed;

import lombok.RequiredArgsConstructor;
import shrimp.playground.dynamicdoc.TagProcess;
import shrimp.playground.dynamicdoc.types.Components;

@RequiredArgsConstructor
public class BodyBuilder {

    private final TagProcess process;

    public String build() {
        return Components.BODYSTART + process.process() + Components.BODYEND;
    }
}
