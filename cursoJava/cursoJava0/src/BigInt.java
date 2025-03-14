import java.math.BigInteger;

//Introducción a la clase Math
public class BigInt {
    public static void main(String[] args){
        BigInteger base = BigInteger.valueOf(24);
        int exponente = 321;
        BigInteger potencia = base.pow(exponente);
        System.out.println(potencia);
    }
}
