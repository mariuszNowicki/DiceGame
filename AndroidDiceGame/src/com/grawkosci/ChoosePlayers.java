
package com.grawkosci;

import Controller.GameManager;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ChoosePlayers extends Activity {

    private Button startGameButton;

    private EditText playerName;

    public GameManager game = new GameManager();

    private Button addPlayer;

    public static final String KEY_ILE = "playersCount";

    public static final String KEY_P1 = "P1Name";

    public static final String KEY_P2 = "P2Name";

    public static final String KEY_P3 = "P3Name";

    public static final String KEY_P4 = "P4Name";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_choose_players);

        startGameButton = (Button)findViewById(R.id.startGame);
        startGameButton.setEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void addPlayer(View View) {
        playerName = (EditText)findViewById(R.id.playerName);
        if (!playerName.getText().toString().equals("")) {
            int counter = 0;
            for (int i = 0; i < game.scoreBoardList.size(); i++) {
                if (playerName.getText().toString().equals(game.scoreBoardList.get(i).player.getName()))
                    counter++;
            }
            if (counter == 0) {
                if (game.scoreBoardList.size() < 4) {
                    game.getPlayers(playerName.getText().toString(), 0,
                            game.scoreBoardList.size() + 1);
                    TableLayout tbl = (TableLayout)findViewById(R.id.tablePlayers);
                    TableRow newRow = new TableRow(this);
                    TextView name = new TextView(this);
                    name.setText(playerName.getText());
                    newRow.addView(name);
                    tbl.addView(newRow);
                    playerName.setText("");
                    if (game.scoreBoardList.size() > 1)
                        startGameButton.setEnabled(true);
                    if (game.scoreBoardList.size() == 4) {
                        addPlayer = (Button)findViewById(R.id.addPlayer);
                        addPlayer.setEnabled(false);
                    }
                }
            } else {
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("B³¹d");
                builder.setMessage("Taki gracz ju¿ istnieje!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.show();
            }
        }
    }

    public void startNewGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(KEY_ILE, "" + game.scoreBoardList.size());
        if (game.scoreBoardList.size() == 2) {
            intent.putExtra(KEY_P1, game.scoreBoardList.get(0).player.getName());
            intent.putExtra(KEY_P2, game.scoreBoardList.get(1).player.getName());
        } else if (game.scoreBoardList.size() == 3) {
            intent.putExtra(KEY_P1, game.scoreBoardList.get(0).player.getName());
            intent.putExtra(KEY_P2, game.scoreBoardList.get(1).player.getName());
            intent.putExtra(KEY_P3, game.scoreBoardList.get(2).player.getName());
        } else if (game.scoreBoardList.size() == 4) {
            intent.putExtra(KEY_P1, game.scoreBoardList.get(0).player.getName());
            intent.putExtra(KEY_P2, game.scoreBoardList.get(1).player.getName());
            intent.putExtra(KEY_P3, game.scoreBoardList.get(2).player.getName());
            intent.putExtra(KEY_P4, game.scoreBoardList.get(3).player.getName());
        }
        startActivity(intent);
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
