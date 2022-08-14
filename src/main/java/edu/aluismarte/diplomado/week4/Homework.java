package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Operation;

import java.io.File;
import java.io.PrintWriter;

/**
 * Reescribir este código en piezas testeables y hacer los test cubriendo multiples escenarios
 * <p>
 * En vez de escribir directo a disco el archivo debería recibir donde escribirlo (el file directamente)
 * El cálculo no debe ser en la function, es una lógica separada
 *
 * @author aluis on 4/3/2022.
 * @implSpec La función existente debe quedarse ahi, pues la nueva se presume tendrá más parámetros
 */
public class Homework {

    // TODO crear una funcion nueva sin borrar la vieja

    /**public static void calculateAndSave(Operation operation, int a, int b) throws Exception {
        Double result = switch (operation) {
            case SUM -> (double) (a + b);
            case MULT -> (double) a * b;
            case DIV -> (double) a / b;
            default -> null;
        };
        if (result == null) {
            throw new operationNullException();
        }
        File file = new File("filename.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Result is: " + result);
        }
    }

    public static class operationNullException extends RuntimeException {

        public operationNullException() {
            super("No operation");
        }
    }**/

    public void calculateAndSave(Operation operation, Double a, Double b, File file) throws Exception {
        Double result = switch (operation) {
            case SUM -> Suma(a,b);
            case MULT -> producto(a,b);
            case DIV -> Div(a,b);
            default -> throw new Exception("No operation");
        };
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Result is: " + result);
        }
    }

    private static Double Suma (Double num1, Double num2){
        Double value = num1+num2;
        return value;
    }

    private static Double producto (Double num1, Double num2){
        return num1 * num2;
    }

    private static Double Div (Double num1, Double num2){
        return num1/num2;
    }

}
