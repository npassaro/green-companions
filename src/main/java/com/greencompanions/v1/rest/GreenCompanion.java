package com.greencompanions.v1.rest;

import com.greencompanions.v1.store.GreenCompanionDTO;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GreenCompanion {
    private Long id;
    private Set<Integer> sowPeriod;
    private Set<Integer> growPeriod;
    private Set<Integer> harvestPeriod;
    private String name;
    private String description;

    public GreenCompanion() {
    }

    public GreenCompanion(GreenCompanionDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.setSowPeriod(fromCommaSeparated(dto.getSowPeriod()));
        this.setGrowPeriod(fromCommaSeparated(dto.getGrowPeriod()));
        this.setHarvestPeriod(fromCommaSeparated(dto.getHarvestPeriod()));
    }

    public GreenCompanionDTO toDto() {
        GreenCompanionDTO dto = new GreenCompanionDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setSowPeriod(toCommaSeparated(this.sowPeriod));
        dto.setGrowPeriod(toCommaSeparated(this.growPeriod));
        dto.setHarvestPeriod(toCommaSeparated(this.harvestPeriod));
        return dto;
    }

    private Set<Integer> fromCommaSeparated(String items) {
        return Arrays.stream(items.split(",")).map(Integer::new).collect(Collectors.toSet());
    }
    private String toCommaSeparated(Set<Integer> items) {
        return String.join(",", items.stream().map(Object::toString).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Integer> getSowPeriod() {
        return sowPeriod;
    }

    public void setSowPeriod(Set<Integer> sowPeriod) {
        this.sowPeriod = sowPeriod;
    }

    public Set<Integer> getGrowPeriod() {
        return growPeriod;
    }

    public void setGrowPeriod(Set<Integer> growPeriod) {
        this.growPeriod = growPeriod;
    }

    public Set<Integer> getHarvestPeriod() {
        return harvestPeriod;
    }

    public void setHarvestPeriod(Set<Integer> harvestPeriod) {
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

