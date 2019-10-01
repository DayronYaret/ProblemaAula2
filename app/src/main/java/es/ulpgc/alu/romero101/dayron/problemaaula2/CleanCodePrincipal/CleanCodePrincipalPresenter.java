package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CleanCodePrincipalPresenter implements CleanCodePrincipalContract.Presenter {

  public static String TAG = CleanCodePrincipalPresenter.class.getSimpleName();

  private WeakReference<CleanCodePrincipalContract.View> view;
  private CleanCodePrincipalViewModel viewModel;
  private CleanCodePrincipalContract.Model model;
  private CleanCodePrincipalContract.Router router;
  private String comunidad;

  public CleanCodePrincipalPresenter(CleanCodePrincipalState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    CleanCodePrincipalState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayData(viewModel);

      return;
    }

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void comunidadElegida(int x, int y) {
    comunidad = model.comunidadElegida(x,y);
    switch (comunidad) {

      case "Canarias":

        router.iniciarCanarias();

        break;

      case "Andalucía":

        router.iniciarAndalucia();

        break;

      case "Extremadura":

        //instrucciones;

        break;

      case "Madrid":

        //instrucciones;

        break;

      case "Castilla la Mancha":

        //instrucciones;

        break;

      case "Baleares":

        //instrucciones;

        break;

      default:

        //sentencias;

        break;



    }

  }

  @Override
  public void injectView(WeakReference<CleanCodePrincipalContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CleanCodePrincipalContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CleanCodePrincipalContract.Router router) {
    this.router = router;
  }
}
