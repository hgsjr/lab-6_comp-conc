package entities;

public class Somador implements Runnable {

    //atributos da classe Somador
    Vetor a, b; //vetores que serão somados
    Vetor c; //vetor que armazenará os resultados
    int id; //identificador da thread
    int nthreads; //armazena o número de threads sendo utilizada para saber quais elementos esta thread irá calcular

    public Somador(Vetor a, Vetor b, Vetor c, int id, int nthreads) { //construtor da thread

        this.a = a;
        this.b = b;
        this.c = c;
        this.id = id;
        this.nthreads = nthreads;

    }

    public void run() { //método main da thread

        for(int i = this.id; i < this.c.getTamanho(); i += this.nthreads) {

            int resultado = this.a.getElemento(i) + this.b.getElemento(i);
            this.c.setElemento(resultado, i);

        }

    }

}
