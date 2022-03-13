package C09;

public class Reserva {
    protected int DNI;
    protected String nombre;
    protected String apellido;
    protected int cuenta;
    protected int telefono;
    protected int fechaEntrada;
    protected int fechaSalida;
    protected String alimento;
    protected int ocupada=-1;

    public Reserva(int DNI, String nombre, String apellido, int cuenta, int telefono, int fechaEntrada, int fechaSalida,String alimento){
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellido=apellido;
        this.cuenta=cuenta;
        this.telefono=telefono;
        this.fechaEntrada=fechaEntrada;
        this.fechaSalida=fechaSalida;
        this.alimento=alimento;
        this.ocupada=1;
    }
    public Reserva(){

    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(int fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
}
