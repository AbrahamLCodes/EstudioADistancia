package android.apps.estudioadistancia.fragments;

import android.apps.estudioadistancia.R;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogo extends AppCompatDialogFragment implements View.OnClickListener {

    private TextView no, si;
    private String link;

    public Dialogo(String link) {
        this.link = link;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        no = view.findViewById(R.id.no);
        si = view.findViewById(R.id.si);

        no.setOnClickListener(this);
        si.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.no:
                dismiss();
                break;
            case R.id.si:
                openPDF();
                dismiss();
                break;
        }
    }

    private void openPDF() {
        Uri uri = Uri.parse(link); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
