
package com.grawkosci;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void startNewGame(View View) {
        Intent intent = new Intent(this, ChoosePlayers.class);
        startActivity(intent);
    }

    public void about(View View) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("O grze");
        builder.setMessage("U�ywa si� 5 klasycznych ko�ci do gry o kszta�cie "
                + "sze�cianu z liczb� punkt�w 1, 2, 3, 4, 5 i 6 na "
                + "poszczeg�lnych �ciankach.\nW ka�dej kolejce gracz ma do "
                + "dyspozycji 3 rzuty kostkami. Pierwszy rzut odbywa si� zawsze "
                + "wszystkimi 5 kostkami.\nPrzy nast�pnych dw�ch nieobowi�zkowych"
                + " rzutach gracz mo�e wybra� ze wszystkich kostki zatrzymane a "
                + "niezatrzymanymi wykonuje rzut.\n" + "Celem rzut�w w kolejce "
                + "jest uzyskanie odpowiedniej kombinacji. Po wykonaniu rzut�w "
                + "uk�ad oczek uzyskany na kostkach musi zosta� zapisany przez "
                + "gracza w tabeli punktacji do jednej z kategorii.\nZa wybran� "
                + "kategori� otrzymuje si� odpowiedni� liczb� punkt�w. Raz "
                + "wybrana kategoria nie mo�e zosta� u�yta ponownie.\nKoniec gry "
                + "nast�puje z chwil� u�ycia ostatniej kategorii w tabelce. "
                + "Wygrywa gracz z najwi�ksz� liczb� punkt�w.");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.show();
    }

    public void exit(View View) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
 
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else if (config.orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
