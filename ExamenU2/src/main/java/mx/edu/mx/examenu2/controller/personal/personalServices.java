package mx.edu.mx.examenu2.controller.personal;

import mx.edu.mx.examenu2.model.personal.BeanPersonal;
import mx.edu.mx.examenu2.model.personal.DaoPersonal;
import mx.edu.mx.examenu2.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

// indica que recurso se va a usar en esta clase
@Path("/api/personal")
public class personalServices {
    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanPersonal> getAll(){
        return new DaoPersonal().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanPersonal> findgetById(@PathParam("id")Long id ){

        return new DaoPersonal().findById(id);
    }

    @POST//Insercion
    @Path("/save") //"api/personal"
    @Consumes(MediaType.APPLICATION_JSON)//Consume Json
    @Produces(MediaType.APPLICATION_JSON)// Retorna Json
    public Response<BeanPersonal> save(BeanPersonal person){
        return  new DaoPersonal().save(person);
    }

    @POST//Insercion
    @Path("/update") //"api/personal"
    @Consumes(MediaType.APPLICATION_JSON)//Consume Json
    @Produces(MediaType.APPLICATION_JSON)// Retorna Json
    public Response<BeanPersonal> update(BeanPersonal person){
        return  new DaoPersonal().update(person);
    }


}
