package org.mvpigs.dni;

public class DNImain {
    public static void main(String[] args) {
        DNI dni;
        String[] casosTest = { // casos DNI PASS
            "78484464T","72376173A","01817200Q","95882054E","63587725Q",
            "26861694V","21616083Q","26868974Y","40135330P","89044648X",
            "80117501Z","34168723S","76857238R","66714505S","66499420A",
            "43182655V",
            // casos NIE PASS
            "X1234567L", "Y1234567X", "Z1234567R",
            // casos NIE FAIL
            "J1234567T", "H1234567T", "R1234567T",
            "X12345678X", "X1234T", "X1234567I"
            };
   
        for(String caso : casosTest){
            dni = new DNI(caso);
            if (dni.comprobarDNI()) {
                System.out.println("El caso " + caso + " es valido");
            } else {
                System.out.println("El caso " + caso + " NO es valido");
            }
        }
    }
}