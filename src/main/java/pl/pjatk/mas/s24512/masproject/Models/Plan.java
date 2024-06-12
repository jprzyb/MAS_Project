package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.ChannelType;

public class Plan {
    private String id;
    private int estimatedRate;
    private String target;
    private ChannelType communicationChannel;
    private String campaignId;

    public Plan(String id, int estimatedRate, String target, ChannelType communicationChannel, String campaignId) {
        this.id = id;
        this.estimatedRate = estimatedRate;
        this.target = target;
        this.communicationChannel = communicationChannel;
        this.campaignId = campaignId;
    }

    public int getEstimatedRate() {
        return estimatedRate;
    }

    public void setEstimatedRate(int estimatedRate) {
        this.estimatedRate = estimatedRate;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public ChannelType getCommunicationChannel() {
        return communicationChannel;
    }

    public void setCommunicationChannel(ChannelType communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
