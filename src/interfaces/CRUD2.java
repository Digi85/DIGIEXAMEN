package interfaces;
import java.util.List;
import modelo.Autor;

public interface CRUD2 {
    public List listarautor();
    public Autor buscarautor(int autor);
    public boolean agregarautor(Autor autor);
    public boolean editarautor(Autor autor);
    public boolean eliminarautor(int autor); 
}
