package es.ulpgc.alu.romero101.dayron.problemaaula2.pantallaPrincipal;

import java.util.ArrayList;

import es.ulpgc.alu.romero101.dayron.problemaaula2.CleanCodePrincipal.CleanCodePrincipalActivity;

public class ModeloPrincipal {
  ArrayList<CleanCodePrincipalActivity.Comunidad> comunidades = new ArrayList<CleanCodePrincipalActivity.Comunidad>();

  public ModeloPrincipal(){
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Canarias", 0, 1011, 367, 1163));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Andalucía", 339, 916, 713, 1072));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Extremadura", 345, 698, 483, 916));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Baleares", 873, 658, 1080, 868 ));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Castilla la Mancha", 492, 737, 708, 855));
    comunidades.add(new CleanCodePrincipalActivity.Comunidad("Madrid", 552, 658, 602, 705));
  }
}
