package com.greencompanions;

import java.util.Objects;

public class GreenCompanion {
    private Integer id;
    private Period sowingPeriod;
    private Period growPeriod;
    private Period harvestPeriod;
    private String name;
    private String description;

    public GreenCompanion() {
    }

    public GreenCompanion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Period getSowingPeriod() {
        return sowingPeriod;
    }

    public void setSowingPeriod(Period sowingPeriod) {
        this.sowingPeriod = sowingPeriod;
    }

//    public void setSowingPeriod(Date start, Date end) {
//        this.sowingPeriod = new Period(start, end);;
//    }

    public Period getGrowPeriod() {
        return growPeriod;
    }

    public void setGrowPeriod(Period growPeriod) {
        this.growPeriod = growPeriod;
    }

//    public void setGrowPeriod(Date start, Date end) {
//        this.growPeriod = new Period(start, end);
//    }

    public Period getHarvestPeriod() {
        return harvestPeriod;
    }

    public void setHarvestPeriod(Period harvestPeriod) {
        this.harvestPeriod = harvestPeriod;
    }

//    public void setHarvestPeriod(Date start, Date end) {
//        this.harvestPeriod = new Period(start, end);
//    }

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

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}

