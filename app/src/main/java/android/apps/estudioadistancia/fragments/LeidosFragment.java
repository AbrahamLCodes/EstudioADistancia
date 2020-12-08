package android.apps.estudioadistancia.fragments;

import android.apps.estudioadistancia.adapters.PdfAdapter;
import android.apps.estudioadistancia.modeldata.Pdf;
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

public class LeidosFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Pdf[] pdfs = {
            new Pdf(
                    "The C Programming Language",
                    "23/Enero/2021",
                    "Fundamentos de Programacion",
                    "http://mef-lab.com/osnove-2016/C-Programming-Ebook.pdf"),
            new Pdf(
                    "Fundamentos de Bases de Datos",
                    "10/Febrero/2021",
                    "Fundamentos de Bases de Datos",
                    "http://ceneval.isi.uson.mx/CENEVAL/4Implantacion%20de%20infraestructura/Fundamentos%20de%20base%20de%20datos.pdf"),
            new Pdf(
                    "Fundamentos de Telecomunicaciones",
                    "28/Enero/2021",
                    "Fundamentos de Telecomunicaciones,",
                    "https://www.itmerida.mx/panel/posgrado/archivos/mi/Fundamentos%20de%20Telecomunicaciones%20Unidad%201%20(1).pdf")

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leidos, container, false);
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
        lista.setOnItemClickListener(this);
        lista.setAdapter(
                new PdfAdapter(getContext(),R.layout.adapter_pdf, pdfs)
        );
    }
}