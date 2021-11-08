package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BmiCalculator4Test {
    
    private static final String UNDERVEKT_STRING = "undervekt";
    private static final String NORMALVEKT_STRING = "normalvekt";
    
    private BmiCalculator4 bmiCalc;
    
    @BeforeEach
    public void setup() {
        bmiCalc = new BmiCalculator4(); //Ikke n�dv. hver gang, men ...
    }

    @Test
    public void bmiPaaAttenKommaFireSkalVaereUndervekt() {
        assertEquals(UNDERVEKT_STRING, bmiCalc.beregnVektklasse(18.4));
    }

    @Test
    public void bmiPaaAttenKommaFemSkalVaereNormalvekt() {
        assertEquals(NORMALVEKT_STRING, bmiCalc.beregnVektklasse(18.5));
    }
    
    //+ mange flere tester p� denne metoden
    
    @Test
    public void avrundingAvKomma45SkalVaereKomma5() {
        assertEquals(20.5, bmiCalc.rundAvTilEnDesimal(20.45), Double.MIN_VALUE);
    }

    @Test
    public void avrundingAvKomma44SkalVaereKomma4() {
        assertEquals(20.4, bmiCalc.rundAvTilEnDesimal(20.44), Double.MIN_VALUE);
    }

    //+ flere tester p� denne metoden
    
    /* 
     * osv ... på de andre metodene:
     * 
     *      double beregnBmi(double hoydeMeter, double vektKg)
     *      boolean gyldigHoydeMeter(double hoydeMeter)
     *      boolean gyldigVektKg(double vektKg)
     */
    
}
