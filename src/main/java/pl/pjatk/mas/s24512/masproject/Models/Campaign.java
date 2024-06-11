package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.StatusType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SizeType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;

import java.sql.Date;

public class Campaign {
    private String id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int currentRate;
    private boolean needsNewCreation;
    private SizeType size;
    private boolean isAnimated;
    private String creationDesc;
    private StatusType status;
    private SettlementType settlement;
    private String planId;
    private String clientId;
    private String plannerId;
    private String trafficId;
    private String designerId;
    private String accountantId;

    public Campaign(String id, String name, Date startDate, Date endDate, int currentRate, boolean needsNewCreation, SizeType size, boolean isAnimated, String creationDesc, StatusType status, SettlementType settlement, String planId, String clientId, String plannerId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentRate = currentRate;
        this.needsNewCreation = needsNewCreation;
        this.size = size;
        this.isAnimated = isAnimated;
        this.creationDesc = creationDesc;
        this.status = status;
        this.settlement = settlement;
        this.planId = planId;
        this.clientId = clientId;
        this.plannerId = plannerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(int currentRate) {
        this.currentRate = currentRate;
    }

    public boolean isNeedsNewCreation() {
        return needsNewCreation;
    }

    public void setNeedsNewCreation(boolean needsNewCreation) {
        this.needsNewCreation = needsNewCreation;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public String getCreationDesc() {
        return creationDesc;
    }

    public void setCreationDesc(String creationDesc) {
        this.creationDesc = creationDesc;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public SettlementType getSettlement() {
        return settlement;
    }

    public void setSettlement(SettlementType settlement) {
        this.settlement = settlement;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(String plannerId) {
        this.plannerId = plannerId;
    }

    public String getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(String trafficId) {
        this.trafficId = trafficId;
    }

    public String getDesignerId() {
        return designerId;
    }

    public void setDesignerId(String designerId) {
        this.designerId = designerId;
    }

    public String getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(String accountantId) {
        this.accountantId = accountantId;
    }

    public double calcCost(){
        return currentRate*Price.getPriceForSettlement(settlement);
    }

}
