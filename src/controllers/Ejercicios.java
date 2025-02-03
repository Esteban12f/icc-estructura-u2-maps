package controllers;

import java.util.HashMap;
import java.util.Map;

public class Ejercicios {

    /**
     * Determina si dos cadenas de caracteres son anagramas.
     * Dos cadenas son anagramas si tienen los mismos caracteres en la misma
     * cantidad,
     * sin importar el orden.
     *
     * Ejemplo 1:
     * Input: str1 = "listen", str2 = "silent"
     * Output: true
     * Explicación: Ambas cadenas tienen los mismos caracteres con la misma
     * frecuencia.
     *
     * Ejemplo 2:
     * Input: str1 = "hello", str2 = "bello"
     * Output: false
     * Explicación: Las cadenas tienen diferentes caracteres.
     *
     * Ejemplo 3:
     * Input: str1 = "triangle", str2 = "integral"
     * Output: true
     * Explicación: Ambas cadenas tienen los mismos caracteres con la misma
     * frecuencia.
     */
    public boolean areAnagrams(String str1, String str2) {

        Map<Integer, Character> contChar = new HashMap<>();
        Map<Integer, Character> contChar2 = new HashMap<>();

        if (str1.equals(str2)){
            return true;
        }

        if (str1.length() != str2.length()){
            return false;
        }

        for (int i = 0; i < str1.toCharArray().length; i++){
            contChar.put(i + 1,str1.toCharArray()[i]);
            contChar2.put(i + 1,str2.toCharArray()[i]);
        }

        int cont = 0;
        for (Integer i = 0; i < str1.toCharArray().length; i++){
            boolean contains = contChar.containsValue(contChar2.get(i + 1));

            if (contains){
                cont ++;
            }
        }

        if (cont == str1.toCharArray().length){
            return true;
        }

        return false;
    }

    /*
     * Dado un array de números enteros y un objetivo, retorna los índices de dos
     * números para los que la suma de ambos sea igual al objetivo.
     *
     * Se asume que hay una sola solución
     *
     * Ejemplo A:
     * Input: nums = [9,2,3,6], objetivo = 5
     * Output: [1,2]
     * Explicación: nums[1] + nums[2] == 5, devolvemos [1, 2].
     *
     * Ejemplo B:
     * Input: nums = [9,2,3,6], objetivo = 10
     * Output: null
     */
    public int[] sumatoriaDeDos(int[] nums, int objetivo) {
        Map<Integer, int[]> resultMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                resultMap.put(j, new int[]{i, j});
            }
        }

        for (int i = 0; i < nums.length; i++){
            int[] parSuma = resultMap.get(i + 1);
            if (parSuma != null){
                int suma = nums[parSuma[0]] + nums[parSuma[1]];
                if (suma == objetivo){
                    return parSuma;
                }
            } 
        }

        return null;
    }

    public void printMenu(){
        System.out.println("---- Menu ----");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("0. Salir");
        System.out.println("Escoja una opcion: ");
    }
}
