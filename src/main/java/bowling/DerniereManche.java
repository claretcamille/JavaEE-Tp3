/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author camilleclaret
 */
public class DerniereManche extends Manche {
    int boule3 = 0;
    
    /*
    Constructeur de la classe
    */
    public DerniereManche(){
        this.numManche = 10; // num de la dernière manche 
        this.mancheSuiv = null ;// pas de manche suivante, fin de partie donc j'autorise la valeur null
    }
     /*
     Changement des fonctions pour la dernière manche
    */
    @Override
    public void quilleAbbatue(int nbrQ){
        if(nbrQ <0){
            throw new IllegalArgumentException("Un joueur peu abbattre minimun  0 quille en un lancer");
        } else if (this.bouleAct > 2){
            throw new IllegalArgumentException("Max 3 boules");
        } else {
            this.bouleAct ++;
            if (this.bouleAct == 1){
                this.boule1 = nbrQ;
            } else if (this.bouleAct == 2){
                this.boule2 = nbrQ;
            } else {
                this.boule3 = nbrQ;
            }
        }
    }
    
    @Override
    public int stickeBonus(){
        return this.boule1 + boule2;
    }
    
    @Override
    public int spareBonus(){
        return this.boule1 + this.boule2 + this.boule3;
    }
    
    @Override
    public boolean isFinManche(){
        if(this.isStricke() ^ this.isSpare() ){
            return this.bouleAct == 3;
        } else {
            return this.bouleAct == 2;
        }
    }
    @Override
    public int score() {
        return this.boule1 + this.boule2 + this.boule3;
    }
}
