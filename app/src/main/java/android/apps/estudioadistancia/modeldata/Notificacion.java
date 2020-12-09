package android.apps.estudioadistancia.modeldata;

public class Notificacion {

    private String notificacion, fecha, hora, dependencia;

    public Notificacion(String notificacion, String fecha, String hora, String dependencia) {
        this.notificacion = notificacion;
        this.fecha = fecha;
        this.hora = hora;
        this.dependencia = dependencia;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
}
