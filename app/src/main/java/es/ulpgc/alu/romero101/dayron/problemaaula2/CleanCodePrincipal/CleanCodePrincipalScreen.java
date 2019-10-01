package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.AppMediator;

public class CleanCodePrincipalScreen {

  public static void configure(CleanCodePrincipalContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CleanCodePrincipalState state = mediator.getState();

    CleanCodePrincipalContract.Router router = new CleanCodePrincipalRouter(mediator);
    CleanCodePrincipalContract.Presenter presenter = new CleanCodePrincipalPresenter(state);
    CleanCodePrincipalContract.Model model = new CleanCodePrincipalModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
