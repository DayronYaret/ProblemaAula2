package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.R;

public class CleanCodeAndaluciaActivity
    extends AppCompatActivity implements CleanCodeAndaluciaContract.View {

  public static String TAG = CleanCodeAndaluciaActivity.class.getSimpleName();
  private MediaPlayer mp;

  private CleanCodeAndaluciaContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clean_code_andalucia);

    // do the setup
    CleanCodeAndaluciaScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    // load the data
    reproducirAndalucia();
  }

  @Override
  public void displayData(CleanCodeAndaluciaViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

  }

  public void reproducirAndalucia() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(), R.raw.andalucia);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp = MediaPlayer.create(getApplicationContext(), R.raw.andalucia);
      mp.start();
    }
  }

  @Override
  public void injectPresenter(CleanCodeAndaluciaContract.Presenter presenter) {
    this.presenter = presenter;
  }
  @Override
  public void onBackPressed() {
    super.onBackPressed();
    mp.release();
  }
}
