package android.apps.estudioadistancia.modeldata;

public class Pdf {

    String titulo, fecha, materia, link;

    public Pdf(String titulo, String fecha, String materia, String link){
        this.titulo = titulo;
        this.fecha = fecha;
        this.materia = materia;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
