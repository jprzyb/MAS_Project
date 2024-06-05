package pl.pjatk.mas.s24512.masproject.Repository;

public class Plan {
    private int estimatedRate;
    private String target;
    private CommunicationChannels communicationChannel;

    public Plan(int estimatedRate, String target, CommunicationChannels communicationChannel) {
        this.estimatedRate = estimatedRate;
        this.target = target;
        this.communicationChannel = communicationChannel;
    }

    public int getEstimatedRate() {
        return estimatedRate;
    }

    public String getTarget() {
        return target;
    }

    public CommunicationChannels getCommunicationChannel() {
        return communicationChannel;
    }
}
