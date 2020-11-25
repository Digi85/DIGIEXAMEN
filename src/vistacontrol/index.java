package vistacontrol;
import java.util.List;
import modelo.Libro;
import modelo.Autor;
import modeloDAO.autorDAO;
import modeloDAO.editorialDAO;
import modeloDAO.libroDAO;
import utils.leer;
import modelo.Editorial;


public class index {
    
    public static void eliminareditorial()
    {
        listarlibro();
        System.out.print("Ingrese el ID de la editorial a Eliminar: ");
        int id = leer.entero();
        editorialDAO editorialDAO = new editorialDAO();
        editorialDAO.eliminareditorial(id);
    }
    
    public static void eliminarlibro()
    {
        listarlibro();
        System.out.print("Ingrese el ID del libro a Eliminar: ");
        int id = leer.entero();
        libroDAO libroDAO = new libroDAO();
        libroDAO.eliminarlibro(id);
    }
    public static void editarlibro()
    {
        listarlibro();
        System.out.print("Ingrese el ID del libro a Editar: ");
        int id = leer.entero();   
        String nombre;
        String codigo;
        String ISBN;
        String fecha_publicacion;
        int stock;
        double precio_compra;
        String estado;
        System.out.println("Editar libro");
        System.out.print("Nombre: ");
        nombre = leer.cadena();
        System.out.print("Codigo: ");
        codigo = leer.cadena();
        System.out.print("ISBN: ");
        ISBN = leer.cadena();
        System.out.print("fecha_publicacion: ");
        fecha_publicacion = leer.cadena();
        System.out.print("stock: ");
        stock = leer.entero();
        System.out.print("precio_compra: ");
        precio_compra = leer.decimal();
        System.out.print("estado: ");
        estado = leer.cadena();
        Libro libro = new Libro(id, nombre, codigo, ISBN, fecha_publicacion, stock, precio_compra, estado);
        libroDAO libroDAO = new libroDAO();
        libroDAO.editarlibro(libro);
    }
    public static void agregarlibros()
    {
        String nombre;
        String codigo;
        String ISBN;
        String fecha_publicacion;
        int stock;
        double precio_compra;
        String estado;
        System.out.println("Agregar Libro");
        System.out.print("Nombre: ");
        nombre = leer.cadena();
        System.out.print("Codigo: ");
        codigo = leer.cadena();
        System.out.print("ISBN: ");
        ISBN = leer.cadena();
        System.out.print("fecha_publicacion: ");
        fecha_publicacion = leer.cadena();
        System.out.print("stock: ");
        stock = leer.entero();
        System.out.print("precio_compra: ");
        precio_compra = leer.decimal();
        System.out.print("estado: ");
        estado = leer.cadena();
 
        Libro libro = new Libro(0, nombre, codigo, ISBN, fecha_publicacion, stock, precio_compra, estado);
        libroDAO libroDAO = new libroDAO();
        libroDAO.agregarlibro(libro);
    }
    public static void eliminarautor()
     {
        listarautor();
        System.out.print("Ingrese el ID del autor a Eliminar: ");
        int id = leer.entero();
        autorDAO autorDAO = new autorDAO();
        autorDAO.eliminarautor(id);
     }   
       public static void editarautor()
      {
        listarautor();
        System.out.print("Ingrese el ID del autor a Editar: ");
        int id = leer.entero();   
        String nombre;
        String apellidos;
        String nacionalidad;
        String dni;
        String estado;
        System.out.println("Editar autor");
        System.out.print("Nombre: ");
        nombre = leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = leer.cadena();
        System.out.print("nacionalidad: ");
        nacionalidad = leer.cadena();
        System.out.print("DNI: ");
        dni = leer.cadena();
        System.out.print("Estado: ");
        estado = leer.cadena();
        Autor autor = new Autor(id, nombre, apellidos, nacionalidad, dni, estado);
        autorDAO autorDAO = new autorDAO();
        autorDAO.editarautor(autor);
       }
       public static void agregarautor()
       {
       String nombre;
        String apellidos;
        String nacionalidad;
        String dni;
        String estado;
        System.out.println("Agregar Autor");
        System.out.print("Nombre: ");
        nombre = leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = leer.cadena();
        System.out.print("nacionalidad: ");
        nacionalidad = leer.cadena();
        System.out.print("dni: ");
        dni = leer.cadena();
        System.out.print("Estado: ");
        estado = leer.cadena();
        Autor autor = new Autor(0, nombre, apellidos, nacionalidad, dni, estado);
        autorDAO autorDAO = new autorDAO();
        autorDAO.agregarautor(autor);
       }
     public static void listarlibro()
    {
        libroDAO libroDAO = new libroDAO();
        List<Libro>libros = libroDAO.listarlibro();
        System.out.println("Listado de libros");
        for (Libro libro : libros) {
            System.out.println(libro.getIdlibro()+ "\t"+
                               libro.getNombre()+ "\t"+
                               libro.getAutorapellidos()+"\t"+
                               libro.getAutornombre()+
                               libro.getEditorialnombre()+"\t"+
                               libro.getCodigo()+"\t"+
                               libro.getStock()+"\t"                             
                             
                    
                    );
        }
    }
     public static void listarautor()
     {
         autorDAO autorDAO = new autorDAO();
        List<Autor>autores = autorDAO.listarautor();
        System.out.println("Listado de autores");
        for (Autor autor : autores) {
            System.out.println(autor.getIdautor()+ "\t"+
                               darFormato(autor.getNombre())+ "\t"+
                               darFormato(autor.getApellidos())+"\t"+
                               darFormato(autor.getNacionalidad())+"\t"+
                               (autor.getDni())+"\t"+
                               (autor.getEstado())
                    );
     }
     }
     
     
     public static String darFormato(String cadena){
        if (cadena.length()>=15) {
            cadena = cadena.substring(0,12) + "  "+" ";
        }else if (cadena.length()>=8) {
        	cadena = cadena + "";
        }else if (cadena.length()>=4) {
            cadena = cadena + "\t";
        }else if (cadena.length()>=2){
            cadena = cadena + "\t\t";
        }
        else if (cadena.length()==7) {
        	cadena = cadena + "\t";
        }
         else {
            cadena = cadena + "\t";
        }
        
        return cadena;
    }
     public static void salir()
     {
         System.out.println("Gracias por visitarnos ");
     }
     public static void menu()
     {
          System.out.println("Menu Principal");
        System.out.println("1. Listar Libros");
        System.out.println("2. Eliminar Libros");
        System.out.println("3. Editar Libros");
        System.out.println("4. Agregar Libros");
        System.out.println("5. Listar Autor");
        System.out.println("6. Eliminar Autor");
        System.out.println("7. Editar Autor");
        System.out.println("8. Agregar Autor");
        System.out.println("9. Salir");
        System.out.print("Escoja opción [1-5]: ");
        
     }
    public static void inicio()
     {
          int opcion;
        do {            
            menu();
            opcion = leer.entero();
            switch(opcion){
                case 1:
                    listarlibro();
                    break;
                case 2:
                    eliminarlibro();
                    break;
                case 3:
                    editarlibro();
                    break;
                case 4:
                    agregarlibros();
                    break;
                case 5:
                    listarautor();
                    break;
                case 6:
                    eliminarautor();
                    break;
                case 7:
                    editarautor();
                    break;
                case 8:
                    agregarautor();
                    break;                
                case 9:
                    salir();
                    break;
            }
        } while (opcion!=9);
     }
     public static void main(String[] args) {
         //inicio();
         listarlibro();
    }
}
