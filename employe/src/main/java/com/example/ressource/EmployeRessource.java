package com.example.ressource;

import com.example.entity.Employe;
import com.example.service.EmployeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeRessource {

    @Inject
    EmployeService employeService;

    @GET
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeById(@PathParam("id") Long id) {
        Employe employe = employeService.findById(id);
        if (employe == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(employe).build();
    }

    @POST
    public Response createEmploye(Employe employe) {
        Employe createdEmploye = employeService.create(employe);
        return Response.status(Response.Status.CREATED).entity(createdEmploye).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmploye(@PathParam("id") Long id, Employe updatedEmploye) {
        Employe employe = employeService.update(updatedEmploye);
        if (employe == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(employe).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmploye(@PathParam("id") Long id) {
        employeService.delete(id);
        return Response.noContent().build();
    }







}
