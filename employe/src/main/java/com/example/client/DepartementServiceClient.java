package com.example.client;

import com.example.dto.DepartementDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/departements")
@RegisterRestClient(configKey = "departement-service")
public interface DepartementServiceClient {

    @GET
    @Path("/{id}")
    DepartementDto getDepartementById(@PathParam("id") Long id);

}
