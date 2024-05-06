package br.com.neander.controllers;

import br.com.neander.calculator.Calculator;
import br.com.neander.exceptions.UnsupportedMathOperationException;
import br.com.neander.numberconverter.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.neander.numberconverter.NumberConverter.convertToDouble;
import static br.com.neander.numberconverter.NumberConverter.isNumeric;


@RestController
public class MathController {

    private Calculator calculatorOperator = new Calculator();

    /**
     * Método Sum para somar valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Soma entre os valores de @param's
     * @throws Exception
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     */
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return getCalculatorOperator().sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    /**
     * Método Subtração para subtrair valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Subtração entre os valores de @param's
     * @throws Exception
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     */
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return getCalculatorOperator().subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    /**
     * Método Divisão para dividir valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Divisão entre os valores de @param's
     * @throws Exception
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     */
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        } else {
            if (convertToDouble(numberTwo) == 0) {
                throw new UnsupportedMathOperationException("It's impossible to division with 0");
            }
            return getCalculatorOperator().division(convertToDouble(numberOne), convertToDouble(numberTwo));
        }
    }

    /**
     * Método Multiplicação para multiplicar valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Multiplicação entre os valores de @param's
     * @throws Exception
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     */
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return getCalculatorOperator().multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    /**
     * Método Média para obter média entre os valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Média entre os valores de @param's
     * @throws Exception
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     */
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return getCalculatorOperator().mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    /**
     * Método Raiz Quadrada para obter raíz quadrada entre os valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Raiz Quadrada entre os valores de @param's
     * @throws Exception
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     */
    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return getCalculatorOperator().squareRoot(convertToDouble(number));
    }

    public Calculator getCalculatorOperator() {
        return calculatorOperator;
    }
}
