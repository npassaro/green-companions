package com.greencompanions;

import org.jboss.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

@Path("/green-companions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreenCompanionsResource {
    private static final Logger LOG = Logger.getLogger(GreenCompanionsResource.class);
    private List<GreenCompanion> greenCompanions = setup();

    @GET
    public List<GreenCompanion> getAllCompanions() {
        return greenCompanions;
    }

    @GET
    @Path("/{id}")
    public GreenCompanion getCompanion(@PathParam("id") Integer id) {
        return greenCompanions.stream()
                .filter(green -> green.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new WebApplicationException(HttpURLConnection.HTTP_NOT_FOUND));
    }

    private List<GreenCompanion> setup() {
        JsonbConfig config = new JsonbConfig();
        Jsonb jsonb = JsonbBuilder.create(config);
        try (FileReader reader = new FileReader("greens.json")) {
            LOG.info("Opening JSON file:" + reader);
            return jsonb.fromJson(reader, new ArrayList<GreenCompanion>(){}.getClass().getGenericSuperclass());
        } catch (IOException e) {
            LOG.error("Failed to open JSON file", e);
            return jsonb.fromJson("[]", List.class);
        }
    }
}

