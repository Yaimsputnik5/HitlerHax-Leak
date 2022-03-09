package mod.hitlerhax.event.events;
public class HtlrEventStageable {

    private EventStage stage;

    public HtlrEventStageable() {

    }

    public HtlrEventStageable(EventStage stage) {
        this.stage = stage;
    }

    public EventStage getStage() {
        return stage;
    }

    public void setStage(EventStage stage) {
        this.stage = stage;
    }

    public enum EventStage {
        PRE, POST
    }

}