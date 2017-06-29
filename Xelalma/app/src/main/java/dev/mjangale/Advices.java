package dev.mjangale;

/**
 * Created by BIAYE on 29/06/2017.
 */

public class Advices {

    private String classe;
    private String advice;

    public Advices(String classe, String advice) {
        this.classe = classe;
        this.advice = advice;
    }

    public Advices(String advice) {
        this.advice = advice;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Advices() {

    }
}
