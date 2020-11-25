package modeloDAO;
import config.bd.ConectaBd;
import interfaces.CRUD3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Editorial;


public class editorialDAO implements CRUD3 {
ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Editorial e = new Editorial();
    @Override
    public List listaresteditorial() {
         ArrayList<Editorial> editoriales = new ArrayList<>();
        String consulta = " select * from editorial ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Editorial editorial = new Editorial();
                editorial.setIdeditorial(rs.getInt("ideditorial"));
                editorial.setNombre(rs.getString("nombre"));
                editorial.setEstado(rs.getString("estado"));
                
                editoriales.add(editorial);
            }
        } catch (SQLException e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return editoriales;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Editorial buscareditorial(int ideditorial) {
        String consulta = " select * "
                        + " from editorial "
                        + " where ideditorial = " + ideditorial ;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdeditorial(rs.getInt("ideditorial"));
                e.setNombre(rs.getString("nombre"));
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
    public boolean agregareditorial(Editorial editorial) {
        Boolean agregado = false;
    	
    	String consulta = "INSERT INTO estudiante (nombre , estado) values( '" + editorial.getNombre() +
    			"' , '" + editorial.getEstado()+ "' );";
    	
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
    public boolean editareditorial(Editorial editorial) {
        
        String consulta = " update editorial "
                        + " set "
                        + " nombre = '"+ editorial.getNombre() +"', "
                        + " estado = '"+ editorial.getEstado() +"' "
                        + " where "
                        + " ideditorial = " + editorial.getIdeditorial()+ "; ";
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
    public boolean eliminareditorial(int ideditorial) {
        String consulta = " delete from editorial "
                        + " where "
                        + " ideditorial = " + ideditorial + "; ";
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
