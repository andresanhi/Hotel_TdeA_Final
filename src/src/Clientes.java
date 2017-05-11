package src;
//@author Jhony_Angulo

class Clientes {

    String nombre;
    int tipo, cc, telefono, hospedajes;
    String email;

    public Clientes(int tipo, int cc, String nombre, int telefono, String email,int hospedajes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cc = cc;
        this.telefono = telefono;
        this.email = email;
    }

    public void setHospedajes(int hospedajes) {
        this.hospedajes = hospedajes;
    }

}
