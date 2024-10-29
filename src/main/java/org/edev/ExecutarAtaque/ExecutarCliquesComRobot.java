package org.edev.ExecutarAtaque;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class ExecutarCliquesComRobot {
    public void AbrirWapp(int x, int y, int w, int h ){
        try{
            Robot bot = new Robot();
            bot.mouseMove(x+200, y+170);
            bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            try {
                // Pausa por 5000 milissegundos (5 segundos)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String reciver = "Amigo1"; //Defina o remetente
            for (char c : reciver.toCharArray()) {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                bot.keyPress(keyCode);
                bot.keyRelease(keyCode);
            }
            bot.keyPress(10);
            try {
                // Pausa por 5000 milissegundos (5 segundos)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int repetir = 10;
            String message = "Estou testando automacao, enviando esta mensagem 10X"; //Escreva a mensagem aqui
            int i = 0;
            while(i<repetir){
                for (char c : message.toCharArray()) {
                    int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                    bot.keyPress(keyCode);
                    bot.keyRelease(keyCode);
                }
                bot.keyPress(10);
                i+=1;
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
