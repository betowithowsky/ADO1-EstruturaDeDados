package listacarros_ado_edd.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import listacarros_ado_edd.model.Carro;

/**
 *
 * @author Roberto.Jwsilva
 */
public class Menu {

    static Scanner input = new Scanner(System.in);

    static ListaSimples listaCarros = new ListaSimples();

    public static void main(String[] args) {

        do {

            switch (menuPrincipal()) {

                case 0:
                    System.exit(0);
                    break;
                case 1:
                    inserirCarro();
                    break;
                case 2:
                    buscarCarro();
                    break;
                case 3:
                    ImprimiLista();
                    break;
                case 4:
                    removeCarro();
                    break;
                case 5:
                    removeTodos();
                    break;
            }
        } while (true);
    }

    public static int menuPrincipal() {

        System.out.println("1- Inserir carro\n"
                + "2- Pesquisar carro pelo modelo\n"
                + "3- Listar carros\n"
                + "4- Remover carro pelo modelo\n"
                + "5- Remover todos");

        return input.nextInt();

    }

    public static void inserirCarro() {
        Carro car = new Carro();
        System.out.print("Entre com modelo: ");
        car.setModelo(input.next().toLowerCase());
        System.out.print("Entre com marca: ");
        car.setMarca(input.next().toLowerCase());
        System.out.print("Entre com o ano: ");
        car.setAno(input.nextInt());

        System.out.println("Inserir no inicio ou final da lista? \n Digite '1' para inicio ou '2' para final.");

        switch (input.nextInt()) {
            case 1:
                listaCarros.inserirPrimeiro(car);
                break;
            case 2:
                listaCarros.inserirUltimo(car);
                break;
            default:
                System.out.println("valor invalido");
                break;
        }
    }
    
    public static void buscarCarro(){
        System.out.print("Informe modelo do carro: ");
        System.out.println(listaCarros.pesquisarNo(input.next().toLowerCase()));
    }
    
    public static void ImprimiLista(){        
        String msg = listaCarros.imprimirLista();
        System.out.println(msg);
    }
    
    public static void removeCarro(){
        System.out.print("Informe modelo a ser removido: ");
        listaCarros.removerNo(input.next());
    }
    
    public static void removeTodos(){
        listaCarros.limpaLista();
    }
}
