/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.hellofx;

/**
 *
 * @author Daniel
 */
public class Joguinho {

    boolean resolvido, velha, player1, player2;
    public int[][] corpo = new int[3][3];

    public static int[][] teste1A = {
        {2, 0, 0},
        {2, 2, 1},
        {1, 1, 2}
    };
    /**
     * [O][ ][ ] [O][O][X] [X][X][O]
     */

    public static int[][] teste1B = {
        {2, 0, 0},
        {2, 0, 1},
        {1, 1, 2}
    };
    /**
     * [O][ ][ ] [O][ ][X] [X][X][O]
     */

    public static int[][] teste2A = {
        {2, 1, 2},
        {2, 1, 1},
        {1, 2, 2}
    };
    /**
     * [O][ ][ ] [O][ ][X] [X][X][O]
     */

    public static int[][] teste3A = {
        {0, 1, 1},
        {1, 2, 2},
        {1, 2, 2}
    };

    /**
     * [ ][X][X] [X][O][O] [X][O][O]
     */

    /**
     * @param jogo
     * @return
     */
    public static boolean verificarVitoria(Joguinho jogo) {
        if ((jogo.corpo[0][0] == jogo.corpo[0][1] && jogo.corpo[0][0] == jogo.corpo[0][2] && jogo.corpo[0][0] != 0)
                || (jogo.corpo[0][0] == jogo.corpo[1][0] && jogo.corpo[0][0] == jogo.corpo[2][0] && jogo.corpo[0][0] != 0)
                || (jogo.corpo[1][1] == jogo.corpo[0][1] && jogo.corpo[1][1] == jogo.corpo[2][1] && jogo.corpo[1][1] != 0)
                || (jogo.corpo[1][1] == jogo.corpo[1][0] && jogo.corpo[1][1] == jogo.corpo[1][2] && jogo.corpo[1][1] != 0)
                || (jogo.corpo[2][2] == jogo.corpo[0][2] && jogo.corpo[2][2] == jogo.corpo[1][2] && jogo.corpo[2][2] != 0)
                || (jogo.corpo[2][2] == jogo.corpo[2][0] && jogo.corpo[2][2] == jogo.corpo[2][1] && jogo.corpo[2][2] != 0)
                || (jogo.corpo[1][1] == jogo.corpo[0][0] && jogo.corpo[0][0] == jogo.corpo[2][2] && jogo.corpo[1][1] != 0)
                || (jogo.corpo[1][1] == jogo.corpo[2][0] && jogo.corpo[1][1] == jogo.corpo[0][2] && jogo.corpo[1][1] != 0)) {
            
            return true;
        }
        return false;
    }

    public static boolean verificarVelha(Joguinho jogo) {
        boolean velha = true;
        if (verificarVitoria(jogo)) {
            jogo.velha=false;
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (jogo.corpo[i][j] == 0) {
                    jogo.velha=false;
                    return false;                    
                }
            }
        }
        jogo.velha = true;
        return velha;
    }

    public int riscarEsteJogo(int posX, int posY, boolean player1) {
        if (corpo[posX][posY] == 0) {
            if (player1) {
                corpo[posX][posY] = 1;
            } else {
                corpo[posX][posY] = 2;
            }
            if(verificarVitoria(this)){
                this.resolvido = true;
                if (player1) {
                    this.player1 = true;
                    this.player2 = false;
                    this.velha = false;
                } else {
                    this.player2 = true;
                    this.player1 = false;
                    this.velha = false;
                }
            }else{
                verificarVelha(this);
            }
        }
        return -1;
        /**
         * -1 celula ocupada 0 sucesso com vitória 1 sucesso sem velha 2 sucesso
         */
    }

    public static String porEscrito(Joguinho jogo) {
        String saida = "";
        for (int i = 0; i < 3; i++) {
            saida += "+-+-+-+\n|";
            for (int j = 0; j < 3; j++) {
                switch (jogo.corpo[i][j]) {
                    case 1:
                        saida += "X|";
                        break;
                    case 2:
                        saida += "O|";
                        break;
                    default:
                        saida += " |";
                        break;
                }
            }
            saida += "\n";
        }
        saida += "+-+-+-+\n|";
        return saida;
    }

    Joguinho() {
        this.velha = false;
        this.player1 = false;
        this.player2 = false;
        this.resolvido = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                corpo[i][j] = 0;
            }
        }
    }
}
