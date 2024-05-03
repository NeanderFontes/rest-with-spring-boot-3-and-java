package br.com.neander.calculator;

import br.com.neander.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {

    /**
     * Método Sum para somar valores de @param de uma request HTTP
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Soma entre os valores de @param's
     * @throws Exception
     */
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    /**
     * Método Subtração para subtrair valores de @param de uma request HTTP
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Subtração entre os valores de @param's
     * @throws Exception
     */
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    /**
     * Método Divisão para dividir valores de @param de uma request HTTP
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Divisão entre os valores de @param's
     * @throws Exception
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
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }
    }

    /**
     * Método Multiplicação para multiplicar valores de @param de uma request HTTP
     * @RequestMapping é uma Anotação indicando o mapeamento da Request do tipo de verbo HTTP
     * @PathVariable é a Anotação utilizada para leitura e manipulação do parâmetro HTTP
     * @param numberOne
     * @param numberTwo
     * @return - Resultado da Multiplicação entre os valores de @param's
     * @throws Exception
     */
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!!!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }


    /**
     * Método para validar conversão String to Double
     *
     * @param strNumber - valor da variável a ser tratada
     * @return valores finais em Double
     */
    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        } else {
            // Validar dados fracionados em formatos BR(20,0) & US(20.0)
            String convertDoubleNumber = strNumber.replaceAll(",", ".");
            if (isNumeric(convertDoubleNumber)) {
                return Double.parseDouble(convertDoubleNumber);
            }
        }
        return 0D;
    }

    /**
     * Método para validar se o valor passado como parâmetro é numérico através de regex
     *
     * @param strNumber
     * @return
     */
    private boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        } else {
            String convertDoubleNumber = strNumber.replaceAll(",", ".");
            return convertDoubleNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
    }
}
