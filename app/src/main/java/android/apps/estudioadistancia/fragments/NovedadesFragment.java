package android.apps.estudioadistancia.fragments;

import android.apps.estudioadistancia.adapters.NotificacionAdapter;
import android.apps.estudioadistancia.modeldata.Notificacion;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.apps.estudioadistancia.R;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class NovedadesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Notificacion [] notificaciones = {
            new Notificacion(
                    "Tarea para los padres de familia",
                    "12/Oct/2020",
                    "11:00 A.M",
                    "Educación Socio Emocional"),
            new Notificacion(
                    "Aprendizajes Claves",
                    "8/Oct/2020",
                    "12:00 A.M",
                    "Educacion Socio Emocional")
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_novedades, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 1) {
            String link = "https://www.planyprogramasdestudio.sep.gob.mx/descargables/biblioteca/primaria/1grado/V-i-EDUCACION-SOCIOEMOCIONAL.pdf";
            openDialog(link);
        }
    }

    private void openDialog(String l) {
        Dialogo dialogo = new Dialogo(l,"¿Abrir PDF?");
        dialogo.show(getFragmentManager(), "Abrir PDF");
    }

    private void initComponents(View v){
        lista = v.findViewById(R.id.lista);
        lista.setAdapter(new NotificacionAdapter(
                getContext(),
                R.layout.adapter_notificacion,
                notificaciones
        ));
        lista.setOnItemClickListener(this);
    }
}