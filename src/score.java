
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eslam
 */
public class score implements Comparable, Serializable {
    private int score ;
    private String Name;

    public score(int score, String Name) {
        this.score = score;
        this.Name = Name;
    }

    public score() {
    }
    

    public int getScore() {
        return score;
    }

    public String getName() {
        return Name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    
    public int compareTo(Object o) {
        score s = (score)o;
        return (this.score- s.score);
    }

    @Override
    public String toString() {
        return  Name + ":  "+score;
    }
    
    
    
}
