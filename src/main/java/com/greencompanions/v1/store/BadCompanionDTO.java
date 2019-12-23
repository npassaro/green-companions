package com.greencompanions.v1.store;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BAD")
public class BadCompanionDTO extends CompanionDTO {
    public BadCompanionDTO() { }
    public BadCompanionDTO(GreenDTO green, GreenDTO companion) {
        super(green, companion);
    }
}
