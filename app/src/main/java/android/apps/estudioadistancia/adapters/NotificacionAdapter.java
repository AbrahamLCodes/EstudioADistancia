package android.apps.estudioadistancia.adapters;

import android.app.Activity;
import android.apps.estudioadistancia.R;
import android.apps.estudioadistancia.modeldata.Notificacion;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NotificacionAdapter extends ArrayAdapter<Notificacion> {

    private Notificacion[] objects;
    private Context context;
    private int resource;

    public NotificacionAdapter(@NonNull Context context, int resource, @NonNull Notificacion[] objects) {
        super(context, resource, objects);

        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {//Primera vez que se ejecuta la aplicación
            convertView = ((Activity) context).getLayoutInflater().inflate(resource, parent, false);
        }

        //Declarando componentes
        TextView titulo, fecha, hora, dependencia;

        //Recuperando componentes
        titulo = convertView.findViewById(R.id.titulo);
        fecha = convertView.findViewById(R.id.fecha);
        hora = convertView.findViewById(R.id.hora);
        dependencia = convertView.findViewById(R.id.dependencia);

        titulo.setText(objects[position].getNotificacion());
        fecha.setText(fecha.getText().toString() + objects[position].getFecha());
        hora.setText(hora.getText().toString() + objects[position].getHora());
        dependencia.setText(objects[position].getDependencia());
        return convertView;
    }

}
