package modelo;

public class Editorial {
    private int ideditorial;
    private String nombre;
    private String estado;

    public Editorial() {
    }

    public Editorial(int ideditorial, String nombre, String estado) {
        this.ideditorial = ideditorial;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
