import java.util.Scanner;

import controllers.Ejercicios;
import controllers.EmpleadoContoller;
import controllers.Mapa;

import models.Empleado;

public class App {
    public static void main(String[] args) throws Exception {

        // Ejecuta el ejemplo de uso de HashMap con ejemplos sencillos
        //runMapExamlpe();

        // Ejecuta el ejemplo de gestión de empleados usando HashMap
        //runEmpleadoExample();

        // Ejecuta los ejercicios de sumatoria y anagramas
        runEjerccios();
    }

    private static void runEmpleadoExample() {
        EmpleadoContoller empCtrl = new EmpleadoContoller();

        boolean result = empCtrl.addEmpleado(new Empleado(1, "Pablo", "Senior"));
        System.out.println("Ingreso: " + result);
        result = empCtrl.addEmpleado(new Empleado(1, "Pablo", "Senior"));
        empCtrl.addEmpleado(new Empleado(2, "Juan", "Senior"));
        empCtrl.addEmpleado(new Empleado(3, "Andres", "Senior"));
        System.out.println("Ingreso: " + result);
        empCtrl.displayEmpleados();
        empCtrl.displayEmpleadosSoloNombres();
        empCtrl.displayLLaves();
        empCtrl.displayEmpleadosSinEntry();
    }

    private static void runMapExamlpe() {
        new Mapa();
    }

    private static void runEjerccios() {
        Scanner leer = new Scanner(System.in);
        Ejercicios ejercicios = new Ejercicios();
        ejercicios.printMenu();
        int opcion = leer.nextInt();

        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un string: ");
                    leer.nextLine();
                    String str1 = leer.nextLine();
                    System.out.println("Ingrese otro string: ");
                    String str2 = leer.nextLine();
        
                    boolean result = ejercicios.areAnagrams(str1, str2);
                    if (result){
                        System.out.println("Are anagrams");
                    } else {
                        System.out.println("Are not anagrams");
                    }
                    break;
    
                case 2:
                    System.out.println("Ingrese el tamaño del areglo: ");
                    int arrayLenght = leer.nextInt();
        
                    int[] nums = new int[arrayLenght];
        
                    for (int i = 0; i < arrayLenght; i++){
                        System.out.println("Ingrese el numero en la posicion " + (i + 1) + ":");
                        nums[i] = leer.nextInt();
                    }
        
                    System.out.println("Ingrese el objetivo:");
                    int objetivo = leer.nextInt();
        
                    int[] resultArray = ejercicios.sumatoriaDeDos(nums, objetivo);
                    System.out.println(java.util.Arrays.toString(resultArray));
                    break;

                default:
                    System.out.println("Opcion no valida :/");
                    break;
            }
            ejercicios.printMenu();
            opcion = leer.nextInt();
        }

    }
}
