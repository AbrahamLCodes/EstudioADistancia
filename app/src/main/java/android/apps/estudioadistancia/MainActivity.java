package android.apps.estudioadistancia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.apps.estudioadistancia.fragments.NovedadesFragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import android.apps.estudioadistancia.fragments.ClasesFragment;
import android.apps.estudioadistancia.fragments.CreditosFragment;
import android.apps.estudioadistancia.fragments.LeidosFragment;
import android.apps.estudioadistancia.fragments.PendienteFragment;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener {

    private ImageView toggleDrawer;
    private TextView titulo;
    private DrawerLayout drawerLayout;
    private NavigationView navview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        toggleDrawer = findViewById(R.id.toggleDrawer);
        drawerLayout = findViewById(R.id.drawerLayout);
        titulo = findViewById(R.id.titulo);
        navview = findViewById(R.id.nav_view);

        toggleDrawer.setOnClickListener(this);
        navview.setNavigationItemSelectedListener(this);

        titulo.setText("Novedades");
        changeFragment(new NovedadesFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toggleDrawer:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemNovedades:
                changeFragment(new NovedadesFragment());
                titulo.setText("Novedades");
                break;
            case R.id.itemPendiente:
                changeFragment(new PendienteFragment());
                titulo.setText("Tareas Pendientes");
                break;
            case R.id.itemClases:
                changeFragment(new ClasesFragment());
                titulo.setText("Clases");
                break;
            case R.id.itemLeidos:
                changeFragment(new LeidosFragment());
                titulo.setText("Leídos");
                break;
            case R.id.itemCreditos:
                changeFragment(new CreditosFragment());
                titulo.setText("Créditos");
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fmf, fragment);
        ft.commit();
    }
}