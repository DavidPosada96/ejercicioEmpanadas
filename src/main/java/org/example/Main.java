package org.example;

import clases.Cliente;
import clases.Empada;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empada empada = new Empada("Empanada de papa y carne","papa, carne",1200,5000);
        Cliente cliente = new Cliente();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        int opcion=100;
        Scanner lea= new Scanner(System.in);
        System.out.println("***MENU***");
        System.out.println("1. Agregar Empanadas");
        System.out.println("2. Ver la Empanada");
        System.out.println("3. Editar precio de la empanada");
        System.out.println("5. Salir");



        while (opcion!=5){

            System.out.println("Apreciado usuario digite una opcion: ");

            opcion=lea.nextInt();

            if(opcion==1){
                System.out.println("Ingrese su saldo disponible: ");
                cliente.setSaldoDisponible(lea.nextInt());

                if(cliente.getSaldoDisponible()>=5000){
                    System.out.println("Nombre de la empanada: "+empada.getNombre());
                    System.out.println("El ingrediente de la empanada es: "+empada.getIngrediente());
                    System.out.println("Cantidad de empanadas deseadas: ");
                    empada.setCantidad(lea.nextInt());

                    if(empada.calcularVenta()>cliente.getSaldoDisponible()){
                        System.out.println("no tienes saldo suficiente: ");
                        System.out.println("ingrese una cantidad menor");

                    }else {
                        cliente.setSaldoDisponible(cliente.getSaldoDisponible()- empada.calcularVenta());
                        System.out.println("gracias por tu compra");
                        System.out.println("su nuevo saldo es: "+cliente.getSaldoDisponible());
                    }


                }else {
                    System.out.println("No tenes plata ");
                    break;
                }

            }else if(opcion==2){

                System.out.println("*** Empanadas el machetico");
                System.out.println("Regimen comun");
                System.out.println(dtf.format(LocalDateTime.now()));

                System.out.println("la empanada que compro: "+empada.getIngrediente());
                System.out.println("el valor de la empanada: "+empada.getPrecioVenta());
                System.out.println("la cantidad de empanadas que compro: "+empada.getCantidad());
                System.out.println("el valor total de las empanadas es: "+empada.calcularVenta());

            }else if(opcion==3){

            }else if(opcion==5){

            }else{

            }

        }




    }
}