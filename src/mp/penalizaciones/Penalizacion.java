package mp.penalizaciones;

import java.io.Serializable;
import java.util.Date;

public class Penalizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fechaInicio;
    private Date fechaFin;

    public Penalizacion() {
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        long fechaFinOK = this.fechaFin.getTime() + 172800000;
        this.fechaFin.setTime(fechaFinOK);//2 días en milisegundos
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean siguePenalizando() {
        Date presente = new Date();
        return this.fechaFin.after(presente);
    }
}