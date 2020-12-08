package android.apps.estudioadistancia.adapters;

import android.app.Activity;
import android.apps.estudioadistancia.R;
import android.apps.estudioadistancia.modeldata.Clase;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClaseAdapter extends ArrayAdapter<Clase> {

    private Clase[] objects;
    private Context context;
    private int resource;

    public ClaseAdapter(@NonNull Context context, int resource, @NonNull Clase[] objects) {
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
        TextView nombre;
        TextView tareas;

        //Recuperando componentes
        nombre = convertView.findViewById(R.id.titulo);
        tareas = convertView.findViewById(R.id.tareas);

        nombre.setText(objects[position].getNombre());
        tareas.setText(tareas.getText().toString() + objects[position].getTareas());
        return convertView;
    }
}
