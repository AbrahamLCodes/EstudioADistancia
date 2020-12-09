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
import android.widget.ListView;

public class NovedadesFragment extends Fragment{

    private ListView lista;
    private Notificacion [] notificaciones = {
            new Notificacion(
                    "Suspensión de labores docentes",
                    "23/Sep/2020",
                    "9:00 A.M",
                    "Servicios Escolares"),
            new Notificacion(
                    "Aprobaste la II Unidad",
                    "29/Oct/2020",
                    "12:00 A.M",
                    "Fundamentos de Bases de Datos"),
            new Notificacion(
                    "Nueva tarea asignada",
                    "Hoy",
                    "3:30 P.M",
                    "Servicios Escolares"),
            new Notificacion(
                    "Nueva tarea asignada",
                    "Ayer",
                    "3:00 P.M",
                    "Cálculo Integral"),
            new Notificacion(
                    "Nueva tarea asignada",
                    "Hoy",
                    "11:37 A.M",
                    "Fund. De programación"),
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

    private void initComponents(View v){
        lista = v.findViewById(R.id.lista);
        lista.setAdapter(new NotificacionAdapter(
                getContext(),
                R.layout.adapter_notificacion,
                notificaciones
        ));
    }
}