package pe.edu.ulima.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sodm on 10/17/2016.
 */
public class DosFragment extends Fragment {
    Button butSalir;
    OnBotonSalirClicked listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            //si quiero conversar con Pepe, el activity(context) debe ponerse la mascara
            listener = (OnBotonSalirClicked) context;
        }catch (ClassCastException cce){
            throw new RuntimeException("El Activity debe implementar la interface OnBotonSalirClicked");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dos,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        butSalir = (Button) getView().findViewById(R.id.butSalir);

        butSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //la mascara
                listener.onSalir();
            }
        });
    }

    public interface OnBotonSalirClicked{
        public void onSalir();
    }
}
