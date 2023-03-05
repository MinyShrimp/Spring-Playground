package shrimp.playground.dynamicdoc.process;

@FunctionalInterface
public interface TagProcess {

    TagProcess DefaultProcess = () -> "";

    String process();
}
