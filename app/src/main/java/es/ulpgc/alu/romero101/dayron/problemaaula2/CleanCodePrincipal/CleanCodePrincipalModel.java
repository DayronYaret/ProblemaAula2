package es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal;

import java.util.ArrayList;

public class CleanCodePrincipalModel implements CleanCodePrincipalContract.Model {

  public static String TAG = CleanCodePrincipalModel.class.getSimpleName();
  ArrayList<CleanCodePrincipalActivity.Comunidad> comunidades = new ArrayList<CleanCodePrincipalActivity.Comunidad>();

  public CleanCodePrincipalModel() {
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Canarias", 0, 1011, 367, 1163));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Andalucía", 368, 899, 667, 995));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Extremadura", 345, 698, 483, 916));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Baleares", 873, 658, 1080, 868 ));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Castilla la Mancha", 492, 737, 708, 855));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Madrid", 552, 658, 602, 705));
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
  public String comunidadElegida(int x, int y){
    for(int i =0; i<comunidades.size(); i++){
      if(x>comunidades.get(i).getMinx()&&y>comunidades.get(i).getMiny()&&x<comunidades.get(i).getMaxx()&&y<comunidades.get(i).getMaxy()){
        return comunidades.get(i).getComunidad();
      }
    }
    return"";
  }
}
