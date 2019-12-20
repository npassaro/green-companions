package com.greencompanions.v1.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GreenStore {
    private static final Logger LOG = LoggerFactory.getLogger(GreenStore.class);

    @Inject
    EntityManager em;

    public List<GreenDTO> getGreenCompanionList(Integer offset, Integer limit) {
        Query query = em.createQuery("SELECT g FROM greens as g ORDER BY g.id", GreenDTO.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public GreenDTO getGreenCompanion(Long id) {
        return em.find(GreenDTO.class, id);
    }

    @Transactional
    public GreenDTO create(GreenDTO companion) {
        em.persist(companion);
        return companion;
    }

    @Transactional
    public GreenDTO addGoodCompanion(Long id, GreenDTO goodCompanion) {
        GreenDTO green = em.find(GreenDTO.class, id);
        CompanionDTO companion = new CompanionDTO();
        companion.setGreen(green);
        companion.setCompanion(goodCompanion);
        companion.setCompanionType(CompanionType.GOOD);
        green.addGoodCompanion(companion);
        return green;
    }

    @Transactional
    public GreenDTO removeGoodCompanion(Long id, GreenDTO goodCompanion) {
        GreenDTO companion = em.find(GreenDTO.class, id);
        // companion.removeGoodCompanion(goodCompanion);
        return companion;
    }

    @Transactional
    public GreenDTO addBadCompanion(Long id, GreenDTO badCompanion) {
        GreenDTO green = em.find(GreenDTO.class, id);
        CompanionDTO companion = new CompanionDTO();
        companion.setGreen(green);
        companion.setCompanion(badCompanion);
        companion.setCompanionType(CompanionType.BAD);
        green.addGoodCompanion(companion);
        return green;
    }
}
