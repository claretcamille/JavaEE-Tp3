package bowling;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Fichier de test de la class Manche 
 * @author camilleclaret
 */
public class MancheTest {
    private Manche m;
    private Manche m1;
    
    @Before
    public void setUp() {
        m1 = new Manche(2,new Manche());
        m = new Manche(1,m1);
    }
    
   @Test
   public void mancheAcceptable(){
       // vérification des exceptions lors de la création d'une manche
       try{
           m = new Manche(-1,m1);
           m = new Manche(3,null);
       }catch (IllegalArgumentException e){
           assertEquals(1,m.getNumManche());
       }
   }
   
   @Test
   public void get(){
       // Vérification du numéro de manche 
       assertEquals(1, m.getNumManche());
       assertEquals(2,m1.getNumManche());
       // Vérification de la boule jouer
       m.quilleAbbatue(5);
       assertEquals(1,m.getBouleAct());
       m.quilleAbbatue(3);
       assertEquals(2,m.getBouleAct());
   }
   
   @Test
   public void True(){
       // Cas ou on attend un retour positif
       m.quilleAbbatue(10);
       assertTrue(m.isStricke());
       assertTrue(m.isFinManche());
       m1.quilleAbbatue(5);
       m1.quilleAbbatue(5);
       assertTrue(m1.isSpare());
       assertTrue(m1.isFinManche());
   }
   
   @Test
   public void False(){
       m.quilleAbbatue(5);
       assertFalse(m.isStricke());
       assertFalse(m.isFinManche());
       m.quilleAbbatue(3);
       assertFalse(m.isSpare());
       
   }
   
   @Test
   public void BonnusStricke(){
       m.quilleAbbatue(10);
       m1.quilleAbbatue(3);
       m1.quilleAbbatue(5);
       assertEquals(18, m.stickeBonus());
      
   }
   
   @Test
   public void BonnusSpare(){
       m.quilleAbbatue(5);
       m.quilleAbbatue(5);
       m1.quilleAbbatue(10);
       assertEquals(10, m.spareBonus());
      
   }
   
   @Test
   public void testScoreStricke(){
       this.m.quilleAbbatue(10);
       this.m1.quilleAbbatue(5);
       this.m1.quilleAbbatue(3);
      assertEquals(28, this.m.score());
   }
   
   public void testScoreSpare(){
       this.m.quilleAbbatue(3);
       this.m.quilleAbbatue(7);
       this.m1.quilleAbbatue(2);
       this.m1.quilleAbbatue(3);
      assertEquals(12, this.m.score());
   }
   
   public void testScoreNormal(){
       this.m.quilleAbbatue(2);
       this.m.quilleAbbatue(7);
      assertEquals(9, this.m.score());
   }
}
