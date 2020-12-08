package android.apps.estudioadistancia.fragments;

import android.apps.estudioadistancia.adapters.ClaseAdapter;
import android.apps.estudioadistancia.modeldata.Clase;
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


public class ClasesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Clase[] clases = {
            new Clase("Fundamentos de Programacion","4"),
            new Clase("Fundamentos de Bases de Datos","1"),
            new Clase("Fundamentos de Telecomunicaciones","3"),
            new Clase("Cálculo Integral","0"),
            new Clase("Física","0"),
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clases, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getContext(), ""+i, Toast.LENGTH_SHORT).show();
    }

    private void initComponents(View v){
        lista = v.findViewById(R.id.lista);
        lista.setAdapter(new ClaseAdapter(
                getContext(),
                R.layout.adapter_clases,
                clases
        ));
        lista.setOnItemClickListener(this);
    }
}