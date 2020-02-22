package com.greencompanions.v1.rest;

import com.greencompanions.v1.store.CompanionDTO;
import com.greencompanions.v1.store.GreenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GreenCompanion {
    private static final Logger LOG = LoggerFactory.getLogger(GreenCompanion.class);
    private Long id;
    private Set<Integer> sowPeriod;
    private Set<Integer> growPeriod;
    private Set<Integer> harvestPeriod;
    @NotBlank(message = "Please add a name to the veggie")
    private String name;
    private String description;
    private Set<Long> goodCompanionsIds;
    private Set<Long> badCompanionsIds;

    public GreenCompanion() {
    }

    public GreenCompanion(GreenDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.sowPeriod = fromCommaSeparated(dto.getSowPeriod());
        this.growPeriod = fromCommaSeparated(dto.getGrowPeriod());
        this.harvestPeriod = fromCommaSeparated(dto.getHarvestPeriod());
        this.goodCompanionsIds = toSetOfIds(dto.getGoodCompanions());
        this.badCompanionsIds = toSetOfIds(dto.getBadCompanions());
    }

    public GreenDTO toDto() {
        GreenDTO dto = new GreenDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setSowPeriod(toCommaSeparated(this.sowPeriod));
        dto.setGrowPeriod(toCommaSeparated(this.growPeriod));
        dto.setHarvestPeriod(toCommaSeparated(this.harvestPeriod));
        return dto;
    }

    private <T extends CompanionDTO> Set<Long> toSetOfIds(Set<T> companions) {
        return companions == null ?
                Collections.emptySet() :
                companions.stream()
                        .map(T::getCompanion)
                        .map(GreenDTO::getId)
                        .collect(Collectors.toSet());
    }

    private Set<Integer> fromCommaSeparated(String items) {
        if (items.isEmpty()) {
            return Collections.emptySet();
        }
        return Arrays.stream(items.split(",")).map(Integer::valueOf).collect(Collectors.toSet());
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

    public Set<Long> getGoodCompanionsIds() {
        return goodCompanionsIds;
    }

    public Set<Long> getBadCompanionsIds() {
        return badCompanionsIds;
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

