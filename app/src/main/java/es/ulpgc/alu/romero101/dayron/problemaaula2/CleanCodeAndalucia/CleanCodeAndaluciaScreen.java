package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeAndalucia;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.AppMediator;

public class CleanCodeAndaluciaScreen {

  public static void configure(CleanCodeAndaluciaContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CleanCodeAndaluciaState state = mediator.getCleanCodeAndaluciaState();

    CleanCodeAndaluciaContract.Router router = new CleanCodeAndaluciaRouter(mediator);
    CleanCodeAndaluciaContract.Presenter presenter = new CleanCodeAndaluciaPresenter(state);
    CleanCodeAndaluciaContract.Model model = new CleanCodeAndaluciaModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
