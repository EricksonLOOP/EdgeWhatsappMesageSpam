package org.edev.AbrirWeb;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.source.tree.BreakTree;
import org.edev.ExecutarAtaque.ExecutarCliquesComRobot;

public class VerificarSeAJanelaAbriu {

    public boolean VerificarJanela(){
        final User32 user32 = User32.INSTANCE;
        final ExecutarCliquesComRobot clique = new ExecutarCliquesComRobot();
        user32.EnumWindows(new WinUser.WNDENUMPROC() {
            @Override
            public boolean callback(WinDef.HWND hWnd, Pointer arg1) {
                char[] windowText = new char[512];
                user32.GetWindowText(hWnd, windowText, 512);
                String wText = Native.toString(windowText);
                WinDef.HWND hwnd = user32.FindWindow(null,  "WhatsApp - Pessoal — Microsoft\u200B Edge");
                if (!wText.isEmpty() & hwnd !=null) {
                    WinDef.RECT rect = new WinDef.RECT();
                    user32.GetWindowRect(hwnd, rect);
                    int windowX = rect.left;   // Coordenada X da janela
                    int windowY = rect.top;    // Coordenada Y da janela
                    int windowWidth = rect.right - rect.left;  // Largura da janela
                    int windowHeight = rect.bottom - rect.top;
                    System.out.println(windowX+ " " + " " + windowY);// Altura da janela
                    clique.AbrirWapp(windowX,windowY,windowWidth, windowHeight);
                    return false;
                }
                return false;

            }
        }, null);
        return false;
    }
}
