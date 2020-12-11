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

public class LeidosFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Pdf[] pdfs = {
            new Pdf(
                    "Matematicas Primer grado",
                    "23/09/2020",
                    "Matematicas",
                    "https://libros.conaliteg.gob.mx/20/P1MAA.htm")

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
        openDialog(pdfs[i].getLink());
    }

    private void openDialog(String l) {
        Dialogo dialogo = new Dialogo(l,"¿Reabrir PDF?");
        dialogo.show(getFragmentManager(), "Reabrir PDF");
    }

    private void initComponents(View v){
        lista = v.findViewById(R.id.lista);
        lista.setOnItemClickListener(this);
        lista.setAdapter(
                new PdfAdapter(getContext(),R.layout.adapter_leidos, pdfs)
        );
    }
}