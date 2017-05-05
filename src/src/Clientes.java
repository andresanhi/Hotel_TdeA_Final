package src;
//@author Jhony_Angulo

class Clientes {

    String nombre;
    int cc, telefono, hospedajes;

    public Clientes(int cc, String nombre, int telefono, int hospedajes) {
        this.nombre = nombre;
        this.cc = cc;
        this.telefono = telefono;
    }

    public void setHospedajes(int hospedajes) {
        this.hospedajes = hospedajes;
    }

}
