package edu.aluismarte.diplomado.week3;

/**
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week3 {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = FIZZ + BUZZ;

    /**
     * Un número es Fizz cuando es divisible entre 5
     * Un número es Buzz cuando es divisible entre 3
     * Un número es FizzBuzz cuando es divisible entre 3 y 5 al mismo tiempo
     * Si no cumple con ninguna condición anterior se retorna el número
     *
     * @param number número a comprobar para saber si es Fizz, Buzz o FizzBuzz
     * @return Un string que es igual a Fizz, Buzz o FizzBuzz
     */
    public static String fizzbuzz(Integer number) {
        if (number == null) {
            return "No es Posible";
        }else if (number % 3 == 0 && number % 5 == 0)
        {return "FizzBuzz";
        }else if (number % 3 == 0)
        {return "Buzz";
        }else if (number % 5 == 0)
        {return "Fizz";
        }else return number + "";
    }
}
