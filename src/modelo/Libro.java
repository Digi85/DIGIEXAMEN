package modelo;


public class Libro {
    private int idlibro;
    private String nombre;
    private String codigo;
    private String ISBN;
    private String fecha_publicacion;
    private int stock;
    private double precio_compra;
    private String estado;
    private int idautor;
    private int ideditorial;
    
    private String autorapellidos;
    private String autornombre;
    private String editorialnombre;

    public Libro(int idlibro, String nombre, String codigo, String ISBN, String fecha_publicacion, int stock, double precio_compra, String estado, int idautor, int ideditorial, String autorapellidos, String autornombre, String editorialnombre) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.estado = estado;
        this.idautor = idautor;
        this.ideditorial = ideditorial;
        this.autorapellidos = autorapellidos;
        this.autornombre = autornombre;
        this.editorialnombre = editorialnombre;
    }
    
    public Libro() {
    }

    public Libro(int idlibro, String nombre, String codigo, String ISBN, String fecha_publicacion, int stock, double precio_compra, String estado, int idautor, int ideditorial) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.estado = estado;
        this.idautor = idautor;
        this.ideditorial = ideditorial;
    }

    public Libro(int idlibro, String nombre, String codigo, String ISBN, String fecha_publicacion, int stock, double precio_compra, String estado) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compradecimal(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getAutorapellidos() {
        return autorapellidos;
    }

    public void setAutorapellidos(String autorapellidos) {
        this.autorapellidos = autorapellidos;
    }

    public String getAutornombre() {
        return autornombre;
    }

    public void setAutornombre(String autornombre) {
        this.autornombre = autornombre;
    }

    public String getEditorialnombre() {
        return editorialnombre;
    }

    public void setEditorialnombre(String editorialnombre) {
        this.editorialnombre = editorialnombre;
    }
    
    
          
}
