package interfaces;
import java.util.List;
import modelo.Editorial;

public interface CRUD3 {
     public List listaresteditorial();
    public Editorial buscareditorial(int editorial);
    public boolean agregareditorial(Editorial editorial);
    public boolean editareditorial(Editorial editorial);
    public boolean eliminareditorial(int editorial);  
}
