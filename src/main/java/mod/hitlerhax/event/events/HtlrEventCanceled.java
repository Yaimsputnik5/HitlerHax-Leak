package mod.hitlerhax.event.events;
public class HtlrEventCanceled extends HtlrEventStageable {

    private boolean canceled;

    public HtlrEventCanceled() {
    }

    public HtlrEventCanceled(EventStage stage) {
        super(stage);
    }

    public HtlrEventCanceled(EventStage stage, boolean canceled) {
        super(stage);
        this.canceled = canceled;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}