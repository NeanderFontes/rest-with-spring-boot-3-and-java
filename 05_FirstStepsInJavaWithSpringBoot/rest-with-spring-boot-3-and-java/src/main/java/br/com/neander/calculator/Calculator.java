package br.com.neander.calculator;

import org.springframework.web.bind.annotation.PathVariable;

public class Calculator {

    private String numberOne, numberTwo;

    public Calculator(String numberOne, String numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
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

    public String getNumberOne() {
        return numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }
}
