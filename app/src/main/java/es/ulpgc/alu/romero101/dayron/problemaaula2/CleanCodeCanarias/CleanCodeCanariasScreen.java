package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodeCanarias;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.alu.romero101.dayron.problemaaula2.AppMediator;

public class CleanCodeCanariasScreen {

  public static void configure(CleanCodeCanariasContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CleanCodeCanariasState state = mediator.getCleanCodeCanariasState();

    CleanCodeCanariasContract.Router router = new CleanCodeCanariasRouter(mediator);
    CleanCodeCanariasContract.Presenter presenter = new CleanCodeCanariasPresenter(state);
    CleanCodeCanariasContract.Model model = new CleanCodeCanariasModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
