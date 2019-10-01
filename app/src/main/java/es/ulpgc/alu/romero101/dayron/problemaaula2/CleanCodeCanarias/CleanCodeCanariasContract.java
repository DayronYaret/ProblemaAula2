package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias;

import android.view.View;

import java.lang.ref.WeakReference;

public interface CleanCodeCanariasContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(CleanCodeCanariasViewModel viewModel);

    void reproducirCanarias();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(CleanCodeCanariasState state);

    CleanCodeCanariasState getDataFromPreviousScreen();
  }
}
