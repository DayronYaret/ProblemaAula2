package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CleanCodeCanariasPresenter implements CleanCodeCanariasContract.Presenter {

  public static String TAG = CleanCodeCanariasPresenter.class.getSimpleName();

  private WeakReference<CleanCodeCanariasContract.View> view;
  private CleanCodeCanariasViewModel viewModel;
  private CleanCodeCanariasContract.Model model;
  private CleanCodeCanariasContract.Router router;

  public CleanCodeCanariasPresenter(CleanCodeCanariasState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    CleanCodeCanariasState state = router.getDataFromPreviousScreen();
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
  public void injectView(WeakReference<CleanCodeCanariasContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CleanCodeCanariasContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CleanCodeCanariasContract.Router router) {
    this.router = router;
  }
}
