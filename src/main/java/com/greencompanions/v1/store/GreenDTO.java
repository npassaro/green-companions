package com.greencompanions.v1.store;

import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;

@Entity(name = "greens")
@Table(name = "greens")
public class GreenDTO {
    private static final Logger LOG = LoggerFactory.getLogger(GreenDTO.class);
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


    @OneToMany(targetEntity = GoodCompanionDTO.class, mappedBy = "green",  fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Where(clause="companion_type='GOOD'")
    private Set<CompanionDTO> goodCompanions = new HashSet<>();

    @OneToMany(targetEntity = BadCompanionDTO.class, mappedBy = "green", fetch = FetchType.EAGER,  cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Where(clause="companion_type='BAD'")
    private Set<CompanionDTO> badCompanions = new HashSet<>();

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

    public void addGoodCompanion(GreenDTO goodCompanion) {
        GoodCompanionDTO companionDTO = new GoodCompanionDTO(this, goodCompanion);
        this.goodCompanions.add(companionDTO);
    }

    public void removeGoodCompanion(GreenDTO goodCompanion) {
        removeCompanion(this.goodCompanions, goodCompanion);
    }

    public Set<CompanionDTO> getBadCompanions() {
        return badCompanions;
    }

    public void setBadCompanions(Set<CompanionDTO> badCompanions) {
        this.badCompanions = badCompanions;
    }

    public void addBadCompanion(GreenDTO badCompanion) {
        BadCompanionDTO companionDTO = new BadCompanionDTO(this, badCompanion);
        this.badCompanions.add(companionDTO);
    }

    public void removeBadCompanion(GreenDTO companion) {
        removeCompanion(this.badCompanions, companion);
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

    @Override
    public String toString() {
        return "{id=" + this.id + ", name=" + this.name + "}";
    }

    private void removeCompanion(Set<CompanionDTO> companions, GreenDTO goodCompanion) {
        for (Iterator<CompanionDTO> iterator = companions.iterator();
             iterator.hasNext(); ) {
            CompanionDTO companionDTO = iterator.next();

            if (companionDTO.getGreen().equals(this) &&
                    companionDTO.getCompanion().equals(goodCompanion)) {
                iterator.remove();
                companionDTO.setGreen(null);
                companionDTO.setCompanion(null);
            }
        }

    }
}
