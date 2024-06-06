package pl.pjatk.mas.s24512.masproject.Repository;

import java.sql.Date;

public class Campaign {
    private String id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int currentRate;
    private boolean needsNewCreation;
    private CreationType size;
    private boolean isAnimated;
    private String creationDescription;
    private CampaignStatus status;
    private String plannerId;
    private String trafficId;
    private String clientId;
    private String planId;
    private String designerId;

    public Campaign(String id, String name, Date startDate, Date endDate, int currentRate, boolean needsNewCreation, CreationType size, boolean isAnimated, String creationDescription, CampaignStatus status, String plannerId, String trafficId, String clientId, String planId, String designerId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentRate = currentRate;
        this.needsNewCreation = needsNewCreation;
        this.size = size;
        this.isAnimated = isAnimated;
        this.creationDescription = creationDescription;
        this.status = status;
        this.plannerId = plannerId;
        this.trafficId = trafficId;
        this.clientId = clientId;
        this.planId = planId;
        this.designerId = designerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCurrentRate() {
        return currentRate;
    }

    public boolean needsNewCreation() {
        return needsNewCreation;
    }

    public CreationType getSize() {
        return size;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public String getCreationDescription() {
        return creationDescription;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public String getPlannerId() {
        return plannerId;
    }

    public String getTrafficId() {
        return trafficId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPlanId() {
        return planId;
    }

    public String getDesignerId() {
        return designerId;
    }

    @Override
    public String toString(){
        return name;
    }
}
