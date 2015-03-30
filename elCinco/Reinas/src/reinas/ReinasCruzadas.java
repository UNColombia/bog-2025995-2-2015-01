/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jose, Oscar, Jorge
 */
public class ReinasCruzadas {
    public static final int n = 1000;
//    private static ArrayList<Reina> tablero;
//    private static int conflictos;
    ReinasCruzadas(){
        inicializarTablero();
    }
    
    public static ArrayList<Reina> inicializarTablero(){
        Reina reina;
        Random r = new Random();
        ArrayList<Reina> tablero = new ArrayList<>();
        int x;
        int y;
        while(tablero.size() < n) {
            x = r.nextInt(n);
            y = r.nextInt(n);
            reina = new Reina(x,y);
            if (!tablero.contains(reina))
                tablero.add(reina);
        }
        return tablero;
    }
    
    public static ArrayList<Object> contarConflictos(ArrayList<Reina> tablero){
        int j=1;
        int cruces = 0;
        Reina siguiente;
        
        tablero.stream().forEach((r) -> {
            r.setConflictos(0);
        });
        for(Reina r: tablero){
            for(int i=j;i<tablero.size();i++){
                siguiente = tablero.get(i);
                if(r.getX() == siguiente.getX()){
                    r.setConflictos(r.getConflictos()+1);
                    siguiente.setConflictos(siguiente.getConflictos()+1);
                    cruces++;
                }
                if(r.getY() == siguiente.getY()){
                    r.setConflictos(r.getConflictos()+1);
                    siguiente.setConflictos(siguiente.getConflictos()+1);
                    cruces++;
                }
                if(Math.abs(r.getX()- siguiente.getX()) == Math.abs(r.getY()- siguiente.getY())){
                    r.setConflictos(r.getConflictos()+1);
                    siguiente.setConflictos(siguiente.getConflictos()+1);
                    cruces++;
                }
            }
            j++;
        }
        ArrayList<Object> valores = new ArrayList<>();
        valores.add(tablero);
        valores.add(cruces);
        return valores;
    }
    
    public static Reina reinaConMasConflictos(ArrayList<Reina> tablero){
        Reina mayor;
        mayor = tablero.get(0);
        for (int i=1;i<tablero.size();i++){
            if(mayor.getConflictos() < tablero.get(i).getConflictos()){
                mayor = tablero.get(i);
            }
        }
        
        return mayor;
    }
    
    public static ArrayList<Object> moverReina(ArrayList<Reina> tablero, int conflictos){
        int x;
        int y;
        ArrayList<Object> contar;
        ArrayList<Object> resultado = new ArrayList<>();
        int conflictosDespuesMover;
        ArrayList<Reina> nuevoTablero = tablero;
        Reina reinaAMover = reinaConMasConflictos(nuevoTablero);
        boolean flag = true;
        while(flag){
            Random r = new Random();
            x = r.nextInt(n);
            y = r.nextInt(n);
            
            if(!nuevoTablero.contains(new Reina(x,y))){
                nuevoTablero.remove(reinaAMover);
                reinaAMover.setX(x);
                reinaAMover.setY(y);
                nuevoTablero.add(reinaAMover);
                contar = contarConflictos(nuevoTablero);
                conflictosDespuesMover = (int)contar.get(1);
                if(conflictosDespuesMover <= conflictos){
                    resultado.add(nuevoTablero);
                    resultado.add(conflictosDespuesMover);
                    return resultado;
                }else{
                    nuevoTablero = tablero;
                }
            }
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        ArrayList<Reina> tablero = inicializarTablero();
        ArrayList<Object> confl = contarConflictos(tablero);
        tablero = (ArrayList<Reina>)confl.get(0);
        int conflictos = (int)confl.get(1);
        int i=0;
        //imprimirTablero(tablero,"inicial");

        while(conflictos>0){
            ArrayList<Object> mover = moverReina(tablero, conflictos);
            tablero = (ArrayList<Reina>)mover.get(0);
            conflictos = (int)mover.get(1);
            i++;
        }
        
        //imprimirTablero(tablero,"final");

        System.out.println("Ordenado en " + i + " pasos");
    }


    public static void imprimirTablero(ArrayList<Reina> tablero, String momento){
        System.out.println("\nPosiciones en el tablero "+momento);

        boolean isBig;

        if (n>=50){
            System.out.println("es grande");
            isBig=true;
        }

        int [][] matrix = new int[n][n];

        tablero.stream().forEach((r) -> {
            if (isBig){
                System.out.println("Fila\tColumna");
                System.out.println(r.getX() +"\t"+ r.getY());

            }
            else{
                matrix [r.getX()][r.getY()]=1;
            }
        });

        if (!isBig){
            for (int i=0; i<matrix.length;i++){
                for (int j=0; j<matrix.length;j++){
                    System.out.print(matrix[i][j]);
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }



    }
    
}
