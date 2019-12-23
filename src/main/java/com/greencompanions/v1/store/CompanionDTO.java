package com.greencompanions.v1.store;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "companions")
@Table(name = "companions")
@DiscriminatorColumn(name = "companion_type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@IdClass(CompanionId.class)
public class CompanionDTO {
    @Id
    @ManyToOne(targetEntity=GreenDTO.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "green_id")
    protected GreenDTO green;

    @Id
    @ManyToOne(targetEntity=GreenDTO.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "companion_id")
    protected GreenDTO companion;

    public CompanionDTO() { }

    public CompanionDTO(GreenDTO green, GreenDTO companion) {
        this.green = green;
        this.companion = companion;
    }

    public GreenDTO getGreen() {
        return green;
    }

    public void setGreen(GreenDTO green) {
        this.green = green;
    }

    public GreenDTO getCompanion() {
        return companion;
    }

    public void setCompanion(GreenDTO companion) {
        this.companion = companion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CompanionDTO that = (CompanionDTO) o;
        return Objects.equals(this.green, that.green) &&
                Objects.equals(this.companion, that.companion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.green, this.companion);
    }

    @Override
    public String toString() {
        return "greenId=" + this.green.getId() + ", companionId=" + this.companion.getId();
    }
}
