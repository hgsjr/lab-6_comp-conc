package application;

import entities.Vetor;
import entities.Somador;

import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in); //instancia objeto do tipo Scanner que lerá entradas do usuário

        int tamanho; //variável que armazenará o tamanho dos vetores

        while(true) { //while(true) apenas para facilitar na validação de entrada

            System.out.print("Digite o tamanho dos vetores de elementos aleatórios que serão somados: ");
            tamanho = sc.nextInt();

            if(tamanho <= 0) {

                System.out.println("Você digitou algo incoerente, por favor tente novamente.\n");

            } else {break;}

        }

        //instancia os objetos do tipo Vetor
        Vetor a = new Vetor(tamanho);
        Vetor b = new Vetor(tamanho);
        Vetor c = new Vetor(tamanho, 0);

        int nthreads; //variável que armazenará o número de threads

        while(true) { //novamente, while(true) apenas para facilitar na validação de entrada

            System.out.print("Digite o número de threads desejado: ");
            nthreads = sc.nextInt();

            if(nthreads > tamanho || nthreads <= 0) {

                System.out.println("Você digitou algo incoerente, por favor tente novamente.\n");

            } else {break;}

        }

        //imprime os vetores aleatórios gerados
        System.out.print("a: "); a.imprimeVetor();
        System.out.print("b: "); b.imprimeVetor();

        Thread [] threads = new Thread[nthreads]; //vetor de Threads instanciado

        //cria as threads da aplicação
        for(int i = 0; i < nthreads; i++) {

            threads[i] = new Thread(new Somador(a, b, c, i, nthreads));

        }

        //inicia as threads
        for(int i = 0; i < nthreads; i++) {

            threads[i].start();

        }

        //espera o término de todas as threads
        for(int i = 0; i < nthreads; i++) {

            try { threads[i].join(); } catch (InterruptedException e) { return; }

        }

        //imprime o vetor resultante e termina a execução da main
        System.out.print("c: "); c.imprimeVetor();

    }

}
