package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Labirinto {
    private char parede =  'X';
    private char caminho_aberto =  ' ';
    private char saida =  'D';
    private char caminho_solucao =  '#';
    private char[][] labirinto  =  new char[8][8] ;


    public Labirinto(){

    }



    public void criaLabirinto (String arquivo){
        try{
            FileReader fr = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(fr);

            String linha;
            int row = 0;

            while ((linha = br.readLine()) !=null && row <8){

                for (int col = 0; col<8; col++){
                    labirinto[row][col] = linha.charAt(col);
                }
                row++;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }


    }

    public boolean percorreLabirinto(){
        return resolverLabirinto(0, 0);


    }


    public void imprimeLabirinto() {
        for (int i = 0; i < 8; i++) {          // percorre as linhas (0 até 7)
            for (int j = 0; j < 8; j++) {      // percorre as colunas (0 até 7)
                System.out.print(labirinto[i][j]); // imprime caractere sem pular linha
            }
            System.out.println(); // depois que terminar a linha, pula para a próxima
        }
    }


        private boolean resolverLabirinto(int x, int y){

            if (x < 0 || y < 0 || x >= 8 || y >= 8) {
                return false;
            }

            // verifica se é parede ou já foi marcada como caminho da solução
            if (labirinto[x][y] == parede || labirinto[x][y] == caminho_solucao) {
                return false;
            }

            // verifica se é a saída
            if (labirinto[x][y] == saida) {
                return true;
            }

            // marca a posição atual como parte do caminho da solução
            labirinto[x][y] = caminho_solucao;

            // tenta percorrer as quatro direções: cima, baixo, esquerda, direita
            if (resolverLabirinto(x - 1, y) || // cima
                    resolverLabirinto(x + 1, y) || // baixo
                    resolverLabirinto(x, y - 1) || // esquerda
                    resolverLabirinto(x, y + 1)) { // direita
                return true; // se qualquer direção encontrar a saída, retorna true
            }

            // se nenhuma direção funcionar, desfaz a marcação (backtracking)
            labirinto[x][y] = caminho_aberto;
            return false; // retorna false pois não há saída por esse caminho
        }

    }





































