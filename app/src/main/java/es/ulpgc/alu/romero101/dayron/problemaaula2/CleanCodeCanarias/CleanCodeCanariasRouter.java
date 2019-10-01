package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.alu.romero101.dayron.problemaaula2.AppMediator;

public class CleanCodeCanariasRouter implements CleanCodeCanariasContract.Router {

  public static String TAG = CleanCodeCanariasRouter.class.getSimpleName();

  private AppMediator mediator;

  public CleanCodeCanariasRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CleanCodeCanariasActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(CleanCodeCanariasState state) {
    mediator.setCleanCodeCanariasState(state);
  }

  @Override
  public CleanCodeCanariasState getDataFromPreviousScreen() {
    CleanCodeCanariasState state = mediator.getCleanCodeCanariasState();
    return state;
  }
}
