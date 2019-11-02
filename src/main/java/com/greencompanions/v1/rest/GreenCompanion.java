package com.greencompanions.v1.rest;

import com.greencompanions.v1.store.GreenCompanionDTO;

import java.util.Date;
import java.util.Objects;

public class GreenCompanion {
    private Long id;
    private Period sowingPeriod;
    private Period growPeriod;
    private Period harvestPeriod;
    private String name;
    private String description;

    public GreenCompanion() {
    }

    public GreenCompanion(GreenCompanionDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.setSowingPeriod(dto.getSowingPeriodStart(), dto.getSowingPeriodEnd());
        this.setGrowPeriod(dto.getGrowPeriodStart(), dto.getGrowPeriodEnd());
        this.setHarvestPeriod(dto.getHarvestPeriodStart(), dto.getHarvestPeriodEnd());
    }

    public GreenCompanionDTO toDto() {
        GreenCompanionDTO dto = new GreenCompanionDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setSowingPeriodStart(this.sowingPeriod.getStart());
        dto.setSowingPeriodEnd(this.sowingPeriod.getEnd());
        dto.setGrowPeriodStart(this.growPeriod.getStart());
        dto.setGrowPeriodEnd(this.growPeriod.getEnd());
        dto.setHarvestPeriodStart(this.harvestPeriod.getStart());
        dto.setHarvestPeriodEnd(this.harvestPeriod.getEnd());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Period getSowingPeriod() {
        return sowingPeriod;
    }

    public void setSowingPeriod(Period sowingPeriod) {
        this.sowingPeriod = sowingPeriod;
    }

    public void setSowingPeriod(Date start, Date end) {
        this.sowingPeriod = new Period(start, end);;
    }

    public Period getGrowPeriod() {
        return growPeriod;
    }

    public void setGrowPeriod(Period growPeriod) {
        this.growPeriod = growPeriod;
    }

    public void setGrowPeriod(Date start, Date end) {
        this.growPeriod = new Period(start, end);
    }

    public Period getHarvestPeriod() {
        return harvestPeriod;
    }

    public void setHarvestPeriod(Period harvestPeriod) {
        this.harvestPeriod = harvestPeriod;
    }

    public void setHarvestPeriod(Date start, Date end) {
        this.harvestPeriod = new Period(start, end);
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GreenCompanion)) {
            return false;
        }

        GreenCompanion other = (GreenCompanion) obj;

        return Objects.equals(other.name, this.name)
                && Objects.equals(other.id, this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}

