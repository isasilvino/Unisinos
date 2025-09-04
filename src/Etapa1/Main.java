package Etapa1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Labirinto lab = new Labirinto();

        lab.criaLabirinto("labirinto.txt");
        lab.imprimeLabirinto();

        if (lab.percorreLabirinto()) {
            System.out.println("Labirinto resolvido!");
        } else {
            System.out.println("Não foi possível encontrar a saída.");
        }

        // imprime o labirinto mostrando o caminho
        lab.imprimeLabirinto();

    }
}