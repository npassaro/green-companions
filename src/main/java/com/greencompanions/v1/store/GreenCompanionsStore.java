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
public class GreenCompanionsStore {
    private static final Logger LOG = LoggerFactory.getLogger(GreenCompanionsStore.class);
    @Inject
    EntityManager em;

    public List<GreenCompanionDTO> getGreenCompanionList(Integer offset, Integer limit) {
        Query query = em.createQuery("SELECT g FROM green_companions as g ORDER BY g.id", GreenCompanionDTO.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public GreenCompanionDTO getGreenCompanion(Long id) {
        return em.find(GreenCompanionDTO.class, id);
    }

    @Transactional
    public GreenCompanionDTO create(GreenCompanionDTO companion) {
        em.persist(companion);
        return companion;
    }

    @Transactional
    public GreenCompanionDTO addGoodCompanion(Long id, GreenCompanionDTO goodCompanion) {
        GreenCompanionDTO companion = em.find(GreenCompanionDTO.class, id);
        companion.addGoodCompanion(goodCompanion);
        return companion;
    }

    @Transactional
    public GreenCompanionDTO removeGoodCompanion(Long id, GreenCompanionDTO goodCompanion) {
        GreenCompanionDTO companion = em.find(GreenCompanionDTO.class, id);
        companion.removeGoodCompanion(goodCompanion);
        return companion;
    }

}
