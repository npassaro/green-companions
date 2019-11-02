package com.greencompanions.v1.rest;

import com.greencompanions.v1.store.GreenCompanionsStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/green-companions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreenCompanionsResource {
    private static final Logger LOG = LoggerFactory.getLogger(GreenCompanionsResource.class);
    @Inject
    private GreenCompanionsStore store;

    @GET
    public List<GreenCompanion> getAllCompanions() {
        return store.getGreenCompanionList(0, 50)
                .stream()
                .map(GreenCompanion::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public GreenCompanion getCompanion(@PathParam("id") Long id) {
        return new GreenCompanion(store.getGreenCompanion(id));
    }

    @POST
    public GreenCompanion createCompanion(GreenCompanion companion) {
        return new GreenCompanion(store.create(companion.toDto()));
    }

    @POST
    @Path("/{id}/good-companions")
    public GreenCompanion addGoodCompanion(@PathParam("id") Long id, GreenCompanion companion) {
        return new GreenCompanion(store.addGoodCompanion(id, companion.toDto()));
    }

    @POST
    @Path("/{id}/bad-companions")
    public GreenCompanion addBadCompanion(@PathParam("id") Long id, GreenCompanion companion) {
        return new GreenCompanion(store.addBadCompanion(id, companion.toDto()));
    }
}

