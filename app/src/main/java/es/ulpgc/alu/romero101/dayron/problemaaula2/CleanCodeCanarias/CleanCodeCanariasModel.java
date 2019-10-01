package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias;

import android.util.Log;

import java.lang.ref.WeakReference;


public class CleanCodeCanariasModel implements CleanCodeCanariasContract.Model {

  public static String TAG = CleanCodeCanariasModel.class.getSimpleName();

  public CleanCodeCanariasModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
