package pl.pjatk.mas.s24512.masproject.Repository;

public class Plan {
    private String id;
    private int estimatedRate;
    private String target;
    private CommunicationChannels communicationChannel;

    public Plan(String id, int estimatedRate, String target, CommunicationChannels communicationChannel) {
        this.id = id;
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
    public String getId() {
        return id;
    }

    public CommunicationChannels getCommunicationChannel() {
        return communicationChannel;
    }
}
