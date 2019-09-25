/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 * Class ayant pour but le controle d'une manche normale on a min 9 manches a deux boules
 * @author camilleclaret
 */
public class Manche {
    
    int numManche;
    Manche mancheSuiv;
    int boule1 = 0 ;
    int boule2 = 0;
    int bouleAct = 0 ;
    
    /*
    Constructeurs de la classe
    */
    public Manche(){}
    
    public Manche(int num, Manche numSuiv){
        if( num <1|| num > 9 ){
            throw new IllegalArgumentException("Une manche normale peut être numéroté que de 1 à 9.");
        } else if (numSuiv == null ){
            throw new IllegalArgumentException("Une manche doit forcément avoir une suivante.");
        } else {
            this.numManche = num;
            this.mancheSuiv = numSuiv;
        }
    }
    
    /*
    Les fonctions suivante vont être pour la récupération des données
    */
    
    public int getBouleAct(){
        // retourn le numéro de la boule jouer 
        return this.bouleAct;
    }
    
    public int getNumManche(){
        // retourne le numéro de manche 
        return this.numManche;
    }
    
    /*
    Les fonction devant retourner un boolean 
    */
    
    public boolean isFinManche(){
        // La partie est fini si un joueur joue ses deux boules ou si il fait un stricke
        return this.boule1 == 10 || this.bouleAct == 2;
    }
    
    public boolean isStricke(){
        // Le joueur fait un stricke si il décanille ses 10 quilles avec la première boule
        return this.boule1 == 10;
        
    }
    
    public boolean isSpare(){
        // Le joueur fait un spare si il decanille 10 quilles en 2 boules
        return this.boule1 + this.boule2 == 10;
    }
    
    /*
    Calcul des bonus selon un spare ou un stricke
    */
    
    public int stickeBonus(){
       if(isStricke()){
           return 10 + this.mancheSuiv.stickeBonus();
       } else{
           return boule1 + boule2;
       }
    }
    
    public int spareBonus(){
        return  this.mancheSuiv.boule1;
    }
    
    /*
    Calcul du score de la manche 
    */
    
    public void quilleAbbatue(int nbrQ){
        // Fonction qui affecte le nombre de quille abbatu par le joueur au bon numéro de boule
        if(nbrQ > 10 || nbrQ <0){
            throw new IllegalArgumentException("Un joueur peu abbattre entre 0 et 10 quille en un lancer");
        } else if (nbrQ + this.boule1 > 10){
            throw new IllegalArgumentException("En deux lancer le nbr maxi de quille abbatue est de 10");
        } else {
            this.bouleAct ++;
            if (this.bouleAct == 1){
                this.boule1 = nbrQ;
            }else{
                this.boule2 = nbrQ;
            }
        }
    }
    
    public int score() {
       int scoreM =0 ;
       if(this.isStricke()){
           scoreM = 10 + this.stickeBonus();
       } else if (this.isSpare()){
           scoreM = this.spareBonus();
       } else {
           scoreM = this.boule1 + this.boule2;
       }
       return scoreM;
    }
    
}
