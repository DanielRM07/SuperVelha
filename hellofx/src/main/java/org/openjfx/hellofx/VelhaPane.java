/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.hellofx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Daniel
 */
public class VelhaPane extends Pane{
    
    private Quadrante[] quads = new Quadrante[9];
    public final Font font = Font.loadFont("file:src/main/resources/fonts/tt_octosquares/TT Octosquares Trial Bold.ttf", 26);
    
    public void adicionarQuadrante(Quadrante quad, Joguinho jogo){
        if(this.quads[8] == null){
            Text simbolo = new Text();
            int posRelativaQuad = this.getChildren().size()+1;
            int value = jogo.corpo[SecondaryController.coordJAX(posRelativaQuad)][SecondaryController.coordJAY(posRelativaQuad)];
            simbolo.setText(value+"");
            simbolo.setFont(font);
            simbolo.setFill(Color.BLACK);
            this.quads[posRelativaQuad-1]=quad;
            quad.getChildren().add(simbolo);
            this.getChildren().add(quad);
        }
    }
    
    public void atualizarQuadrantes(Joguinho jogo){
        this.getChildren().removeAll();
        Text simbolo = new Text();        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Quadrante quad = new Quadrante();
                quad.setTranslateX(j*40);
                quad.setTranslateY(i*40);                
                String value = Integer.toString(jogo.corpo[i][j]);
                switch(value){
                    case "1":
                        value = "X";
                        break;
                    case "2":
                        value = "O";
                        break;
                    default:
                        value = " ";
                        break;
                }
                simbolo.setText(value+"");
                simbolo.setFont(font);
                quad.getChildren().add(simbolo);
                this.quads[i*3+j] = quad;
                simbolo = new Text();                
            }
        }
        for (int i = 0; i < 9; i++) {
            this.getChildren().add(quads[i]);
        }
    }
}
