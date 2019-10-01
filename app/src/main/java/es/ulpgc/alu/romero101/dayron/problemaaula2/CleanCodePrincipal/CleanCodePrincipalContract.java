package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal;

import java.lang.ref.WeakReference;

public interface CleanCodePrincipalContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(CleanCodePrincipalViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void comunidadElegida(int x, int y);
  }

  interface Model {
    String fetchData();

    String comunidadElegida(int x, int y);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(CleanCodePrincipalState state);

    void iniciarCanarias();

    CleanCodePrincipalState getDataFromPreviousScreen();

    void iniciarAndalucia();
  }
}
