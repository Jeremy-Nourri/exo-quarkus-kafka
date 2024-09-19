package com.example.client;

import com.example.dto.OrganisationDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/organisations")
@RegisterRestClient(configKey = "organisation-service")
public interface OrganisationServiceClient {

    @GET
    @Path("/{id}")
    OrganisationDto getOrganisationById(Long id);
}
