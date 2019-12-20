package com.greencompanions.v1.store;

import javax.persistence.*;

@Entity(name = "companions")
@Table(name = "companions")
public class CompanionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "green_id")
    private GreenDTO green;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companion_id")
    private GreenDTO companion;

    @Enumerated(EnumType.STRING)
    private CompanionType companionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CompanionType getCompanionType() {
        return companionType;
    }

    public void setCompanionType(CompanionType companionType) {
        this.companionType = companionType;
    }
}
