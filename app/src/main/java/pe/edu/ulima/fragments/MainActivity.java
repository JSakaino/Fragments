package pe.edu.ulima.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DosFragment.OnBotonSalirClicked{
    Button butCambiarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butCambiarFragment = (Button) findViewById(R.id.butCambiarFragment);

        butCambiarFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DosFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.fraContenido,fragment);
                ft.commit();
            }
        });

        Fragment fragment = new EjemploFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.fraContenido,fragment);
        ft.commit();

    }

    @Override
    public void onSalir() {
        finish();
    }
}
