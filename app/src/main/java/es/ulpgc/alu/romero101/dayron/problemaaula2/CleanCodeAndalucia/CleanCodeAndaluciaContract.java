package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia;

import java.lang.ref.WeakReference;

public interface CleanCodeAndaluciaContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(CleanCodeAndaluciaViewModel viewModel);
    void reproducirAndalucia();
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

    void passDataToNextScreen(CleanCodeAndaluciaState state);

    CleanCodeAndaluciaState getDataFromPreviousScreen();
  }
}
