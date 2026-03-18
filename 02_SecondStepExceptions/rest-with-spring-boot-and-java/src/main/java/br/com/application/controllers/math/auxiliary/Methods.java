package br.com.application.controllers.math.auxiliary;

import br.com.application.exception.UnsupportedMathOperationException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Methods {

    public String message() {
        return "Por favor, coloque um valor númerico";
    }

    public double convertToDouble(String stringNumber) throws IllegalArgumentException {
        if(stringNumber == null || stringNumber.isEmpty()) throw new UnsupportedMathOperationException(message());
        String number = stringNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public boolean isNumeric(String stringNumber) {
        if(stringNumber == null || stringNumber.isEmpty()) return false;
        String number = stringNumber.replace(",", ".");

        /* bem confuso né? mas essa regex (que é o que está de parametro para o método matches)
           serve para dizer que essa váriavel "number" só aceita números positivos e negativos antes
           da vírgula, e que só aceitam números, de 0 à 9, e esse "." serve de separador para dizer
           o que aceita depois da vírgula. Logo depois aparece o que aceita depois da vírgula, que seria
           números de 0 à 9, só que positivos, pois não usamos números negativos depois da vírgula.
        */

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
