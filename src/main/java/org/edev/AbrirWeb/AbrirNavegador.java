package org.edev.AbrirWeb;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.io.IOException;

public class AbrirNavegador {
    public void OpenBrowser() {
        try {
            String url = "https://web.whatsapp.com";
            // Abre o Microsoft Edge com a URL
            String command = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe --new-window " + url;
            Runtime.getRuntime().exec(command);
            Thread.sleep(7000);
         VerificarSeAJanelaAbriu verificarSeAJanelaAbriu = new VerificarSeAJanelaAbriu();
         verificarSeAJanelaAbriu.VerificarJanela();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
