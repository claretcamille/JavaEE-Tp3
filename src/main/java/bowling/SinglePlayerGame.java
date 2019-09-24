package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
                        
                        Manche MancheActuelle;
                        Manche MancheUn;
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
                                    MancheActuelle = new Manche();
                                    // Incrémentation des différente manche 
                                    for(int n = 9; n > 0; n--){
                                               Manche manche = new Manche(n,this.MancheActuelle) ;
                                               this.MancheActuelle = manche;          
                                    }
                                    this.MancheUn = this.MancheActuelle;
           
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
                                    if(this.MancheActuelle.isFinManche()){
                                                // Cas des manche 1 à 9
                                                this.MancheActuelle = this.MancheActuelle.mancheSuiv;
                                    } else if (this.MancheActuelle.mancheSuiv == null || this.MancheActuelle.isFinManche()){
                                                throw new UnsupportedOperationException("Le jeu est fini");
                                    } else {
                                                this.MancheActuelle.quilleAbbatue(nombreDeQuillesAbattues);
                                    }
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
                                   return this.MancheUn.score();
	}
}
