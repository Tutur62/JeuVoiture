import MG2D.Fenetre;
import java.util.ArrayList;

class Jeu
{
  Jeu() {}
  
  private int score = 0; private int x = 0; private int y = 0; private int oldvaleur = 1;
  
  private boolean stop = true;
  
  private Fenetre f = new Fenetre("Hightway to hell", 800, 600);
  private MG2D.Clavier clavier = f.getClavier();
  
  private ArrayList<Ennemi> Listennemi = new ArrayList();
  
  private String texte = new String("Mon score=" + score);
  private MG2D.geometrie.Rectangle herbeg = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.VERT, new MG2D.geometrie.Point(0, 0), 100, 600, true);
  private MG2D.geometrie.Rectangle herbed = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.VERT, new MG2D.geometrie.Point(700, 0), 100, 600, true);
  private MG2D.geometrie.Rectangle route = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.GRIS, new MG2D.geometrie.Point(100, 0), 605, 600, true);
  private MG2D.geometrie.Rectangle tabscore = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.BLANC, new MG2D.geometrie.Point(0, 30), 100, 80, true);
  private MG2D.geometrie.Rectangle trait = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.BLANC, new MG2D.geometrie.Point(x, y), 5, 50, true);
  private MG2D.geometrie.Rectangle resultat = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.BLANC, new MG2D.geometrie.Point(0, 380), 800, 50, true);
  private MG2D.geometrie.Texture explosion = new MG2D.geometrie.Texture("explosion.gif", new MG2D.geometrie.Point(400, 300));
  private MG2D.geometrie.Texture gameover = new MG2D.geometrie.Texture("gameover.png", new MG2D.geometrie.Point(0, 300), 800, 80);
  private MG2D.geometrie.Texte texte3 = new MG2D.geometrie.Texte(MG2D.geometrie.Couleur.NOIR, "Score:", new java.awt.Font("Calibri", 1, 40), new MG2D.geometrie.Point(50, 80));
  private MG2D.geometrie.Texte texte2 = new MG2D.geometrie.Texte(MG2D.geometrie.Couleur.NOIR, texte, new java.awt.Font("Calibri", 1, 40), new MG2D.geometrie.Point(50, 50));
  private MG2D.geometrie.Texte texte4 = new MG2D.geometrie.Texte(MG2D.geometrie.Couleur.NOIR, texte, new java.awt.Font("Calibri", 1, 40), new MG2D.geometrie.Point(400, 400));
  private Joueur player = new Joueur("joueurr.png");
  private java.util.Random r = new java.util.Random();
  
  public void Jeu(int vitesse) {
    if (vitesse < 9) {
      vitesse = 10;
    }
    
    f.ajouter(herbed);
    f.ajouter(herbeg);
    f.ajouter(route);
    f.ajouter(tabscore);
    f.ajouter(texte3);
    
    for (x = 100; x <= 700; x += 100) {
      for (y = 10; y <= 600; y += 60) {
        trait = new MG2D.geometrie.Rectangle(MG2D.geometrie.Couleur.BLANC, new MG2D.geometrie.Point(x, y), 5, 50, true);
        f.ajouter(trait);
      }
    }
    
    f.ajouter(player.getTextjoueur());
    do
    {
      try {
        Thread.sleep(20L);
      }
      catch (Exception localException) {}
      
      texte2.setTexte(score);
      
      f.ajouter(texte2);
      
      if (Math.random() < 0.03D) {
        valeur = (1 + r.nextInt(6));
        

        if ((valeur == 1) && (oldvaleur != 1)) {
          Listennemi.add(new Ennemi(120));
          f.ajouter(((Ennemi)Listennemi.get(Listennemi.size() - 1)).getTextennemi());
        }
        if ((valeur == 2) && (oldvaleur != 2)) {
          Listennemi.add(new Ennemi(220));
          f.ajouter(((Ennemi)Listennemi.get(Listennemi.size() - 1)).getTextennemi());
        }
        if ((valeur == 3) && (oldvaleur != 3)) {
          Listennemi.add(new Ennemi(320));
          f.ajouter(((Ennemi)Listennemi.get(Listennemi.size() - 1)).getTextennemi());
        }
        if ((valeur == 4) && (oldvaleur != 4)) {
          Listennemi.add(new Ennemi(420));
          f.ajouter(((Ennemi)Listennemi.get(Listennemi.size() - 1)).getTextennemi());
        }
        if ((valeur == 5) && (oldvaleur != 5)) {
          Listennemi.add(new Ennemi(520));
          f.ajouter(((Ennemi)Listennemi.get(Listennemi.size() - 1)).getTextennemi());
        }
        if ((valeur == 6) && (oldvaleur != 6)) {
          Listennemi.add(new Ennemi(620));
          f.ajouter(((Ennemi)Listennemi.get(Listennemi.size() - 1)).getTextennemi());
        }
        
        oldvaleur = valeur;
      }
      
      if ((clavier.getDroite()) && 
        (player.getTextjoueur().getA().getX() < 650)) {
        player.getTextjoueur().translater(vitesse, 0);
      }
      
      if ((clavier.getGauche()) && 
        (player.getTextjoueur().getA().getX() > 110)) {
        player.getTextjoueur().translater(-vitesse, 0);
      }
      
      if ((clavier.getHaut()) && 
        (player.getTextjoueur().getA().getY() < 490)) {
        player.getTextjoueur().translater(0, vitesse);
      }
      
      if ((clavier.getBas()) && 
        (player.getTextjoueur().getA().getY() > 0)) {
        player.getTextjoueur().translater(0, -vitesse);
      }
      



      int max = Listennemi.size();
      for (int i = 0; i < max; i++)
      {
        if (score > 20) {
          ((Ennemi)Listennemi.get(i)).setVitesse((score - 1) / 2);
        }
        else {
          ((Ennemi)Listennemi.get(i)).setVitesse(10);
        }
        
        if (!player.boom((Ennemi)Listennemi.get(i)))
        {

          stop = false;
          f.rafraichir();
          player.getTextjoueur().translater(0, 20);
          f.ajouter(herbeg);
          explosion = new MG2D.geometrie.Texture("explosion.gif", new MG2D.geometrie.Point(player.getTextjoueur().getA().getX() - 70, player.getTextjoueur().getA().getY()));
          f.ajouter(explosion);
          f.ajouter(gameover);
          texte4.setTexte("Ton score:" + score);
          f.ajouter(resultat);
          f.ajouter(texte4);
        }
        ((Ennemi)Listennemi.get(i)).getTextennemi().translater(0, -((Ennemi)Listennemi.get(i)).getVitesse());
        if (((Ennemi)Listennemi.get(i)).getTextennemi().getB().getY() < 0)
        {
          f.supprimer(((Ennemi)Listennemi.get(i)).getTextennemi());
          Listennemi.remove(i);
          max--;
          score += 1;
        }
      }
      
      f.rafraichir();
    }
    while (stop);
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(20L);
      }
      catch (Exception localException1) {}
    }
    
    f.supprimer(player.getTextjoueur());
    f.supprimer(explosion);
  }
  
  private int valeur;
}
