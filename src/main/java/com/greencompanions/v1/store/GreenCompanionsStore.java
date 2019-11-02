package com.greencompanions.v1.store;

import com.greencompanions.v1.rest.GreenCompanionsResource;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GreenCompanionsStore {
    private static final Logger LOG = Logger.getLogger(GreenCompanionsResource.class);

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
        LOG.info("=====> COMPANION: " + companion.getName() + " | " + companion.getDescription());
        LOG.info("=====> DTO: " + companion);
        em.persist(companion);
        return companion;
    }
}
