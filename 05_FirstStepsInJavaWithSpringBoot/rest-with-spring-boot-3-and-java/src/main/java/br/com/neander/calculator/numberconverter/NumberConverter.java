package br.com.neander.calculator.numberconverter;

public class NumberConverter {

    /**
     * Método para validar conversão String to Double
     *
     * @param strNumber - valor da variável a ser tratada
     * @return valores finais em Double
     */
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        } else {
            // Validar dados fracionados em formatos BR(20,0) & US(20.0)
            String convertDoubleNumber = strNumber.replaceAll(",", ".");
            //convertDataDecimalValue(strNumber);
            if (isNumeric(strNumber)) {
                return Double.parseDouble(convertDoubleNumber);
                //return Double.parseDouble(strNumber);
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
    public static Boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        } else {
            String convertDoubleNumber = strNumber.replaceAll(",", ".");
            //convertDataDecimalValue(strNumber);
            return convertDoubleNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
            //return  strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
    }

    public static String convertDataDecimalValue(String dataDecimalValue) {
        dataDecimalValue = dataDecimalValue.replaceAll(",",".");
        return dataDecimalValue;
    }
}
