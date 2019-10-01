package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.alu.romero101.dayron.problemaaula2.AppMediator;
import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia.CleanCodeAndaluciaActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia.CleanCodeAndaluciaState;
import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias.CleanCodeCanariasActivity;

public class CleanCodePrincipalRouter implements CleanCodePrincipalContract.Router {

  public static String TAG = CleanCodePrincipalRouter.class.getSimpleName();

  private AppMediator mediator;

  public CleanCodePrincipalRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CleanCodePrincipalActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(CleanCodePrincipalState state) {
    mediator.setState(state);
  }

  @Override
  public CleanCodePrincipalState getDataFromPreviousScreen() {
    CleanCodePrincipalState state = mediator.getState();
    return state;
  }

  @Override
  public void iniciarAndalucia() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CleanCodeAndaluciaActivity.class);
    context.startActivity(intent);
  }

  public void iniciarCanarias(){
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CleanCodeCanariasActivity.class);
    context.startActivity(intent);
  }
}
