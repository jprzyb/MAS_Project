package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.ChannelType;

public class Plan {
    private int estimatedRate;
    private String target;
    private ChannelType communicationChannel;
    private String campaignId;

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
}
