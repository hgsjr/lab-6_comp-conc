package entities;

import java.util.Random;

public class Vetor {

    //atributos da classe entities.Vetor
    private int [] vetor;
    private int tamanho;

    public Vetor(int tamanho) { //construtor da classe

        this.tamanho = tamanho;
        this.vetor = new int [tamanho];
        Random rand = new Random(); //instancia objeto to tipo Random que preencherá os vetores com inteiros aleatórios
        for(int i = 0; i < tamanho; i++) {

            this.vetor[i] = rand.nextInt(101); //preenche o vetor com números aleatórios

        }

    }

    public Vetor(int tamanho, int i) { //overload do construtor (será usado para preencher o vetor c com zeros no início)

        this.tamanho = tamanho;
        this.vetor = new int [tamanho];
        for(int j = 0; j < tamanho; j++) {

            this.vetor[j] = i;

        }

    }

    //abaixo os métodos que foram pedidos para serem implementados também:

    public int getTamanho() {
        return this.tamanho;
    }

    public int getElemento(int posicao) {
        return this.vetor[posicao];
    }

    public void imprimeVetor() {

        System.out.print("[");
        for(int i = 0; i < this.tamanho; i++) {

            System.out.printf("%d ", this.vetor[i]);

        }
        System.out.println("\b]");

    }

    public void setElemento(int elemento, int posicao) {
        this.vetor[posicao] = elemento;
    }

}
