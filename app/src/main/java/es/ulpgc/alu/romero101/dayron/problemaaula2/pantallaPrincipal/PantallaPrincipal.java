package es.ulpgc.alu.romero101.dayron.problemaaula2.pantallaPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import es.ulpgc.alu.romero101.dayron.problemaaula2.R;

public class PantallaPrincipal extends AppCompatActivity {

    ImageView mapa;
    int x;
    int y;
    String comunidad = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        mapa = findViewById(R.id.mapa);

        mapa.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Toast.makeText(PantallaPrincipal.this, "Touch coordinates" + String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()), Toast.LENGTH_SHORT).show();
                    x = (int) event.getX();

                    y = (int) event.getY();
                }

                Toast.makeText(PantallaPrincipal.this, comunidadElegida(), Toast.LENGTH_SHORT).show();

                //Toast.makeText(PantallaPrincipal.this, comunidadElegida(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public String comunidadElegida() {
        comunidad = "";
        if (x > 0 && x < 367 && y > 1011 && y < 1163) {
            comunidad = "Canarias";
        } else if (x > 339 && x < 713 && y > 916 && y < 1072) {
            comunidad = "Andalucía";
        } else if (x > 345 && x < 483 && y > 698 && y < 916) {
            comunidad = "Extremadura";
        } else if (x > 873 && x < 1080 && y > 709 && y < 868) {
            comunidad = "Baleares";
        } else if (x > 552 && y > 658 && x < 602 && y < 705) {
            comunidad = "Madrid";
        } else if (x > 492 && y > 737 && x < 708 && y < 855) {
            comunidad = "Castilla la Mancha";

        }
        return comunidad;
    }
}
