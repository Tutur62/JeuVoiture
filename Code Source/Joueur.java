import MG2D.geometrie.Texture;

class Joueur
{
  private Texture textjoueur;
  
  public Joueur(String chemin) {
    textjoueur = new Texture(chemin, new MG2D.geometrie.Point(120, 0), 60, 120);
  }
  
  Texture getTextjoueur() {
    return textjoueur;
  }
  
  public void setTextjoueur(Texture textjoueur) {
    this.textjoueur = textjoueur;
  }
  
  boolean boom(Ennemi player2) {
    if (textjoueur.intersection(player2.getTextennemi())) {
      return false;
    }
    
    return true;
  }
}
