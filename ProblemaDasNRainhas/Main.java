public class Main {
    public static void main(String[] args) {
        int n = 8;
        resolverNRainhas(n);
    }

    public static void resolverNRainhas(int n){
        char[][] tabuleiro = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                tabuleiro[i][j] = '.';
            }
        }

        if (posicionaRainhas(tabuleiro, 0)) {
            imprimeTabuleiro(tabuleiro);
        } else {
            System.out.println("Nenhuma solução encontrada para N = " + n);
        }
    }

    public static boolean posicionaRainhas(char[][] tabuleiro, int linha){
        int n = tabuleiro.length;

        //Retorna verdadeiro se todas as rainhas foram posicionadas
        if (linha == n) {
            return true;
        }

        //Tenta colocar a rainha em todas as colunas da linha atual
        for (int coluna = 0; coluna < n; coluna++) {
            if (podeAdicionarRainha(tabuleiro, linha, coluna)) {
                tabuleiro[linha][coluna] = 'Q';

                //Tenta posicionar as próximas
                if (posicionaRainhas(tabuleiro, linha + 1)) {
                    return true;
                }

//                tabuleiro[linha][coluna] = '.';
            }
        }
        return false;
    }

    public static boolean podeAdicionarRainha(char[][] tabuleiro, int linha, int coluna){
        int n = tabuleiro.length;

        //Verifica a linha de cima
        for (int i = 0; i < linha; i++){
            if (tabuleiro[i][coluna] == 'Q'){
                return false;
            }
        }

        if (linha > 0) {
            //Verifica a diagonal principal (esquerda acima)
            for (int i = linha - 1; i >= 0; i--){
                for (int j = coluna - 1; j >= 0; j--){
                    if (tabuleiro[i][j] == 'Q'){
                        return false;
                    }
                    return true;
                }
            }

            //Verifica a diagonal secundária (direita acima)
            for (int i = linha - 1; i < n; i--){
                for (int j = coluna + 1; j >= 0; j++){
                    if (tabuleiro[i][j] == 'Q'){
                        return false;
                    }
                    return true;
                }
            }
        }

        return true;
    }

    // Imprime o tabuleiro com a solução
    private static void imprimeTabuleiro(char[][] tabuleiro) {
        for (char[] linha : tabuleiro) {
            for (char celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }
}

