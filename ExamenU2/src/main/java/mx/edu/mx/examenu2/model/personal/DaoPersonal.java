package mx.edu.mx.examenu2.model.personal;


import mx.edu.mx.examenu2.model.Repository;
import mx.edu.mx.examenu2.model.position.BeanPosition;
import mx.edu.mx.examenu2.utils.MySQL;
import mx.edu.mx.examenu2.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersonal implements Repository <BeanPersonal> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQL mysql = new MySQL();

    @Override
    public List<BeanPersonal> findAll() {
        List<BeanPersonal> personal = new ArrayList<>();
        BeanPersonal person = null;
        BeanMagia magia = null;
        BeanLucha lucha = null;
        try {
            conn = mysql.getConnection();
            String query = "SELECT pe.*,po.descripcion from personal pe inner join puesto  po on pe.puestoId = po.id where pe.activo= true";
            ps= conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                person = new BeanPersonal();
                magia = new BeanMagia();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("Name"));
                person.setLastname(rs.getString("Lastname"));
                person.setBirthday(rs.getString("Birthday"));
                person.setEstatura(rs.getDouble("estatura"));
                person.setPeso(rs.getDouble("Peso"));
                person.setUtiliza_magia(rs.getInt("Utiliza magia"));
                person.setEquipo(rs.getInt("Equipo"));
                person.setTipo_lucha(rs.getInt("Tipo de lucha"));
                personal.add(person);

            }
        }catch (SQLException e){

            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE,"Error ->FindAll"+e.getMessage());
        }finally {
            mysql.close(conn,ps,rs);
        }

        return personal;
    }

    public List<BeanPersonal> findById(Long id) {
        BeanPersonal person = null;
        BeanPosition position = null;
        Response<BeanPersonal> response = new Response<>();
        try {
            conn = mysql.getConnection();
            String query = "SELECT pe.*,po.descripcion from personal pe inner join puesto  po on pe.puestoId = po.id where pe.id = ?";
            ps= conn.prepareStatement(query);
            ps.setLong(1,id);
            rs = ps.executeQuery();


            while(rs.next()){
                person = new BeanPersonal();
                position = new BeanPosition();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("Name"));
                person.setLastname(rs.getString("Lastname"));
                person.setBirthday(rs.getString("Birthday"));
                person.setEstatura(rs.getDouble("estatura"));
                person.setPeso(rs.getDouble("Peso"));
                person.setUtiliza_magia(rs.getInt("Utiliza magia"));
                person.setEquipo(rs.getInt("Equipo"));
                person.setTipo_lucha(rs.getInt("Tipo de lucha"));
                System.out.println(ps.execute());
                if (ps.execute()){
                    response.setStatus(200);
                    response.setMessage("Persona Localizada correctamente");
                    response.setError(false);
                    response.setData(person);
                }else{
                    response.setStatus(400);
                    response.setMessage("Persona no encontrada");
                    response.setError(true);
                    response.setData(null);
                }
            }
        }catch (SQLException e){

            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE,"Error ->FindById"+e.getMessage());
        }finally {
            mysql.close(conn,ps,rs);
        }

        return (List<BeanPersonal>) response;
    }

    @Override
    public Response<BeanPersonal> save(BeanPersonal object) {
        Response<BeanPersonal> response = new Response<>();
        try{conn= mysql.getConnection();
            String query = "Insert into personal (Name,Lastname,Birthday,Estatura,Peso,Utiliza_magia, Equipo, Tipo_lucha) values (?,?,?,?,?,?,?,?); ";
            ps= conn.prepareStatement(query);
            ps.setString(1,object.getName());;
            ps.setString(2,object.getLastname());
            ps.setString(3,object.getBirthday());
            ps.setDouble(4,object.getEstatura());
            ps.setDouble(5,object.getPeso());
            ps.setInt(6,object.getUtiliza_magia());
            ps.setInt(7,object.getEquipo());
            ps.setInt(8,object.getTipo_lucha());
            if (ps.executeUpdate()==1){
                response.setStatus(200);
                response.setMessage("Persona registrada correctamente");
                response.setError(false);
                response.setData(object);
            }else{
                response.setStatus(400);
                response.setMessage("No se  registro correctamente");
                response.setError(true);
                response.setData(null);

            }
            return response;
        }catch (SQLException e){

            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE,"Error al registrar al personal ->",e);
            response.setStatus(400);
            response.setMessage("Error"+e);
            response.setError(false);
            response.setData(null);
        }finally {
            mysql.close(conn,ps,rs);
        }
        return response;
    }

    @Override
    public Response<BeanPersonal> update(BeanPersonal object) {
        Response<BeanPersonal> response = new Response<>();
        try{conn= mysql.getConnection();
            String query = "update personal set name=?,Lastname=?,Birthday=?,Equipo=?,Tipo_lucha=?,Estatura=?,Peso=?,Utiliza_magia=? where id=?;";
            ps= conn.prepareStatement(query);
            ps.setString(1,object.getName());
            ps.setString(2,object.getLastname());
            ps.setString(3,object.getBirthday());
            ps.setDouble(4,object.getEstatura());
            ps.setDouble(5,object.getPeso());
            ps.setInt(6,object.getUtiliza_magia());
            ps.setInt(7,object.getEquipo());
            ps.setInt(8,object.getTipo_lucha());
            ps.setLong(9,object.getId());
            if (ps.executeUpdate()==1){
                response.setStatus(200);
                response.setMessage("Persona actualizada  correctamente");
                response.setError(false);
                response.setData(object);
            }else{
                response.setStatus(400);
                response.setMessage("No se actualizo correctamente la persona");
                response.setError(true);
                response.setData(null);

            }
            return response;
        }catch (SQLException e){

            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE,"Error al registrar al personal ->",e);
            response.setStatus(400);
            response.setMessage("No se actualizo correctamente la persona");
            response.setError(false);
            response.setData(null);
        }finally {
            mysql.close(conn,ps,rs);
        }
        return response;
    }
}
