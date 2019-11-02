package com.greencompanions.v1.store;

import javax.persistence.*;
import java.util.*;

@Entity(name = "green_companions")
@Table(name = "green_companions")
public class GreenCompanionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private Date sowingPeriodStart;
    private Date sowingPeriodEnd;
    private Date growPeriodStart;
    private Date growPeriodEnd;
    private Date harvestPeriodStart;
    private Date harvestPeriodEnd;
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;


    @OneToMany()
    @JoinTable(name = "good_companions")
    private Set<GreenCompanionDTO> goodCompanions;

    @OneToMany()
    @JoinTable(name = "bad_companions")
    private Set<GreenCompanionDTO> badCompanions;

    public GreenCompanionDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSowingPeriodStart() {
        return sowingPeriodStart;
    }

    public void setSowingPeriodStart(Date sowingPeriodStart) {
        this.sowingPeriodStart = sowingPeriodStart;
    }

    public Date getSowingPeriodEnd() {
        return sowingPeriodEnd;
    }

    public void setSowingPeriodEnd(Date sowingPeriodEnd) {
        this.sowingPeriodEnd = sowingPeriodEnd;
    }

    public Date getGrowPeriodStart() {
        return growPeriodStart;
    }

    public void setGrowPeriodStart(Date growPeriodStart) {
        this.growPeriodStart = growPeriodStart;
    }

    public Date getGrowPeriodEnd() {
        return growPeriodEnd;
    }

    public void setGrowPeriodEnd(Date growPeriodEnd) {
        this.growPeriodEnd = growPeriodEnd;
    }

    public Date getHarvestPeriodStart() {
        return harvestPeriodStart;
    }

    public void setHarvestPeriodStart(Date harvestPeriodStart) {
        this.harvestPeriodStart = harvestPeriodStart;
    }

    public Date getHarvestPeriodEnd() {
        return harvestPeriodEnd;
    }

    public void setHarvestPeriodEnd(Date harvestPeriodEnd) {
        this.harvestPeriodEnd = harvestPeriodEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GreenCompanionDTO> getGoodCompanions() {
        return goodCompanions;
    }

    public void setGoodCompanions(Set<GreenCompanionDTO> goodCompanions) {
        this.goodCompanions = goodCompanions;
    }

    public void addGoodCompanion(GreenCompanionDTO goodCompanion) {
        this.goodCompanions.add(goodCompanion);
    }

    public void removeGoodCompanion(GreenCompanionDTO goodCompanion) {
        this.goodCompanions.remove(goodCompanion);
    }

    public Set<GreenCompanionDTO> getBadCompanions() {
        return badCompanions;
    }

    public void setBadCompanions(Set<GreenCompanionDTO> badCompanions) {
        this.badCompanions = badCompanions;
    }

    public void addBadCompanion(GreenCompanionDTO badCompanion) {
        this.badCompanions.add(badCompanion);
    }

    public void removeBadCompanion(GreenCompanionDTO badCompanion) {
        this.badCompanions.remove(badCompanion);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GreenCompanionDTO)) {
            return false;
        }

        GreenCompanionDTO other = (GreenCompanionDTO) obj;

        return Objects.equals(other.name, this.name)
                && Objects.equals(other.id, this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}
