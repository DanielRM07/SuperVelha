package org.openjfx.hellofx;

import java.awt.Panel;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javax.naming.*;
import java.io.File;
import java.util.Hashtable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class SecondaryController {

    int contTurno = 0;

    char simboloP1 = 'X', simboloP2 = 'O';

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    private void disableP2() {
        labelSaida.setStyle("-fx-background-color: #faa");
    }

    private void escolherCelula() {
        labelSaida.setTextFill(Paint.valueOf("BLACK"));
    }
    
    private void resultadoJogada(boolean player1) {
        if (Joguinho.verificarVitoria(jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)])) {
            //jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].resolvido = true;
            //jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].player1 = true;
            jogoGrande.riscarEsteJogo(coordJAX(joguinhoAtual), coordJAY(joguinhoAtual), player1);
        }
        if (Joguinho.verificarVelha(jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)])) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].resolvido = true;
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].velha = true;
        }
    }

    private void enablePainelJA(int jogoAtual, boolean onOff) {
        switch (jogoAtual) {
            case 1:
                quad00Panel.setDisable(!onOff);
                labelSaida.setText("quadrante superior direito selecionado!");
                break;
            case 2:
                quad10Panel.setDisable(!onOff);
                labelSaida.setText("quadrante superior do meio selecionado!");
                break;
            case 3:
                quad20Panel.setDisable(!onOff);
                labelSaida.setText("quadrante superior esquerdo selecionado!");
                break;
            case 4:
                quad01Panel.setDisable(!onOff);
                labelSaida.setText("quadrante central direito selecionado!");
                break;
            case 5:
                quad11Panel.setDisable(!onOff);
                labelSaida.setText("quadrante central do meio selecionado!");
                break;
            case 6:
                quad21Panel.setDisable(!onOff);
                labelSaida.setText("quadrante central esquerdo selecionado!");
                break;
            case 7:
                quad02Panel.setDisable(!onOff);
                labelSaida.setText("quadrante inferior direito selecionado!");
                break;
            case 8:
                quad12Panel.setDisable(!onOff);
                labelSaida.setText("quadrante inferior do meio selecionado!");
                break;
            case 9:
                quad22Panel.setDisable(!onOff);
                labelSaida.setText("quadrante inferior esquerdo selecionado!");
                break;
            default:
                labelSaida.setText("Erro ao desabilitar Quads");
                break;
        }
        
    }

    private void decisoesJogoPlayer(int JogoAtual) {
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[0][0] != 0) {
            buttomTLP1.setDisable(true);
            buttomTLP2.setDisable(true);
        } else {
            buttomTLP1.setDisable(false);
            buttomTLP2.setDisable(false);
            buttomTLP1.setText("[" + simboloP1 + "]");
            buttomTLP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[0][1] != 0) {
            buttomTMP1.setDisable(true);
            buttomTMP2.setDisable(true);
        } else {
            buttomTMP1.setDisable(false);
            buttomTMP2.setDisable(false);
            buttomTMP1.setText("[" + simboloP1 + "]");
            buttomTMP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[0][2] != 0) {
            buttomTRP1.setDisable(true);
            buttomTRP2.setDisable(true);
        } else {
            buttomTRP1.setDisable(false);
            buttomTRP2.setDisable(false);
            buttomTRP1.setText("[" + simboloP1 + "]");
            buttomTRP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[1][0] != 0) {
            buttomCLP1.setDisable(true);
            buttomCLP2.setDisable(true);
        } else {
            buttomCLP1.setDisable(false);
            buttomCLP2.setDisable(false);
            buttomCLP1.setText("[" + simboloP1 + "]");
            buttomCLP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[1][1] != 0) {
            buttomCMP1.setDisable(true);
            buttomCMP2.setDisable(true);
        } else {
            buttomCMP1.setDisable(false);
            buttomCMP2.setDisable(false);
            buttomCMP1.setText("[" + simboloP1 + "]");
            buttomCMP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[1][2] != 0) {
            buttomCRP1.setDisable(true);
            buttomCRP2.setDisable(true);
        } else {
            buttomCRP1.setDisable(false);
            buttomCRP2.setDisable(false);
            buttomCRP1.setText("[" + simboloP1 + "]");
            buttomCRP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[2][0] != 0) {
            buttomBLP1.setDisable(true);
            buttomBLP2.setDisable(true);
        } else {
            buttomBLP1.setDisable(false);
            buttomBLP2.setDisable(false);
            buttomBLP1.setText("[" + simboloP1 + "]");
            buttomBLP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[2][1] != 0) {
            buttomBMP1.setDisable(true);
            buttomBMP2.setDisable(true);
        } else {
            buttomBMP1.setDisable(false);
            buttomBMP2.setDisable(false);
            buttomBMP1.setText("[" + simboloP1 + "]");
            buttomBMP2.setText("[" + simboloP2 + "]");
        }
        if (jogosMenores[coordJAX(JogoAtual)][coordJAY(JogoAtual)].corpo[2][2] != 0) {
            buttomBRP1.setDisable(true);
            buttomBRP2.setDisable(true);
        } else {
            buttomBRP1.setDisable(false);
            buttomBRP2.setDisable(false);
            buttomBRP1.setText("[" + simboloP1 + "]");
            buttomBRP2.setText("[" + simboloP2 + "]");
        }
    }

    private void decisoesQuadPlayer() {
        if (jogosMenores[0][0].resolvido) {
            buttomTLP1.setDisable(true);
            buttomTLP2.setDisable(true);
        } else {
            buttomTLP1.setDisable(false);
            buttomTLP2.setDisable(false);
            buttomTLP1.setText("1\n[0,0]");
            buttomTLP2.setText("1\n[0,0]");
        }
        if (jogosMenores[0][1].resolvido) {
            buttomTMP1.setDisable(true);
            buttomTMP2.setDisable(true);
        } else {
            buttomTMP1.setDisable(false);
            buttomTMP2.setDisable(false);
            buttomTMP1.setText("2\n[0,1]");
            buttomTMP2.setText("2\n[0,1]");
        }
        if (jogosMenores[0][2].resolvido) {
            buttomTRP1.setDisable(true);
            buttomTRP2.setDisable(true);
        } else {
            buttomTRP1.setDisable(false);
            buttomTRP2.setDisable(false);
            buttomTRP1.setText("3\n[0,2]");
            buttomTRP2.setText("3\n[0,2]");
        }
        if (jogosMenores[1][0].resolvido) {
            buttomCLP1.setDisable(true);
            buttomCLP2.setDisable(true);
        } else {
            buttomCLP1.setDisable(false);
            buttomCLP2.setDisable(false);
            buttomCLP1.setText("4\n[1,0]");
            buttomCLP2.setText("4\n[1,0]");
        }
        if (jogosMenores[1][1].resolvido) {
            buttomCMP1.setDisable(true);
            buttomCMP2.setDisable(true);
        } else {
            buttomCMP1.setDisable(false);
            buttomCMP2.setDisable(false);
            buttomCMP1.setText("5\n[1,1]");
            buttomCMP2.setText("5\n[1,1]");
        }
        if (jogosMenores[1][2].resolvido) {
            buttomCRP1.setDisable(true);
            buttomCRP2.setDisable(true);
        } else {
            buttomCRP1.setDisable(false);
            buttomCRP2.setDisable(false);
            buttomCRP1.setText("6\n[1,2]");
            buttomCRP2.setText("6\n[1,2]");
        }
        if (jogosMenores[2][0].resolvido) {
            buttomBLP1.setDisable(true);
            buttomBLP2.setDisable(true);
        } else {
            buttomBLP1.setDisable(false);
            buttomBLP2.setDisable(false);
            buttomBLP1.setText("7\n[2,0]");
            buttomBLP2.setText("7\n[2,0]");
        }
        if (jogosMenores[2][1].resolvido) {
            buttomBMP1.setDisable(true);
            buttomBMP2.setDisable(true);
        } else {
            buttomBMP1.setDisable(false);
            buttomBMP2.setDisable(false);
            buttomBMP1.setText("8\n[2,1]");
            buttomBMP2.setText("8\n[2,1]");
        }
        if (jogosMenores[2][2].resolvido) {
            buttomBRP1.setDisable(true);
            buttomBRP2.setDisable(true);
        } else {
            buttomBRP1.setDisable(false);
            buttomBRP2.setDisable(false);
            buttomBRP1.setText("9\n[2,2]");
            buttomBRP2.setText("9\n[2,2]");
        }

    }

    private void agregadoTurnoQuad() {
        decisoesJogoPlayer(joguinhoAtual);
        enablePainelJA(joguinhoAtual, true);
        contTurno = -contTurno;
    }

    private void agregadoTurnoJogo() {
        switch (contTurno) {
            case -1:
                decisoesQuadPlayer();
                labelLog.setText(Joguinho.porEscrito(jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)]));
                jPaneP2.setDisable(false);
                jPaneP1.setDisable(true);
                enablePainelJA(joguinhoAtual, false);
                resultadoJogada(true);
                contTurno = 2;
                setPanels();
                break;
            case -2:
                decisoesQuadPlayer();
                labelLog.setText(Joguinho.porEscrito(jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)]));
                jPaneP1.setDisable(false);
                jPaneP2.setDisable(true);
                enablePainelJA(joguinhoAtual, false);
                resultadoJogada(true);
                contTurno = 1;
                setPanels();
                break;
        }
        
    }
    
    private void setPanels(Joguinho j00, Joguinho j01, Joguinho j02, Joguinho j10, Joguinho j11, Joguinho j12, Joguinho j20, Joguinho j21, Joguinho j22){
        quad00Panel.atualizarQuadrantes(j00);
        quad10Panel.atualizarQuadrantes(j01);
        quad20Panel.atualizarQuadrantes(j02);
        quad01Panel.atualizarQuadrantes(j10);
        quad11Panel.atualizarQuadrantes(j11);
        quad21Panel.atualizarQuadrantes(j12);
        quad02Panel.atualizarQuadrantes(j20);
        quad12Panel.atualizarQuadrantes(j21);
        quad22Panel.atualizarQuadrantes(j22);
    }
    private void setPanels(Joguinho jogoGrande){
        quad00Panel.atualizarQuadrantes(jogoGrande);
        quad10Panel.atualizarQuadrantes(jogoGrande);
        quad20Panel.atualizarQuadrantes(jogoGrande);
        quad01Panel.atualizarQuadrantes(jogoGrande);
        quad11Panel.atualizarQuadrantes(jogoGrande);
        quad21Panel.atualizarQuadrantes(jogoGrande);
        quad02Panel.atualizarQuadrantes(jogoGrande);
        quad12Panel.atualizarQuadrantes(jogoGrande);
        quad22Panel.atualizarQuadrantes(jogoGrande);
    }
    private void setPanels(){
        quad00Panel.atualizarQuadrantes(jogosMenores[0][0]);
        quad10Panel.atualizarQuadrantes(jogosMenores[0][1]);
        quad20Panel.atualizarQuadrantes(jogosMenores[0][2]);
        quad01Panel.atualizarQuadrantes(jogosMenores[1][0]);
        quad11Panel.atualizarQuadrantes(jogosMenores[1][1]);
        quad21Panel.atualizarQuadrantes(jogosMenores[1][2]);
        quad02Panel.atualizarQuadrantes(jogosMenores[2][0]);
        quad12Panel.atualizarQuadrantes(jogosMenores[2][1]);
        quad22Panel.atualizarQuadrantes(jogosMenores[2][2]);
    }

    @FXML
    private void jogar() {
        
        this.jPaneP1.setDisable(false);
        buttonStart.setDisable(true);
        /////////////////////////////////////
        contTurno = 1;        
        labelSaida.setText("Turno do Jogador" + contTurno + "!");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogosMenores[i][j] = new Joguinho();
            }
        }
        jogoGrande = new Joguinho();
        labelLog.setText(Joguinho.porEscrito(jogosMenores[0][0]));
        decisoesQuadPlayer();
        setPanels();
    }

    @FXML
    public void printValueOnLabelTRP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 3;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(0, 2, true);
            agregadoTurnoJogo();
        }
    }

    @FXML
    public void printValueOnLabelTRP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 3;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(0, 2, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelTMP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 2;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(0, 1, true);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelTMP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 2;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(0, 1, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelTLP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 1;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(0, 0, true);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelTLP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 1;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(0, 0, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelCRP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 6;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(1, 2, true);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelCRP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 6;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(1, 2, false);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelCMP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 5;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(1, 1, true);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelCMP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 5;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(1, 1, false);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelCLP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 4;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(1, 0, true);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelCLP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 4;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(1, 0, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelBRP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 9;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(2, 2, true);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelBRP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 9;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(2, 2, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelBMP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 8;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(2, 1, true);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelBMP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 8;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(2, 1, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private void printValueOnLabelBLP1() throws IOException {
        if (contTurno == 1) {
            joguinhoAtual = 7;
            agregadoTurnoQuad();
        } else if (contTurno == -1) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(2, 0, true);
            agregadoTurnoJogo();
        }
    }
    
    @FXML
    private void printValueOnLabelBLP2() throws IOException {
        if (contTurno == 2) {
            joguinhoAtual = 7;
            agregadoTurnoQuad();
        } else if (contTurno == -2) {
            jogosMenores[coordJAX(joguinhoAtual)][coordJAY(joguinhoAtual)].riscarEsteJogo(2, 0, false);
            agregadoTurnoJogo();
        }
    }

    @FXML
    private Label labelSaida;

    @FXML
    private Label labelLog;

    @FXML
    private Button secondaryButton;

    @FXML
    private Button buttonStart;

    @FXML
    private Pane jPaneP1;

    @FXML
    private Pane jPaneP2;

    @FXML
    private Button buttomTRP1;

    @FXML
    private Button buttomCRP1;

    @FXML
    private Button buttomBRP1;

    @FXML
    private Button buttomTMP1;

    @FXML
    private Button buttomCMP1;

    @FXML
    private Button buttomBMP1;

    @FXML
    private Button buttomTLP1;

    @FXML
    private Button buttomCLP1;

    @FXML
    private Button buttomBLP1;

    @FXML
    private Button buttomTRP2;

    @FXML
    private Button buttomCRP2;

    @FXML
    private Button buttomBRP2;

    @FXML
    private Button buttomTMP2;

    @FXML
    private Button buttomCMP2;

    @FXML
    private Button buttomBMP2;

    @FXML
    private Button buttomTLP2;

    @FXML
    private Button buttomCLP2;

    @FXML
    private Button buttomBLP2;
    
    @FXML
    private GridPane malhaJogos;

    @FXML
    private VelhaPane quad00Panel;

    @FXML
    private VelhaPane quad10Panel;

    @FXML
    private VelhaPane quad20Panel;

    @FXML
    private VelhaPane quad01Panel;

    @FXML
    private VelhaPane quad11Panel;

    @FXML
    private VelhaPane quad21Panel;

    @FXML
    private VelhaPane quad02Panel;

    @FXML
    private VelhaPane quad12Panel;

    @FXML
    private VelhaPane quad22Panel;

    Joguinho[][] jogosMenores = new Joguinho[3][3];
    Joguinho jogoGrande;
    int joguinhoAtual = 0;

    public static int coordJAX(int jA) {
        switch (jA) {
            case 1:
            case 2:
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 2;
            default:
                return 3;
        }
    }

    public static int coordJAY(int jA) {
        switch (jA) {
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                return 3;
        }
    }

}
