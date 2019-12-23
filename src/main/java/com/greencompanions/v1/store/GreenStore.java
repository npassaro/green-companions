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
    public GreenDTO create(GreenDTO green) {
        em.persist(green);
        return green;
    }

    @Transactional
    public GreenDTO addGoodCompanion(Long greenId, GreenDTO companion) {
        GreenDTO green = em.find(GreenDTO.class, greenId);
        GreenDTO greenCompanion = em.find(GreenDTO.class, companion.getId());
        green.addGoodCompanion(greenCompanion);
        return green;
    }

    @Transactional
    public GreenDTO removeGoodCompanion(Long greenId, GreenDTO goodCompanion) {
        GreenDTO green = em.find(GreenDTO.class, greenId);
        green.removeGoodCompanion(goodCompanion);
        return green;
    }

    @Transactional
    public GreenDTO addBadCompanion(Long greenId, GreenDTO companion) {
        GreenDTO green = em.find(GreenDTO.class, greenId);
        GreenDTO greenCompanion = em.find(GreenDTO.class, companion.getId());
        green.addBadCompanion(greenCompanion);
        return green;
    }

    @Transactional
    public GreenDTO removeBadCompanion(Long greenId, GreenDTO badCompanion) {
        GreenDTO green = em.find(GreenDTO.class, greenId);
        green.removeBadCompanion(badCompanion);
        return green;
    }
}
