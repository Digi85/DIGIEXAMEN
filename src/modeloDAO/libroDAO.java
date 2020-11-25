
package modeloDAO;

import java.sql.*;
import config.bd.ConectaBd;
import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

public class libroDAO implements CRUD{
 ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Libro e = new Libro();
    
    public List listarlibro() {
        ArrayList<Libro> libros = new ArrayList<>();
        String consulta = " select l.idlibro, l.nombre, a.apellidos 'autorapellidos', a.nombre 'autornombre', e.nombre 'editorialnombre', l.codigo,l.stock " +
"from libro l, autor a, editorial e " +
"where " +
"a.idautor = l.idautor and " +
"e.ideditorial = l.ideditorial   ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt("idlibro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutorapellidos(rs.getString("autorapellidos"));
                libro.setAutornombre(rs.getString("autornombre"));
                libro.setEditorialnombre(rs.getString("editorialnombre"));
                libro.setCodigo(rs.getString("codigo"));
                libro.setStock(rs.getInt("stock"));              
                libros.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return libros;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean agregarlibro(Libro libro) {
        Boolean agregado = false;
    	
    	String consulta = "INSERT INTO libro (nombre , codigo, isbn, fecha_publicacion, stock, precio_compra, estado) values( '" + libro.getNombre() +
    			"' , '" + libro.getCodigo() + "', '" + libro.getISBN() + "' , '" + libro.getFecha_publicacion() + "' , '" +
    			libro.getStock() +"', '" + libro.getPrecio_compra() + "', '" +libro.getEstado() + "' );";
    	
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

  
    public boolean editarlibro(Libro libro) {
        
        String consulta = " update libro "
                        + " set "
                        + " nombre = '"+ libro.getNombre() +"', "
                        + " codigo = '"+ libro.getCodigo()+"', "
                        + " ISBN = '"+ libro.getISBN()+"', "
                        + " fecha_publicacion = '"+ libro.getFecha_publicacion()+"', "
                        + " stock = '"+ libro.getStock()+"' "
                        + " precio_compra = '"+ libro.getPrecio_compra()+"' "
                        + " estado = '"+ libro.getEstado() +"' "
                        + " where "
                        + " idestudiante = " + libro.getIdlibro() + "; ";
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
    public Libro buscarlibro(int idlibro) {
         String consulta = " select *  "
                        + " from libro  "
                        + " where idlibro = " + idlibro ;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdlibro(rs.getInt("idlibro"));
                e.setNombre(rs.getString("nombre"));
                e.setCodigo(rs.getString("codigo"));
                e.setISBN(rs.getString("ISBN"));
                e.setFecha_publicacion(rs.getString("fecha_publicacion"));
                e.setStock(rs.getInt("Stock"));
                e.setPrecio_compradecimal(rs.getDouble("precio_compra"));
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
    public boolean eliminarlibro(int idlibro) {
        String consulta = " delete from libro "
                        + " where "
                        + " idlibro = " + idlibro + "; ";
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
