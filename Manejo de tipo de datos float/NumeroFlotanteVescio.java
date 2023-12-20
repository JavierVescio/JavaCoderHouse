public class Main {
    public static void main(String[] args) {
        float numero = 2.9f;

        int parteEnteraNumero = (int)numero;
        float parteDecimalNumero = numero - (float)parteEnteraNumero;

        System.out.println("Número = " + numero);
        System.out.println("Parte entera = " + parteEnteraNumero);
        System.out.println("Parte decimal = " + parteDecimalNumero);
    }
}