import java.util.Scanner;

public class Morpion {
    public static void main(String[] args) {
        Grille grille = new Grille();
        Joueur joueur1 = new Joueur('X');
        Joueur joueur2 = new Joueur('O');
        Joueur joueurActuel = joueur1;

        Scanner scanner = new Scanner(System.in);
        boolean jeuEnCours = true;

        System.out.println("Bienvenue dans le jeu du Morpion !");
        while (jeuEnCours) {
            grille.afficherGrille();
            System.out.println("Joueur " + joueurActuel.getSymbole() + ", choisissez une case (1-9) : ");
            int choix = scanner.nextInt();

            if (grille.placerSymbole(choix, joueurActuel.getSymbole())) {
                if (grille.verifierVictoire(joueurActuel.getSymbole())) {
                    grille.afficherGrille();
                    System.out.println("Félicitations ! Joueur " + joueurActuel.getSymbole() + " a gagné !");
                    jeuEnCours = false;
                } else if (grille.estPleine()) {
                    grille.afficherGrille();
                    System.out.println("Match nul !");
                    jeuEnCours = false;
                } else {
                    joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
                }
            } else {
                System.out.println("Choix invalide. Essayez encore.");
            }
        }
    }
}
