package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.R;

public class CleanCodeCanariasActivity
    extends AppCompatActivity implements CleanCodeCanariasContract.View {

  public static String TAG = CleanCodeCanariasActivity.class.getSimpleName();

  private CleanCodeCanariasContract.Presenter presenter;
  private MediaPlayer mp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clean_code_canarias);

    // do the setup
    CleanCodeCanariasScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    reproducirCanarias();
  }

  @Override
  public void displayData(CleanCodeCanariasViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    // deal with the data
  }


  public void reproducirCanarias() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(), R.raw.canarias);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp = MediaPlayer.create(getApplicationContext(), R.raw.canarias);
      mp.start();
    }
  }

  @Override
  public void injectPresenter(CleanCodeCanariasContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    mp.release();
  }
}
