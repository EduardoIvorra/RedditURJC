package mp.users;

import mp.penalizaciones.Penalizacion;
import mp.subforos.Comentario;
import mp.subforos.Entrada;
import mp.subforos.SubForo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MiembroURJC implements Serializable, Subscriptor {
    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private final int id;
    private final Queue<Notificacion> notificaciones;
    private String nombre;
    private String apellidos;
    private String nick;
    private String contrasena;
    private String email;
    private Penalizacion penalizacion;

    public MiembroURJC(String nombre, String apellidos, String nick, String contrasena, String email) {
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.contrasena = contrasena;
        this.email = email;
        this.notificaciones = new LinkedList<Notificacion>();
    }

    //GettersAndSetters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    private String getContrasena() {
        return contrasena;
    }

    private void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Penalizacion getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
    }

    public void eliminar() {
        contador--;
    }

    public void verNotificaciones() {
        // TODO - implement MiembroURJC.verNotificaciones
        throw new UnsupportedOperationException();
    }


    /**
     * @param idEntrada
     */
    public Comentario comentar(int idEntrada) {
        // TODO - implement MiembroURJC.comentar
        throw new UnsupportedOperationException();
    }

    /**
     * @param idComentario
     */
    public Comentario Responder(int idComentario) {
        // TODO - implement MiembroURJC.Responder
        throw new UnsupportedOperationException();
    }

    /**
     * @param idEntrada
     */
    public void votar(int idEntrada) {
        // TODO - implement MiembroURJC.votar
        throw new UnsupportedOperationException();
    }

    /**
     * @param idEntrada
     */
    public Entrada compartirEntrada(int idEntrada) {
        // TODO - implement MiembroURJC.compartirEntrada
        throw new UnsupportedOperationException();
    }

    /**
     * @param idEntrada
     */
    public Entrada modificarEntrada(int idEntrada) {
        // TODO - implement MiembroURJC.modificarEntrada
        throw new UnsupportedOperationException();
    }

    /**
     * @param idSubforo
     */
    public Subscripcion subscribirse(int idSubforo) {
        // TODO - implement MiembroURJC.subscribirse
        throw new UnsupportedOperationException();
    }

    public String viewSubForo(SubForo subForo) {
        return subForo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiembroURJC that = (MiembroURJC) o;
        return nick.equals(that.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick);
    }

    public boolean accepContrasena(String cont) {
        return this.getContrasena().equals(cont);
    }

    public void penalizar() {
        this.penalizacion = new Penalizacion();
    }

    public boolean estaPenalizado() {
        if (this.penalizacion == null) {
            return false;
        } else {
            return this.penalizacion.siguePenalizando();
        }
    }

    public void despenalizarUsuario() {
        this.penalizacion = null;

    }

    @Override
    public void recibirNotificacion(Notificacion notificacion) {
        this.notificaciones.add(notificacion);
    }

    public String listNotificaciones() {
        String strNotificaciones = "";
        for (int i = 0; i < getNumNotificaciones(); ++i) {
            strNotificaciones = "\n" + strNotificaciones + notificaciones.remove().toString();
        }
        return strNotificaciones;
    }

    public int getNumNotificaciones() {
        return this.notificaciones.size();
    }

    public Comentario crearComentario(String comentario) {
        return new Comentario(comentario, this);
    }

    public String viewSubForoRec(SubForo subForo) {
        return subForo.viewRec();
    }

    @Override
    public String toString() {
        return  "Nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'';
    }
}
