import MG2D.geometrie.Texture;

class Ennemi {
  private int vitesse;
  private Texture textennemi;
  
  public Ennemi(int x) {
    textennemi = new Texture("ennemi.png", new MG2D.geometrie.Point(x, 600), 60, 120);
  }
  
  public int getVitesse() {
    return vitesse;
  }
  
  public Texture getTextennemi() { return textennemi; }
  
  public void setVitesse(int vitesse)
  {
    this.vitesse = vitesse;
  }
  
  public void setTextennemi(Texture textennemi) { this.textennemi = textennemi; }
}
