package com.greencompanions.v1.store;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GOOD")
public class GoodCompanionDTO extends CompanionDTO {
    public GoodCompanionDTO() { }

    public GoodCompanionDTO(GreenDTO green, GreenDTO companion) {
        super(green, companion);
    }
}
