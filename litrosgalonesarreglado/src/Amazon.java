 import java.util.ArrayList;
 import java.util.List;

 public class Amazon {
     public static void main(String[] args) {
         List <Integer> numeros = List.of(2, 5, 4, 1, 3, 7, 8, 9, 6, 10);
         List <Integer> salida = new ArrayList<>();
         int objetivo = 8;
         int contadordenumeros = 0;

         for (int i = 0; i < numeros.size(); i++) {
             int numeroactual = numeros.get(i);

             if (numeroactual < objetivo) {
                 salida.add(0, numeroactual);
                 contadordenumeros = contadordenumeros + 1;

             } else if (numeroactual > objetivo) {
                 salida.add(numeroactual);
                 contadordenumeros = contadordenumeros + 1;

             } else {
                 salida.add(contadordenumeros, numeroactual);
             }
         }
         System.out.print(salida);
     }
 }