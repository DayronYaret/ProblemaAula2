package es.ulpgc.alu.romero101.dayron.problemaaula2;

import android.app.Application;

import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia.CleanCodeAndaluciaState;
import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias.CleanCodeCanariasState;
import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal.CleanCodePrincipalState;

public class AppMediator extends Application {

  private CleanCodePrincipalState state;
  private CleanCodeCanariasState canariasState;
  private CleanCodeAndaluciaState andaluciaState;
  @Override
  public void onCreate() {
    super.onCreate();

    this.state = new CleanCodePrincipalState();
  }



  public CleanCodePrincipalState getState() {
    return this.state;
  }

  public void setState(CleanCodePrincipalState state) {
    this.state = state;
  }

  public CleanCodeCanariasState getCleanCodeCanariasState() {
    return canariasState;
  }

  public void setCleanCodeCanariasState(CleanCodeCanariasState state) {
    this.canariasState=state;
  }

  public void setCleanCodeAndaluciaState(CleanCodeAndaluciaState state) {
    this.andaluciaState=state;
  }

  public CleanCodeAndaluciaState getCleanCodeAndaluciaState() {
    return andaluciaState;
  }
}
