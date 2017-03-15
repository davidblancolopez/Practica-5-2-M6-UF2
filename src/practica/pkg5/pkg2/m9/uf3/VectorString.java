package practica.pkg5.pkg2.m9.uf3;

import java.io.Serializable;


public class VectorString implements Serializable{
    
    private String[] arrayStrings;

    public VectorString(String[] arrayStrings) {
        this.arrayStrings = arrayStrings;
    }

    public VectorString() {
    }

    public String[] getArrayStrings() {
        return arrayStrings;
    }

    public void setArrayStrings(String[] arrayStrings) {
        this.arrayStrings = arrayStrings;
    }
    
    
    
}
