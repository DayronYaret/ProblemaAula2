package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.alu.romero101.dayron.problemaaula2.AppMediator;

public class CleanCodeAndaluciaRouter implements CleanCodeAndaluciaContract.Router {

  public static String TAG = CleanCodeAndaluciaRouter.class.getSimpleName();

  private AppMediator mediator;

  public CleanCodeAndaluciaRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CleanCodeAndaluciaActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(CleanCodeAndaluciaState state) {
    mediator.setCleanCodeAndaluciaState(state);
  }

  @Override
  public CleanCodeAndaluciaState getDataFromPreviousScreen() {
    CleanCodeAndaluciaState state = mediator.getCleanCodeAndaluciaState();
    return state;
  }
}
