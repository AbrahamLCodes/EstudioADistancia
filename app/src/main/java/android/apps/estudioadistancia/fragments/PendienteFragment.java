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


public class PendienteFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Pdf[] pdfs = {
            new Pdf(
                    "Lengua Materna Español Primer Grado",
                    "5/Sept/2020",
                    "Lengua Materna",
                    "https://libros.conaliteg.gob.mx/20/P1ESA.htm"),
            new Pdf(
                    "Conocimiento del Medio Primer Grado",
                    "15/Sept/2020",
                    "Fundamentos de Bases de Datos",
                    "https://libros.conaliteg.gob.mx/20/P1COA.htm")
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendiente, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        openDialog(pdfs[i].getLink());
    }

    private void openDialog(String l) {
        Dialogo dialogo = new Dialogo(l,"¿Abrir PDF?");
        dialogo.show(getFragmentManager(), "Abrir PDF");
    }

    private void initComponents(View v) {
        lista = v.findViewById(R.id.lista);
        lista.setAdapter(new PdfAdapter(
                getContext(),
                R.layout.adapter_pdf,
                pdfs
        ));
        lista.setOnItemClickListener(this);
    }
}