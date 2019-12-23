package com.greencompanions.v1.store;

import java.io.Serializable;
import java.util.Objects;

public class CompanionId implements Serializable {

    private GreenDTO green;

    private GreenDTO companion;

    public CompanionId() {}

    public CompanionId(GreenDTO green, GreenDTO companion) {
        this.green = green;
        this.companion = companion;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CompanionId)) {
            return false;
        }

        CompanionId other = (CompanionId) obj;

        return Objects.equals(other.green.getId(), this.green.getId())
                && Objects.equals(other.companion.getId(), this.companion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.green, this.companion);
    }
}
