package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.R;

public class CleanCodePrincipalActivity
    extends AppCompatActivity implements CleanCodePrincipalContract.View {

  public static String TAG = CleanCodePrincipalActivity.class.getSimpleName();
  ImageView mapa;
  int x;
  int y;
  String comunidad = "";

  private CleanCodePrincipalContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clean_code_principal);
    mapa=findViewById(R.id.mapa);

    // do the setup
    CleanCodePrincipalScreen.configure(this);
    mapa.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
         // Toast.makeText(CleanCodePrincipalActivity.this, "Touch coordinates" + String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()), Toast.LENGTH_SHORT).show();
          x = (int) event.getX();
          y = (int) event.getY();
          presenter.comunidadElegida(x,y);
        }

        return true;
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(CleanCodePrincipalViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    // deal with the data

  }

  @Override
  public void injectPresenter(CleanCodePrincipalContract.Presenter presenter) {
    this.presenter = presenter;
  }

  public static class Comunidad {
    private String comunidad;
    private int minx;
    private int miny;
    private int maxx;
    private int maxy;

    public Comunidad(String comunidad, int minx, int miny, int maxx, int maxy){
      this.comunidad=comunidad;
      this.minx=minx;
      this.miny=miny;
      this.maxx=maxx;
      this.maxy=maxy;
    }

    public String getComunidad() {
      return comunidad;
    }

    public void setComunidad(String comunidad) {
      this.comunidad = comunidad;
    }

    public int getMinx() {
      return minx;
    }

    public void setMinx(int minx) {
      this.minx = minx;
    }

    public int getMiny() {
      return miny;
    }

    public void setMiny(int miny) {
      this.miny = miny;
    }

    public int getMaxx() {
      return maxx;
    }

    public void setMaxx(int maxx) {
      this.maxx = maxx;
    }

    public int getMaxy() {
      return maxy;
    }

    public void setMaxy(int maxy) {
      this.maxy = maxy;
    }
  }
}
