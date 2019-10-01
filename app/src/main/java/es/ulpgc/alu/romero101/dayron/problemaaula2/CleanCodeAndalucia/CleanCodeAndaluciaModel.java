package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia;

import android.util.Log;
import java.lang.ref.WeakReference;

public class CleanCodeAndaluciaModel implements CleanCodeAndaluciaContract.Model {

  public static String TAG = CleanCodeAndaluciaModel.class.getSimpleName();

  public CleanCodeAndaluciaModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
