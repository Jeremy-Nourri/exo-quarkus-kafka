package com.example.ressource;

import com.example.entity.Organisation;
import com.example.service.OrganisationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.List;

@Path("/organisations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganisationRessource {

    @Inject
    OrganisationService organisationService;

    @GET
    public List<Organisation> getAllOrganisations() {
        return organisationService.getAllOrganisations();
    }

    @GET
    @Path("/{id}")
    public Response getOrganisationById(@PathParam("id") Long id) {
        Organisation organisation = organisationService.getOrganisationById(id);
        if (organisation == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(organisation).build();
    }

    @POST
    public Response createOrganisation(Organisation organisation) {
        Organisation createdOrganisation = organisationService.createOrganisation(organisation);
        return Response.status(Response.Status.CREATED).entity(createdOrganisation).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganisation(@PathParam("id") Long id) {
        boolean deleted = organisationService.deleteOrganisation(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrganisation(@PathParam("id") Long id, Organisation updatedOrganisation) {
        Organisation organisation = organisationService.updateOrganisation(id, updatedOrganisation);
        if (organisation == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(organisation).build();
    }




}
