package android.apps.estudioadistancia.adapters;

import android.app.Activity;
import android.apps.estudioadistancia.R;
import android.apps.estudioadistancia.modeldata.Pendiente;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PendienteAdapter extends ArrayAdapter<Pendiente> {

    private Pendiente[] objects;
    private Context context;
    private int resource;

    public PendienteAdapter(@NonNull Context context, int resource, @NonNull Pendiente[] objects){
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
        TextView titulo;
        TextView fecha;
        TextView materia;

        //Recuperando componentes
        titulo = convertView.findViewById(R.id.titulo);
        fecha = convertView.findViewById(R.id.fecha);
        materia = convertView.findViewById(R.id.materia);

        //titulo = 0, motor = 1, matricula = 2

        titulo.setText(objects[position].getTitulo());
        fecha.setText(objects[position].getFecha());
        materia.setText(objects[position].getMateria());

        return convertView;
    }

}
