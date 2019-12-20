package com.greencompanions.v1.store;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity(name = "greens")
@Table(name = "greens")
public class GreenDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String sowPeriod;
    private String growPeriod;
    private String harvestPeriod;

    @Column(unique = true)
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;


    @OneToMany(targetEntity=CompanionDTO.class, mappedBy="companion", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CompanionDTO> goodCompanions;

    @OneToMany(targetEntity=CompanionDTO.class, mappedBy="companion", fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    private Set<CompanionDTO> badCompanions;

    public GreenDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSowPeriod() {
        return sowPeriod;
    }

    public void setSowPeriod(String sowPeriod) {
        this.sowPeriod = sowPeriod;
    }

    public String getGrowPeriod() {
        return growPeriod;
    }

    public void setGrowPeriod(String growPeriod) {
        this.growPeriod = growPeriod;
    }

    public String getHarvestPeriod() {
        return harvestPeriod;
    }

    public void setHarvestPeriod(String harvestPeriod) {
        this.harvestPeriod = harvestPeriod;
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

    public Set<CompanionDTO> getGoodCompanions() {
        return goodCompanions;
    }

    public void setGoodCompanions(Set<CompanionDTO> goodCompanions) {
        this.goodCompanions = goodCompanions;
    }

    public void addGoodCompanion(CompanionDTO goodCompanion) {
        this.goodCompanions.add(goodCompanion);
    }

    public void removeGoodCompanion(CompanionDTO goodCompanion) {
        this.goodCompanions.remove(goodCompanion);
    }

    public Set<CompanionDTO> getBadCompanions() {
        return badCompanions;
    }

    public void setBadCompanions(Set<CompanionDTO> badCompanions) {
        this.badCompanions = badCompanions;
    }

    public void addBadCompanion(CompanionDTO badCompanion) {
        this.badCompanions.add(badCompanion);
    }

    public void removeBadCompanion(CompanionDTO badCompanion) {
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
        if (!(obj instanceof GreenDTO)) {
            return false;
        }

        GreenDTO other = (GreenDTO) obj;

        return Objects.equals(other.name, this.name)
                && Objects.equals(other.id, this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}
