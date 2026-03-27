package br.com.application.controllers.math;

import br.com.application.controllers.math.auxiliary.Methods;
import br.com.application.controllers.math.operations.Operations;
import br.com.application.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController implements Operations {

    private final Methods methods;

    public MathController(Methods methods) {
        this.methods = methods;
    }



    // http://localhost/8080/math/sum/10/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!methods.isNumeric(numberOne) || !methods.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(methods.message());
        return Operations.sum(methods.convertToDouble(numberOne) , methods.convertToDouble(numberTwo));
    }

    // http://localhost/8080/math/subtraction/10/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!methods.isNumeric(numberOne) || !methods.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(methods.message());
        return Operations.sub(methods.convertToDouble(numberOne) , methods.convertToDouble(numberTwo));
    }

    // http://localhost/8080/math/multiplication/10/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!methods.isNumeric(numberOne) || !methods.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(methods.message());
        return Operations.mult(methods.convertToDouble(numberOne) , methods.convertToDouble(numberTwo));
    }

    // http://localhost/8080/math/division/10/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!methods.isNumeric(numberOne) || !methods.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(methods.message());
        return Operations.div(methods.convertToDouble(numberOne) , methods.convertToDouble(numberTwo));
    }

    // http://localhost/8080/math/mean/10/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!methods.isNumeric(numberOne) || !methods.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException(methods.message());
        return Operations.mean(methods.convertToDouble(numberOne) , methods.convertToDouble(numberTwo));
    }


    // http://localhost/8080/math/sqrt/144
    @RequestMapping("/sqrt/{number}")
    public double sqrt(
                        @PathVariable(value = "number") String number
    ) throws Exception {
        if (!methods.isNumeric(number)) throw new UnsupportedMathOperationException(methods.message());
        return Operations.sqrt(methods.convertToDouble(number));
    }
}
