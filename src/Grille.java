// Classe pour gérer la grille
class Grille {
    private final char[][] grille;

    // Constructeur pour initialiser la grille
    public Grille() {
        grille = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
    }

    // Méthode pour afficher la grille
    public void afficherGrille() {
        for (char[] ligne : grille) {
            for (char caseGrille : ligne) {
                System.out.print(caseGrille + " ");
            }
            System.out.println();
        }
    }

    // Méthode pour placer un symbole dans la grille
    public boolean placerSymbole(int choix, char symbole) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i][j] == (char) (choix + '0')) {
                    grille[i][j] = symbole;
                    return true;
                }
            }
        }
        return false;
    }

    // Méthode pour vérifier si un joueur a gagné
    public boolean verifierVictoire(char symbole) {
        // Vérifier les lignes et colonnes
        for (int i = 0; i < 3; i++) {
            if ((grille[i][0] == symbole && grille[i][1] == symbole && grille[i][2] == symbole) ||
                    (grille[0][i] == symbole && grille[1][i] == symbole && grille[2][i] == symbole)) {
                return true;
            }
        }
        // Vérifier les diagonales
        return (grille[0][0] == symbole && grille[1][1] == symbole && grille[2][2] == symbole) ||
                (grille[0][2] == symbole && grille[1][1] == symbole && grille[2][0] == symbole);
    }

    // Méthode pour vérifier si la grille est pleine
    public boolean estPleine() {
        for (char[] ligne : grille) {
            for (char caseGrille : ligne) {
                if (caseGrille != 'X' && caseGrille != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
