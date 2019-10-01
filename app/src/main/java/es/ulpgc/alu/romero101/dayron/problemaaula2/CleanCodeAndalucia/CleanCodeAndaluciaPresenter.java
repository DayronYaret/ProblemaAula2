package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CleanCodeAndaluciaPresenter implements CleanCodeAndaluciaContract.Presenter {

  public static String TAG = CleanCodeAndaluciaPresenter.class.getSimpleName();

  private WeakReference<CleanCodeAndaluciaContract.View> view;
  private CleanCodeAndaluciaViewModel viewModel;
  private CleanCodeAndaluciaContract.Model model;
  private CleanCodeAndaluciaContract.Router router;

  public CleanCodeAndaluciaPresenter(CleanCodeAndaluciaState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    CleanCodeAndaluciaState state = router.getDataFromPreviousScreen();
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
  public void injectView(WeakReference<CleanCodeAndaluciaContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CleanCodeAndaluciaContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CleanCodeAndaluciaContract.Router router) {
    this.router = router;
  }
}
