package interfaces;
import java.util.List;
import modelo.Libro;
public interface CRUD  {
    public List listarlibro();
    public Libro buscarlibro(int libro);
    public boolean agregarlibro(Libro libro);
    public boolean editarlibro(Libro libro); 
    public boolean eliminarlibro(int libro);
    
}
