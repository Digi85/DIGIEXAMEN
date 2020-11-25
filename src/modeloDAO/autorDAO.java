package modeloDAO;
import java.sql.*;
import config.bd.ConectaBd;
import java.util.ArrayList;
import java.util.List;
import interfaces.CRUD2;
import modelo.Autor;


public class autorDAO implements CRUD2 {

    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Autor e = new Autor();
    public List listarautor() {
        ArrayList<Autor> autores = new ArrayList<>();
        String consulta = " select * from autor ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Autor autor = new Autor();
                autor.setIdautor(rs.getInt("idautor"));
                autor.setNombre(rs.getString("nombre"));
                autor.setApellidos(rs.getString("apellidos"));
                autor.setNacionalidad(rs.getString("nacionalidad"));
                autor.setDni(rs.getString("dni"));
                autor.setEstado(rs.getString("estado"));
                
                autores.add(autor);
            }
        } catch (SQLException e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return autores;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Autor buscarautor(int idautor) {
        
        String consulta = " select *  "
                        + " from autor  "
                        + " where idautor = " + idautor ;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdautor(rs.getInt("idautor"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setNacionalidad(rs.getString("nacionalidad"));
                e.setDni(rs.getString("codigo"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        
        return e;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarautor(Autor autor) {
        Boolean agregado = false;
    	
    	String consulta = "INSERT INTO autor (nombre , apellidos, nacionalidad, dni, estado) values( '" + autor.getNombre() +
    			"' , '" + autor.getApellidos() + "', '" + autor.getNacionalidad()+ "' , '" + autor.getDni()+ "' , '" +
    			autor.getEstado()	+ "' );";
    	
    	try {
    		
    	con = cn.getConnection();
        pst = con.prepareStatement(consulta);
        pst.executeUpdate();
    	con.close();
        pst.close();
            agregado = true;
    		
		} catch (Exception e) {
			System.out.println("Something were wrong in Insert");
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
    	return agregado;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarautor(Autor autor) {
         String consulta = " update autor "
                        + " set "
                        + " nombre = '"+ autor.getNombre() +"', "
                        + " apellidos = '"+ autor.getApellidos() +"', "
                        + " nacionalidad = '"+ autor.getNacionalidad()+"', "
                        + " dni = '"+ autor.getDni()+"', "
                        + " estado = '"+ autor.getEstado() +"' "
                        + " where "
                        + " idautor = " + autor.getIdautor() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception error) {
            System.out.println("Error con el Lsitar");
            System.out.println(error.getMessage());
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarautor(int idautor) {
         String consulta = " delete from autor "
                        + " where "
                        + " idautor = " + idautor + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
