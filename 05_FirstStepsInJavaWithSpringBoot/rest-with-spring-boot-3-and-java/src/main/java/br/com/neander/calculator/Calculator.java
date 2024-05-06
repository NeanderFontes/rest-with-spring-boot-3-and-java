package br.com.neander.calculator;


import br.com.neander.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static br.com.neander.numberconverter.NumberConverter.convertToDouble;
import static br.com.neander.numberconverter.NumberConverter.isNumeric;

public class Calculator {

    /**
     * Método Sum para somar valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return
     */
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    /**
     * Método subtraction para retornar a subtração entre os valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return
     */
    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    /**
     * Método division para retornar a divisão entre os valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return
     */
    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    /**
     * Método multiplication para retorar multiplicação entre os valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return
     */
    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    /**
     * Método Mean para retornar média dos valores da soma valores de @param de uma request HTTP
     *
     * @param numberOne
     * @param numberTwo
     * @return
     */
    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    /**
     * Método squareRoot para retornar valor da raiz quadrada de @param de uma request HTTP
     *
     * @param number
     * @return
     */
    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
