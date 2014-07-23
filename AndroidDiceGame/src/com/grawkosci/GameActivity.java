
package com.grawkosci;

import static com.grawkosci.ChoosePlayers.KEY_ILE;
import static com.grawkosci.ChoosePlayers.KEY_P1;
import static com.grawkosci.ChoosePlayers.KEY_P2;
import static com.grawkosci.ChoosePlayers.KEY_P3;
import static com.grawkosci.ChoosePlayers.KEY_P4;
import Controller.GameManager;
import Model.Dice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends Activity implements OnClickListener {

    GameManager game = new GameManager();

    public int playersCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        
        playersCount = Integer.parseInt(getIntent().getStringExtra(KEY_ILE));

        if (playersCount == 2) {
            String name = getIntent().getStringExtra(KEY_P1);
            TextView p1 = (TextView)findViewById(R.id.textViewPlayer1);
            p1.setText(name);
            game.getPlayers(name, 0, 0);
            name = getIntent().getStringExtra(KEY_P2);
            TextView p2 = (TextView)findViewById(R.id.textViewPlayer2);
            p2.setText(name);
            game.getPlayers(name, 0, 0);

        } else if (playersCount == 3) {
            String name = getIntent().getStringExtra(KEY_P1);
            TextView p1 = (TextView)findViewById(R.id.textViewPlayer1);
            p1.setText(name);
            game.getPlayers(name, 0, 0);
            name = getIntent().getStringExtra(KEY_P2);
            TextView p2 = (TextView)findViewById(R.id.textViewPlayer2);
            p2.setText(name);
            game.getPlayers(name, 0, 0);
            name = getIntent().getStringExtra(KEY_P3);
            TextView p3 = (TextView)findViewById(R.id.textViewPlayer3);
            p3.setText(name);
            game.getPlayers(name, 0, 0);
        } else if (playersCount == 4) {
            String name = getIntent().getStringExtra(KEY_P1);
            TextView p1 = (TextView)findViewById(R.id.textViewPlayer1);
            p1.setText(name);
            game.getPlayers(name, 0, 0);
            name = getIntent().getStringExtra(KEY_P2);
            TextView p2 = (TextView)findViewById(R.id.textViewPlayer2);
            p2.setText(name);
            game.getPlayers(name, 0, 0);
            name = getIntent().getStringExtra(KEY_P3);
            TextView p3 = (TextView)findViewById(R.id.textViewPlayer3);
            p3.setText(name);
            game.getPlayers(name, 0, 0);
            name = getIntent().getStringExtra(KEY_P4);
            TextView p4 = (TextView)findViewById(R.id.textViewPlayer4);
            p4.setText(name);

            game.getPlayers(name, 0, 0);
        }

        game.getDice();
        game.playGameFirst();

        showDice();
        showScoreBasic();
        showScoreTemp();
    }

    public void update() {
        deleteScoreTemp();
        game.playGamePointAdd();

        if (game.gameTurnFinal == 99) {
            int max = 0;
            for (int i = 1; i < game.scoreBoardList.size(); i++) {
                if (game.scoreBoardList.get(i).player.getPoints() > game.scoreBoardList.get(max).player
                        .getPoints())
                    max = i;
            }
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Zwyciêstwo");
            builder.setMessage("Wygra³ gracz: " + game.scoreBoardList.get(max).player.getName()
                    + " z " + game.scoreBoardList.get(max).player.getPoints() + "pkt!");
            builder.setIcon(android.R.drawable.ic_dialog_info);
            builder.show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        showDice();
        showScoreBasic();
        showScoreTemp();
    }

    public void deleteScoreTemp() {
        if (playersCount > 1) {
            TextView p1One = (TextView)findViewById(R.id.textViewP1One);
            if (p1One.getCurrentTextColor() == Color.GRAY)
                p1One.setText("");
            TextView p1Two = (TextView)findViewById(R.id.textViewP1Two);
            if (p1Two.getCurrentTextColor() == Color.GRAY)
                p1Two.setText("");
            TextView p1Three = (TextView)findViewById(R.id.textViewP1Three);
            if (p1Three.getCurrentTextColor() == Color.GRAY)
                p1Three.setText("");
            TextView p1Four = (TextView)findViewById(R.id.textViewP1Four);
            if (p1Four.getCurrentTextColor() == Color.GRAY)
                p1Four.setText("");
            TextView p1Five = (TextView)findViewById(R.id.textViewP1Five);
            if (p1Five.getCurrentTextColor() == Color.GRAY)
                p1Five.setText("");
            TextView p1Six = (TextView)findViewById(R.id.textViewP1Six);
            if (p1Six.getCurrentTextColor() == Color.GRAY)
                p1Six.setText("");
            TextView p1ThreeOfAKind = (TextView)findViewById(R.id.textViewP1ThreeOfAKind);
            if (p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY)
                p1ThreeOfAKind.setText("");
            TextView p1FourOfAKind = (TextView)findViewById(R.id.textViewP1FourOfAKind);
            if (p1FourOfAKind.getCurrentTextColor() == Color.GRAY)
                p1FourOfAKind.setText("");
            TextView p1Full = (TextView)findViewById(R.id.textViewP1Full);
            if (p1Full.getCurrentTextColor() == Color.GRAY)
                p1Full.setText("");
            TextView p1SmallSt = (TextView)findViewById(R.id.textViewP1SmallSt);
            if (p1SmallSt.getCurrentTextColor() == Color.GRAY)
                p1SmallSt.setText("");
            TextView p1LargeSt = (TextView)findViewById(R.id.textViewP1LargeSt);
            if (p1LargeSt.getCurrentTextColor() == Color.GRAY)
                p1LargeSt.setText("");
            TextView p1Yahtzee = (TextView)findViewById(R.id.textViewP1Yahtzee);
            if (p1Yahtzee.getCurrentTextColor() == Color.GRAY)
                p1Yahtzee.setText("");
            TextView p1Chance = (TextView)findViewById(R.id.textViewP1Chance);
            if (p1Chance.getCurrentTextColor() == Color.GRAY)
                p1Chance.setText("");

            TextView p2One = (TextView)findViewById(R.id.textViewP2One);
            if (p2One.getCurrentTextColor() == Color.GRAY)
                p2One.setText("");
            TextView p2Two = (TextView)findViewById(R.id.textViewP2Two);
            if (p2Two.getCurrentTextColor() == Color.GRAY)
                p2Two.setText("");
            TextView p2Three = (TextView)findViewById(R.id.textViewP2Three);
            if (p2Three.getCurrentTextColor() == Color.GRAY)
                p2Three.setText("");
            TextView p2Four = (TextView)findViewById(R.id.textViewP2Four);
            if (p2Four.getCurrentTextColor() == Color.GRAY)
                p2Four.setText("");
            TextView p2Five = (TextView)findViewById(R.id.textViewP2Five);
            if (p2Five.getCurrentTextColor() == Color.GRAY)
                p2Five.setText("");
            TextView p2Six = (TextView)findViewById(R.id.textViewP2Six);
            if (p2Six.getCurrentTextColor() == Color.GRAY)
                p2Six.setText("");
            TextView p2ThreeOfAKind = (TextView)findViewById(R.id.textViewP2ThreeOfAKind);
            if (p2ThreeOfAKind.getCurrentTextColor() == Color.GRAY)
                p2ThreeOfAKind.setText("");
            TextView p2FourOfAKind = (TextView)findViewById(R.id.textViewP2FourOfAKind);
            if (p2FourOfAKind.getCurrentTextColor() == Color.GRAY)
                p2FourOfAKind.setText("");
            TextView p2Full = (TextView)findViewById(R.id.textViewP2Full);
            if (p2Full.getCurrentTextColor() == Color.GRAY)
                p2Full.setText("");
            TextView p2SmallSt = (TextView)findViewById(R.id.textViewP2SmallSt);
            if (p2SmallSt.getCurrentTextColor() == Color.GRAY)
                p2SmallSt.setText("");
            TextView p2LargeSt = (TextView)findViewById(R.id.textViewP2LargeSt);
            if (p2LargeSt.getCurrentTextColor() == Color.GRAY)
                p2LargeSt.setText("");
            TextView p2Yahtzee = (TextView)findViewById(R.id.textViewP2Yahtzee);
            if (p2Yahtzee.getCurrentTextColor() == Color.GRAY)
                p2Yahtzee.setText("");
            TextView p2Chance = (TextView)findViewById(R.id.textViewP2Chance);
            if (p2Chance.getCurrentTextColor() == Color.GRAY)
                p2Chance.setText("");

        }
        if (playersCount > 2) {
            TextView p3One = (TextView)findViewById(R.id.textViewP3One);
            if (p3One.getCurrentTextColor() == Color.GRAY)
                p3One.setText("");
            TextView p3Two = (TextView)findViewById(R.id.textViewP3Two);
            if (p3Two.getCurrentTextColor() == Color.GRAY)
                p3Two.setText("");
            TextView p3Three = (TextView)findViewById(R.id.textViewP3Three);
            if (p3Three.getCurrentTextColor() == Color.GRAY)
                p3Three.setText("");
            TextView p3Four = (TextView)findViewById(R.id.textViewP3Four);
            if (p3Four.getCurrentTextColor() == Color.GRAY)
                p3Four.setText("");
            TextView p3Five = (TextView)findViewById(R.id.textViewP3Five);
            if (p3Five.getCurrentTextColor() == Color.GRAY)
                p3Five.setText("");
            TextView p3Six = (TextView)findViewById(R.id.textViewP3Six);
            if (p3Six.getCurrentTextColor() == Color.GRAY)
                p3Six.setText("");
            TextView p3ThreeOfAKind = (TextView)findViewById(R.id.textViewP3ThreeOfAKind);
            if (p3ThreeOfAKind.getCurrentTextColor() == Color.GRAY)
                p3ThreeOfAKind.setText("");
            TextView p3FourOfAKind = (TextView)findViewById(R.id.textViewP3FourOfAKind);
            if (p3FourOfAKind.getCurrentTextColor() == Color.GRAY)
                p3FourOfAKind.setText("");
            TextView p3Full = (TextView)findViewById(R.id.textViewP3Full);
            if (p3Full.getCurrentTextColor() == Color.GRAY)
                p3Full.setText("");
            TextView p3SmallSt = (TextView)findViewById(R.id.textViewP3SmallSt);
            if (p3SmallSt.getCurrentTextColor() == Color.GRAY)
                p3SmallSt.setText("");
            TextView p3LargeSt = (TextView)findViewById(R.id.textViewP3LargeSt);
            if (p3LargeSt.getCurrentTextColor() == Color.GRAY)
                p3LargeSt.setText("");
            TextView p3Yahtzee = (TextView)findViewById(R.id.textViewP3Yahtzee);
            if (p3Yahtzee.getCurrentTextColor() == Color.GRAY)
                p3Yahtzee.setText("");
            TextView p3Chance = (TextView)findViewById(R.id.textViewP3Chance);
            if (p3Chance.getCurrentTextColor() == Color.GRAY)
                p3Chance.setText("");
        }
        if (playersCount > 3) {
            TextView p4One = (TextView)findViewById(R.id.textViewP4One);
            if (p4One.getCurrentTextColor() == Color.GRAY)
                p4One.setText("");
            TextView p4Two = (TextView)findViewById(R.id.textViewP4Two);
            if (p4Two.getCurrentTextColor() == Color.GRAY)
                p4Two.setText("");
            TextView p4Three = (TextView)findViewById(R.id.textViewP4Three);
            if (p4Three.getCurrentTextColor() == Color.GRAY)
                p4Three.setText("");
            TextView p4Four = (TextView)findViewById(R.id.textViewP4Four);
            if (p4Four.getCurrentTextColor() == Color.GRAY)
                p4Four.setText("");
            TextView p4Five = (TextView)findViewById(R.id.textViewP4Five);
            if (p4Five.getCurrentTextColor() == Color.GRAY)
                p4Five.setText("");
            TextView p4Six = (TextView)findViewById(R.id.textViewP4Six);
            if (p4Six.getCurrentTextColor() == Color.GRAY)
                p4Six.setText("");
            TextView p4ThreeOfAKind = (TextView)findViewById(R.id.textViewP4ThreeOfAKind);
            if (p4ThreeOfAKind.getCurrentTextColor() == Color.GRAY)
                p4ThreeOfAKind.setText("");
            TextView p4FourOfAKind = (TextView)findViewById(R.id.textViewP4FourOfAKind);
            if (p4FourOfAKind.getCurrentTextColor() == Color.GRAY)
                p4FourOfAKind.setText("");
            TextView p4Full = (TextView)findViewById(R.id.textViewP4Full);
            if (p4Full.getCurrentTextColor() == Color.GRAY)
                p4Full.setText("");
            TextView p4SmallSt = (TextView)findViewById(R.id.textViewP4SmallSt);
            if (p4SmallSt.getCurrentTextColor() == Color.GRAY)
                p4SmallSt.setText("");
            TextView p4LargeSt = (TextView)findViewById(R.id.textViewP4LargeSt);
            if (p4LargeSt.getCurrentTextColor() == Color.GRAY)
                p4LargeSt.setText("");
            TextView p4Yahtzee = (TextView)findViewById(R.id.textViewP4Yahtzee);
            if (p4Yahtzee.getCurrentTextColor() == Color.GRAY)
                p4Yahtzee.setText("");
            TextView p4Chance = (TextView)findViewById(R.id.textViewP4Chance);
            if (p4Chance.getCurrentTextColor() == Color.GRAY)
                p4Chance.setText("");
        }

    }

    public void showDice() {
        Button roll = (Button)findViewById(R.id.buttonRoll);
        final ImageView d1 = (ImageView)findViewById(R.id.imageViewDice1);
        final ImageView d2 = (ImageView)findViewById(R.id.imageViewDice2);
        final ImageView d3 = (ImageView)findViewById(R.id.imageViewDice3);
        final ImageView d4 = (ImageView)findViewById(R.id.imageViewDice4);
        final ImageView d5 = (ImageView)findViewById(R.id.imageViewDice5);

        d1.setBackgroundColor(317840);
        d2.setBackgroundColor(317840);
        d3.setBackgroundColor(317840);
        d4.setBackgroundColor(317840);
        d5.setBackgroundColor(317840);

        if (game.diceList.get(0).spots == 1)
            d1.setImageResource(R.drawable.d1);
        else if (game.diceList.get(0).spots == 2)
            d1.setImageResource(R.drawable.d2);
        else if (game.diceList.get(0).spots == 3)
            d1.setImageResource(R.drawable.d3);
        else if (game.diceList.get(0).spots == 4)
            d1.setImageResource(R.drawable.d4);
        else if (game.diceList.get(0).spots == 5)
            d1.setImageResource(R.drawable.d5);
        else if (game.diceList.get(0).spots == 6)
            d1.setImageResource(R.drawable.d6);

        if (game.diceList.get(1).spots == 1)
            d2.setImageResource(R.drawable.d1);
        else if (game.diceList.get(1).spots == 2)
            d2.setImageResource(R.drawable.d2);
        else if (game.diceList.get(1).spots == 3)
            d2.setImageResource(R.drawable.d3);
        else if (game.diceList.get(1).spots == 4)
            d2.setImageResource(R.drawable.d4);
        else if (game.diceList.get(1).spots == 5)
            d2.setImageResource(R.drawable.d5);
        else if (game.diceList.get(1).spots == 6)
            d2.setImageResource(R.drawable.d6);

        if (game.diceList.get(2).spots == 1)
            d3.setImageResource(R.drawable.d1);
        else if (game.diceList.get(2).spots == 2)
            d3.setImageResource(R.drawable.d2);
        else if (game.diceList.get(2).spots == 3)
            d3.setImageResource(R.drawable.d3);
        else if (game.diceList.get(2).spots == 4)
            d3.setImageResource(R.drawable.d4);
        else if (game.diceList.get(2).spots == 5)
            d3.setImageResource(R.drawable.d5);
        else if (game.diceList.get(2).spots == 6)
            d3.setImageResource(R.drawable.d6);

        if (game.diceList.get(3).spots == 1)
            d4.setImageResource(R.drawable.d1);
        else if (game.diceList.get(3).spots == 2)
            d4.setImageResource(R.drawable.d2);
        else if (game.diceList.get(3).spots == 3)
            d4.setImageResource(R.drawable.d3);
        else if (game.diceList.get(3).spots == 4)
            d4.setImageResource(R.drawable.d4);
        else if (game.diceList.get(3).spots == 5)
            d4.setImageResource(R.drawable.d5);
        else if (game.diceList.get(3).spots == 6)
            d4.setImageResource(R.drawable.d6);

        if (game.diceList.get(4).spots == 1)
            d5.setImageResource(R.drawable.d1);
        else if (game.diceList.get(4).spots == 2)
            d5.setImageResource(R.drawable.d2);
        else if (game.diceList.get(4).spots == 3)
            d5.setImageResource(R.drawable.d3);
        else if (game.diceList.get(4).spots == 4)
            d5.setImageResource(R.drawable.d4);
        else if (game.diceList.get(4).spots == 5)
            d5.setImageResource(R.drawable.d5);
        else if (game.diceList.get(4).spots == 6)
            d5.setImageResource(R.drawable.d6);

        d1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (game.diceList.get(0).active == false) {
                    game.diceList.get(0).active = true;
                    d1.setBackgroundColor(Color.YELLOW);
                } else if (game.diceList.get(0).active == true) {
                    game.diceList.get(0).active = false;
                    d1.setBackgroundColor(317840);
                }
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (game.diceList.get(1).active == false) {
                    game.diceList.get(1).active = true;
                    d2.setBackgroundColor(Color.YELLOW);
                } else if (game.diceList.get(1).active == true) {
                    game.diceList.get(1).active = false;
                    d2.setBackgroundColor(317840);
                }
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (game.diceList.get(2).active == false) {
                    game.diceList.get(2).active = true;
                    d3.setBackgroundColor(Color.YELLOW);
                } else if (game.diceList.get(2).active == true) {
                    game.diceList.get(2).active = false;
                    d3.setBackgroundColor(317840);
                }
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (game.diceList.get(3).active == false) {
                    game.diceList.get(3).active = true;
                    d4.setBackgroundColor(Color.YELLOW);
                } else if (game.diceList.get(3).active == true) {
                    game.diceList.get(3).active = false;
                    d4.setBackgroundColor(317840);
                }
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (game.diceList.get(4).active == false) {
                    game.diceList.get(4).active = true;
                    d5.setBackgroundColor(Color.YELLOW);
                } else if (game.diceList.get(4).active == true) {
                    game.diceList.get(4).active = false;
                    d5.setBackgroundColor(317840);
                }
            }
        });
        roll.setText("Rzut (" + (3 - game.gameTurn) + ")");
    }

    public void showScoreBasic() {
        if (playersCount > 1) {
            TextView p1Bonus = (TextView)findViewById(R.id.textViewP1Bonus);
            TextView p1Suma1 = (TextView)findViewById(R.id.textViewP1Suma1);
            TextView p1Suma2 = (TextView)findViewById(R.id.textViewP1Suma2);
            TextView p1Total = (TextView)findViewById(R.id.textViewP1Total);
            p1Bonus.setText("" + game.scoreBoardList.get(0).getBonus());
            p1Suma1.setText(""
                    + (game.scoreBoardList.get(0).getBonus() + game.scoreBoardList.get(0).getSix()
                            + game.scoreBoardList.get(0).getFive()
                            + game.scoreBoardList.get(0).getFour()
                            + game.scoreBoardList.get(0).getThree()
                            + game.scoreBoardList.get(0).getTwo() + game.scoreBoardList.get(0)
                            .getOne()));
            p1Suma2.setText(""
                    + (game.scoreBoardList.get(0).getThreeOfAKind()
                            + game.scoreBoardList.get(0).getFourOfAKind()
                            + game.scoreBoardList.get(0).getFullHouse()
                            + game.scoreBoardList.get(0).getSmallStright()
                            + game.scoreBoardList.get(0).getLargeStright()
                            + game.scoreBoardList.get(0).getYahtzze() + game.scoreBoardList.get(0)
                            .getChance()));
            p1Total.setText("" + game.scoreBoardList.get(0).player.getPoints());

            TextView p2Bonus = (TextView)findViewById(R.id.textViewP2Bonus);
            TextView p2Suma1 = (TextView)findViewById(R.id.textViewP2Suma1);
            TextView p2Suma2 = (TextView)findViewById(R.id.textViewP2Suma2);
            TextView p2Total = (TextView)findViewById(R.id.textViewP2Total);
            p2Bonus.setText("" + game.scoreBoardList.get(1).getBonus());
            p2Suma1.setText(""
                    + (game.scoreBoardList.get(1).getBonus() + game.scoreBoardList.get(1).getSix()
                            + game.scoreBoardList.get(1).getFive()
                            + game.scoreBoardList.get(1).getFour()
                            + game.scoreBoardList.get(1).getThree()
                            + game.scoreBoardList.get(1).getTwo() + game.scoreBoardList.get(1)
                            .getOne()));
            p2Suma2.setText(""
                    + (game.scoreBoardList.get(1).getThreeOfAKind()
                            + game.scoreBoardList.get(1).getFourOfAKind()
                            + game.scoreBoardList.get(1).getFullHouse()
                            + game.scoreBoardList.get(1).getSmallStright()
                            + game.scoreBoardList.get(1).getLargeStright()
                            + game.scoreBoardList.get(1).getYahtzze() + game.scoreBoardList.get(1)
                            .getChance()));
            p2Total.setText("" + game.scoreBoardList.get(1).player.getPoints());

        }
        if (playersCount > 2) {
            TextView p3Bonus = (TextView)findViewById(R.id.textViewP3Bonus);
            TextView p3Suma1 = (TextView)findViewById(R.id.textViewP3Suma1);
            TextView p3Suma2 = (TextView)findViewById(R.id.textViewP3Suma2);
            TextView p3Total = (TextView)findViewById(R.id.textViewP3Total);
            p3Bonus.setText("" + game.scoreBoardList.get(2).getBonus());
            p3Suma1.setText(""
                    + (game.scoreBoardList.get(2).getBonus() + game.scoreBoardList.get(2).getSix()
                            + game.scoreBoardList.get(2).getFive()
                            + game.scoreBoardList.get(2).getFour()
                            + game.scoreBoardList.get(2).getThree()
                            + game.scoreBoardList.get(2).getTwo() + game.scoreBoardList.get(2)
                            .getOne()));
            p3Suma2.setText(""
                    + (game.scoreBoardList.get(2).getThreeOfAKind()
                            + game.scoreBoardList.get(2).getFourOfAKind()
                            + game.scoreBoardList.get(2).getFullHouse()
                            + game.scoreBoardList.get(2).getSmallStright()
                            + game.scoreBoardList.get(2).getLargeStright()
                            + game.scoreBoardList.get(2).getYahtzze() + game.scoreBoardList.get(2)
                            .getChance()));
            p3Total.setText("" + game.scoreBoardList.get(2).player.getPoints());

        }
        if (playersCount > 3) {
            TextView p4Bonus = (TextView)findViewById(R.id.textViewP4Bonus);
            TextView p4Suma1 = (TextView)findViewById(R.id.textViewP4Suma1);
            TextView p4Suma2 = (TextView)findViewById(R.id.textViewP4Suma2);
            TextView p4Total = (TextView)findViewById(R.id.textViewP4Total);
            p4Bonus.setText("" + game.scoreBoardList.get(3).getBonus());
            p4Suma1.setText(""
                    + (game.scoreBoardList.get(3).getBonus() + game.scoreBoardList.get(3).getSix()
                            + game.scoreBoardList.get(3).getFive()
                            + game.scoreBoardList.get(3).getFour()
                            + game.scoreBoardList.get(3).getThree()
                            + game.scoreBoardList.get(3).getTwo() + game.scoreBoardList.get(3)
                            .getOne()));
            p4Suma2.setText(""
                    + (game.scoreBoardList.get(3).getThreeOfAKind()
                            + game.scoreBoardList.get(3).getFourOfAKind()
                            + game.scoreBoardList.get(3).getFullHouse()
                            + game.scoreBoardList.get(3).getSmallStright()
                            + game.scoreBoardList.get(3).getLargeStright()
                            + game.scoreBoardList.get(3).getYahtzze() + game.scoreBoardList.get(3)
                            .getChance()));
            p4Total.setText("" + game.scoreBoardList.get(3).player.getPoints());
        }
    }

    public void showScoreTemp() {
        if (game.whoPlay == 1) {
            final TextView p1One = (TextView)findViewById(R.id.textViewP1One);
            if (p1One.getText().equals("") || p1One.getCurrentTextColor() == Color.GRAY) {
                p1One.setTextColor(Color.GRAY);
                p1One.setText("(" + new Dice(game.diceList).isOne() + ")");
                p1One.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1One.getCurrentTextColor() == Color.GRAY
                                && !p1One.getText().equals("")) {
                            game.scoreBoardList.get(0).setOne(new Dice(game.diceList).isOne());
                            p1One.setText("" + game.scoreBoardList.get(0).getOne());
                            p1One.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Two = (TextView)findViewById(R.id.textViewP1Two);
            if (p1Two.getText().equals("") || p1Two.getCurrentTextColor() == Color.GRAY) {
                p1Two.setTextColor(Color.GRAY);
                p1Two.setText("(" + new Dice(game.diceList).isTwo() + ")");
                p1Two.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Two.getCurrentTextColor() == Color.GRAY
                                && !p1Two.getText().equals("")) {
                            game.scoreBoardList.get(0).setTwo(new Dice(game.diceList).isTwo());
                            p1Two.setText("" + game.scoreBoardList.get(0).getTwo());
                            p1Two.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Three = (TextView)findViewById(R.id.textViewP1Three);
            if (p1Three.getText().equals("") || p1Three.getCurrentTextColor() == Color.GRAY) {
                p1Three.setTextColor(Color.GRAY);
                p1Three.setText("(" + new Dice(game.diceList).isThree() + ")");
                p1Three.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Three.getCurrentTextColor() == Color.GRAY
                                && !p1Three.getText().equals("")) {
                            game.scoreBoardList.get(0).setThree(new Dice(game.diceList).isThree());
                            p1Three.setText("" + game.scoreBoardList.get(0).getThree());
                            p1Three.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Four = (TextView)findViewById(R.id.textViewP1Four);
            if (p1Four.getText().equals("") || p1Four.getCurrentTextColor() == Color.GRAY) {
                p1Four.setTextColor(Color.GRAY);
                p1Four.setText("(" + new Dice(game.diceList).isFour() + ")");
                p1Four.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Four.getCurrentTextColor() == Color.GRAY
                                && !p1Four.getText().equals("")) {
                            game.scoreBoardList.get(0).setFour(new Dice(game.diceList).isFour());
                            p1Four.setText("" + game.scoreBoardList.get(0).getFour());
                            p1Four.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Five = (TextView)findViewById(R.id.textViewP1Five);
            if (p1Five.getText().equals("") || p1Five.getCurrentTextColor() == Color.GRAY) {
                p1Five.setTextColor(Color.GRAY);
                p1Five.setText("(" + new Dice(game.diceList).isFive() + ")");
                p1Five.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Five.getCurrentTextColor() == Color.GRAY
                                && !p1Five.getText().equals("")) {
                            game.scoreBoardList.get(0).setFive(new Dice(game.diceList).isFive());
                            p1Five.setText("" + game.scoreBoardList.get(0).getFive());
                            p1Five.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Six = (TextView)findViewById(R.id.textViewP1Six);
            if (p1Six.getText().equals("") || p1Six.getCurrentTextColor() == Color.GRAY) {
                p1Six.setTextColor(Color.GRAY);
                p1Six.setText("(" + new Dice(game.diceList).isSix() + ")");
                p1Six.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Six.getCurrentTextColor() == Color.GRAY
                                && !p1Six.getText().equals("")) {
                            game.scoreBoardList.get(0).setSix(new Dice(game.diceList).isSix());
                            p1Six.setText("" + game.scoreBoardList.get(0).getSix());
                            p1Six.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1ThreeOfAKind = (TextView)findViewById(R.id.textViewP1ThreeOfAKind);
            if (p1ThreeOfAKind.getText().equals("")
                    || p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY) {
                p1ThreeOfAKind.setTextColor(Color.GRAY);
                p1ThreeOfAKind.setText("(" + new Dice(game.diceList).isThreeOfAKind() + ")");
                p1ThreeOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0).setThreeOfAKind(
                                    new Dice(game.diceList).isThreeOfAKind());
                            p1ThreeOfAKind.setText(""
                                    + game.scoreBoardList.get(0).getThreeOfAKind());
                            p1ThreeOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1FourOfAKind = (TextView)findViewById(R.id.textViewP1FourOfAKind);
            if (p1FourOfAKind.getText().equals("")
                    || p1FourOfAKind.getCurrentTextColor() == Color.GRAY) {
                p1FourOfAKind.setTextColor(Color.GRAY);
                p1FourOfAKind.setText("(" + new Dice(game.diceList).isFourOfAKind() + ")");
                p1FourOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1FourOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0).setFourOfAKind(
                                    new Dice(game.diceList).isFourOfAKind());
                            p1FourOfAKind.setText("" + game.scoreBoardList.get(0).getFourOfAKind());
                            p1FourOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Full = (TextView)findViewById(R.id.textViewP1Full);
            if (p1Full.getText().equals("") || p1Full.getCurrentTextColor() == Color.GRAY) {
                p1Full.setTextColor(Color.GRAY);
                p1Full.setText("(" + new Dice(game.diceList).isFullHouse() + ")");
                p1Full.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Full.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0).setFullHouse(
                                    new Dice(game.diceList).isFullHouse());
                            p1Full.setText("" + game.scoreBoardList.get(0).getFullHouse());
                            p1Full.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1SmallSt = (TextView)findViewById(R.id.textViewP1SmallSt);
            if (p1SmallSt.getText().equals("") || p1SmallSt.getCurrentTextColor() == Color.GRAY) {
                p1SmallSt.setTextColor(Color.GRAY);
                p1SmallSt.setText("(" + new Dice(game.diceList).isSmallStraight() + ")");
                p1SmallSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1SmallSt.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0).setSmallStraight(
                                    new Dice(game.diceList).isSmallStraight());
                            p1SmallSt.setText("" + game.scoreBoardList.get(0).getSmallStright());
                            p1SmallSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1LargeSt = (TextView)findViewById(R.id.textViewP1LargeSt);
            if (p1LargeSt.getText().equals("") || p1LargeSt.getCurrentTextColor() == Color.GRAY) {
                p1LargeSt.setTextColor(Color.GRAY);
                p1LargeSt.setText("(" + new Dice(game.diceList).isLargeStraight() + ")");
                p1LargeSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1LargeSt.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0).setLargeStraight(
                                    new Dice(game.diceList).isLargeStraight());
                            p1LargeSt.setText("" + game.scoreBoardList.get(0).getLargeStright());
                            p1LargeSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Yahtzee = (TextView)findViewById(R.id.textViewP1Yahtzee);
            if (p1Yahtzee.getText().equals("") || p1Yahtzee.getCurrentTextColor() == Color.GRAY) {
                p1Yahtzee.setTextColor(Color.GRAY);
                p1Yahtzee.setText("(" + new Dice(game.diceList).isYahtzze() + ")");
                p1Yahtzee.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Yahtzee.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0).setYahtzze(
                                    new Dice(game.diceList).isYahtzze());
                            p1Yahtzee.setText("" + game.scoreBoardList.get(0).getYahtzze());
                            p1Yahtzee.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Chance = (TextView)findViewById(R.id.textViewP1Chance);
            if (p1Chance.getText().equals("") || p1Chance.getCurrentTextColor() == Color.GRAY) {
                p1Chance.setTextColor(Color.GRAY);
                p1Chance.setText("(" + new Dice(game.diceList).isChance() + ")");
                p1Chance.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Chance.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(0)
                                    .setChance(new Dice(game.diceList).isChance());
                            p1Chance.setText("" + game.scoreBoardList.get(0).getChance());
                            p1Chance.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
        } else if (game.whoPlay == 2) {
            final TextView p2One = (TextView)findViewById(R.id.textViewP2One);
            if (p2One.getText().equals("") || p2One.getCurrentTextColor() == Color.GRAY) {
                p2One.setTextColor(Color.GRAY);
                p2One.setText("(" + new Dice(game.diceList).isOne() + ")");
                p2One.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2One.getCurrentTextColor() == Color.GRAY
                                && !p2One.getText().equals("")) {
                            game.scoreBoardList.get(1).setOne(new Dice(game.diceList).isOne());
                            p2One.setText("" + game.scoreBoardList.get(1).getOne());
                            p2One.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p2Two = (TextView)findViewById(R.id.textViewP2Two);
            if (p2Two.getText().equals("") || p2Two.getCurrentTextColor() == Color.GRAY) {
                p2Two.setTextColor(Color.GRAY);
                p2Two.setText("(" + new Dice(game.diceList).isTwo() + ")");
                p2Two.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Two.getCurrentTextColor() == Color.GRAY
                                && !p2Two.getText().equals("")) {
                            game.scoreBoardList.get(1).setTwo(new Dice(game.diceList).isTwo());
                            p2Two.setText("" + game.scoreBoardList.get(1).getTwo());
                            p2Two.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p2Three = (TextView)findViewById(R.id.textViewP2Three);
            if (p2Three.getText().equals("") || p2Three.getCurrentTextColor() == Color.GRAY) {
                p2Three.setTextColor(Color.GRAY);
                p2Three.setText("(" + new Dice(game.diceList).isThree() + ")");
                p2Three.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Three.getCurrentTextColor() == Color.GRAY
                                && !p2Three.getText().equals("")) {
                            game.scoreBoardList.get(1).setThree(new Dice(game.diceList).isThree());
                            p2Three.setText("" + game.scoreBoardList.get(1).getThree());
                            p2Three.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p2Four = (TextView)findViewById(R.id.textViewP2Four);
            if (p2Four.getText().equals("") || p2Four.getCurrentTextColor() == Color.GRAY) {
                p2Four.setTextColor(Color.GRAY);
                p2Four.setText("(" + new Dice(game.diceList).isFour() + ")");
                p2Four.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Four.getCurrentTextColor() == Color.GRAY
                                && !p2Four.getText().equals("")) {
                            game.scoreBoardList.get(1).setFour(new Dice(game.diceList).isFour());
                            p2Four.setText("" + game.scoreBoardList.get(1).getFour());
                            p2Four.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p2Five = (TextView)findViewById(R.id.textViewP2Five);
            if (p2Five.getText().equals("") || p2Five.getCurrentTextColor() == Color.GRAY) {
                p2Five.setTextColor(Color.GRAY);
                p2Five.setText("(" + new Dice(game.diceList).isFive() + ")");
                p2Five.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Five.getCurrentTextColor() == Color.GRAY
                                && !p2Five.getText().equals("")) {
                            game.scoreBoardList.get(1).setFive(new Dice(game.diceList).isFive());
                            p2Five.setText("" + game.scoreBoardList.get(1).getFive());
                            p2Five.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p2Six = (TextView)findViewById(R.id.textViewP2Six);
            if (p2Six.getText().equals("") || p2Six.getCurrentTextColor() == Color.GRAY) {
                p2Six.setTextColor(Color.GRAY);
                p2Six.setText("(" + new Dice(game.diceList).isSix() + ")");
                p2Six.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Six.getCurrentTextColor() == Color.GRAY
                                && !p2Six.getText().equals("")) {
                            game.scoreBoardList.get(1).setSix(new Dice(game.diceList).isSix());
                            p2Six.setText("" + game.scoreBoardList.get(1).getSix());
                            p2Six.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2ThreeOfAKind = (TextView)findViewById(R.id.textViewP2ThreeOfAKind);
            if (p2ThreeOfAKind.getText().equals("")
                    || p2ThreeOfAKind.getCurrentTextColor() == Color.GRAY) {
                p2ThreeOfAKind.setTextColor(Color.GRAY);
                p2ThreeOfAKind.setText("(" + new Dice(game.diceList).isThreeOfAKind() + ")");
                p2ThreeOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2ThreeOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p2ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(1).setThreeOfAKind(
                                    new Dice(game.diceList).isThreeOfAKind());
                            p2ThreeOfAKind.setText(""
                                    + game.scoreBoardList.get(1).getThreeOfAKind());
                            p2ThreeOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2FourOfAKind = (TextView)findViewById(R.id.textViewP2FourOfAKind);
            if (p2FourOfAKind.getText().equals("")
                    || p2FourOfAKind.getCurrentTextColor() == Color.GRAY) {
                p2FourOfAKind.setTextColor(Color.GRAY);
                p2FourOfAKind.setText("(" + new Dice(game.diceList).isFourOfAKind() + ")");
                p2FourOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2FourOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p2FourOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(1).setFourOfAKind(
                                    new Dice(game.diceList).isFourOfAKind());
                            p2FourOfAKind.setText("" + game.scoreBoardList.get(1).getFourOfAKind());
                            p2FourOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2Full = (TextView)findViewById(R.id.textViewP2Full);
            if (p2Full.getText().equals("") || p2Full.getCurrentTextColor() == Color.GRAY) {
                p2Full.setTextColor(Color.GRAY);
                p2Full.setText("(" + new Dice(game.diceList).isFullHouse() + ")");
                p2Full.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Full.getCurrentTextColor() == Color.GRAY
                                && !p2Full.getText().equals("")) {
                            game.scoreBoardList.get(1).setFullHouse(
                                    new Dice(game.diceList).isFullHouse());
                            p2Full.setText("" + game.scoreBoardList.get(1).getFullHouse());
                            p2Full.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2SmallSt = (TextView)findViewById(R.id.textViewP2SmallSt);
            if (p2SmallSt.getText().equals("") || p2SmallSt.getCurrentTextColor() == Color.GRAY) {
                p2SmallSt.setTextColor(Color.GRAY);
                p2SmallSt.setText("(" + new Dice(game.diceList).isSmallStraight() + ")");
                p2SmallSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2SmallSt.getCurrentTextColor() == Color.GRAY
                                && !p2SmallSt.getText().equals("")) {
                            game.scoreBoardList.get(1).setSmallStraight(
                                    new Dice(game.diceList).isSmallStraight());
                            p2SmallSt.setText("" + game.scoreBoardList.get(1).getSmallStright());
                            p2SmallSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2LargeSt = (TextView)findViewById(R.id.textViewP2LargeSt);
            if (p2LargeSt.getText().equals("") || p2LargeSt.getCurrentTextColor() == Color.GRAY) {
                p2LargeSt.setTextColor(Color.GRAY);
                p2LargeSt.setText("(" + new Dice(game.diceList).isLargeStraight() + ")");
                p2LargeSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2LargeSt.getCurrentTextColor() == Color.GRAY
                                && !p2LargeSt.getText().equals("")) {
                            game.scoreBoardList.get(1).setLargeStraight(
                                    new Dice(game.diceList).isLargeStraight());
                            p2LargeSt.setText("" + game.scoreBoardList.get(1).getLargeStright());
                            p2LargeSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2Yahtzee = (TextView)findViewById(R.id.textViewP2Yahtzee);
            if (p2Yahtzee.getText().equals("") || p2Yahtzee.getCurrentTextColor() == Color.GRAY) {
                p2Yahtzee.setTextColor(Color.GRAY);
                p2Yahtzee.setText("(" + new Dice(game.diceList).isYahtzze() + ")");
                p2Yahtzee.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Yahtzee.getCurrentTextColor() == Color.GRAY
                                && !p2Yahtzee.getText().equals("")) {
                            game.scoreBoardList.get(1).setYahtzze(
                                    new Dice(game.diceList).isYahtzze());
                            p2Yahtzee.setText("" + game.scoreBoardList.get(1).getYahtzze());
                            p2Yahtzee.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p2Chance = (TextView)findViewById(R.id.textViewP2Chance);
            if (p2Chance.getText().equals("") || p2Chance.getCurrentTextColor() == Color.GRAY) {
                p2Chance.setTextColor(Color.GRAY);
                p2Chance.setText("(" + new Dice(game.diceList).isChance() + ")");
                p2Chance.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p2Chance.getCurrentTextColor() == Color.GRAY
                                && !p2Chance.getText().equals("")) {
                            game.scoreBoardList.get(1)
                                    .setChance(new Dice(game.diceList).isChance());
                            p2Chance.setText("" + game.scoreBoardList.get(1).getChance());
                            p2Chance.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
        } else if (game.whoPlay == 3) {
            final TextView p1One = (TextView)findViewById(R.id.textViewP3One);
            if (p1One.getText().equals("") || p1One.getCurrentTextColor() == Color.GRAY) {
                p1One.setTextColor(Color.GRAY);
                p1One.setText("(" + new Dice(game.diceList).isOne() + ")");
                p1One.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1One.getCurrentTextColor() == Color.GRAY
                                && !p1One.getText().equals("")) {
                            game.scoreBoardList.get(2).setOne(new Dice(game.diceList).isOne());
                            p1One.setText("" + game.scoreBoardList.get(2).getOne());
                            p1One.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Two = (TextView)findViewById(R.id.textViewP3Two);
            if (p1Two.getText().equals("") || p1Two.getCurrentTextColor() == Color.GRAY) {
                p1Two.setTextColor(Color.GRAY);
                p1Two.setText("(" + new Dice(game.diceList).isTwo() + ")");
                p1Two.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Two.getCurrentTextColor() == Color.GRAY
                                && !p1Two.getText().equals("")) {
                            game.scoreBoardList.get(2).setTwo(new Dice(game.diceList).isTwo());
                            p1Two.setText("" + game.scoreBoardList.get(2).getTwo());
                            p1Two.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Three = (TextView)findViewById(R.id.textViewP3Three);
            if (p1Three.getText().equals("") || p1Three.getCurrentTextColor() == Color.GRAY) {
                p1Three.setTextColor(Color.GRAY);
                p1Three.setText("(" + new Dice(game.diceList).isThree() + ")");
                p1Three.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Three.getCurrentTextColor() == Color.GRAY
                                && !p1Three.getText().equals("")) {
                            game.scoreBoardList.get(2).setThree(new Dice(game.diceList).isThree());
                            p1Three.setText("" + game.scoreBoardList.get(2).getThree());
                            p1Three.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Four = (TextView)findViewById(R.id.textViewP3Four);
            if (p1Four.getText().equals("") || p1Four.getCurrentTextColor() == Color.GRAY) {
                p1Four.setTextColor(Color.GRAY);
                p1Four.setText("(" + new Dice(game.diceList).isFour() + ")");
                p1Four.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Four.getCurrentTextColor() == Color.GRAY
                                && !p1Four.getText().equals("")) {
                            game.scoreBoardList.get(2).setFour(new Dice(game.diceList).isFour());
                            p1Four.setText("" + game.scoreBoardList.get(2).getFour());
                            p1Four.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Five = (TextView)findViewById(R.id.textViewP3Five);
            if (p1Five.getText().equals("") || p1Five.getCurrentTextColor() == Color.GRAY) {
                p1Five.setTextColor(Color.GRAY);
                p1Five.setText("(" + new Dice(game.diceList).isFive() + ")");
                p1Five.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Five.getCurrentTextColor() == Color.GRAY
                                && !p1Five.getText().equals("")) {
                            game.scoreBoardList.get(2).setFive(new Dice(game.diceList).isFive());
                            p1Five.setText("" + game.scoreBoardList.get(2).getFive());
                            p1Five.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Six = (TextView)findViewById(R.id.textViewP3Six);
            if (p1Six.getText().equals("") || p1Six.getCurrentTextColor() == Color.GRAY) {
                p1Six.setTextColor(Color.GRAY);
                p1Six.setText("(" + new Dice(game.diceList).isSix() + ")");
                p1Six.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Six.getCurrentTextColor() == Color.GRAY
                                && !p1Six.getText().equals("")) {
                            game.scoreBoardList.get(2).setSix(new Dice(game.diceList).isSix());
                            p1Six.setText("" + game.scoreBoardList.get(2).getSix());
                            p1Six.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1ThreeOfAKind = (TextView)findViewById(R.id.textViewP3ThreeOfAKind);
            if (p1ThreeOfAKind.getText().equals("")
                    || p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY) {
                p1ThreeOfAKind.setTextColor(Color.GRAY);
                p1ThreeOfAKind.setText("(" + new Dice(game.diceList).isThreeOfAKind() + ")");
                p1ThreeOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(2).setThreeOfAKind(
                                    new Dice(game.diceList).isThreeOfAKind());
                            p1ThreeOfAKind.setText(""
                                    + game.scoreBoardList.get(2).getThreeOfAKind());
                            p1ThreeOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1FourOfAKind = (TextView)findViewById(R.id.textViewP3FourOfAKind);
            if (p1FourOfAKind.getText().equals("")
                    || p1FourOfAKind.getCurrentTextColor() == Color.GRAY) {
                p1FourOfAKind.setTextColor(Color.GRAY);
                p1FourOfAKind.setText("(" + new Dice(game.diceList).isFourOfAKind() + ")");
                p1FourOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1FourOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p1FourOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(2).setFourOfAKind(
                                    new Dice(game.diceList).isFourOfAKind());
                            p1FourOfAKind.setText("" + game.scoreBoardList.get(2).getFourOfAKind());
                            p1FourOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Full = (TextView)findViewById(R.id.textViewP3Full);
            if (p1Full.getText().equals("") || p1Full.getCurrentTextColor() == Color.GRAY) {
                p1Full.setTextColor(Color.GRAY);
                p1Full.setText("(" + new Dice(game.diceList).isFullHouse() + ")");
                p1Full.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Full.getCurrentTextColor() == Color.GRAY
                                && !p1Full.getText().equals("")) {
                            game.scoreBoardList.get(2).setFullHouse(
                                    new Dice(game.diceList).isFullHouse());
                            p1Full.setText("" + game.scoreBoardList.get(2).getFullHouse());
                            p1Full.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1SmallSt = (TextView)findViewById(R.id.textViewP3SmallSt);
            if (p1SmallSt.getText().equals("") || p1SmallSt.getCurrentTextColor() == Color.GRAY) {
                p1SmallSt.setTextColor(Color.GRAY);
                p1SmallSt.setText("(" + new Dice(game.diceList).isSmallStraight() + ")");
                p1SmallSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1SmallSt.getCurrentTextColor() == Color.GRAY
                                && !p1SmallSt.getText().equals("")) {
                            game.scoreBoardList.get(2).setSmallStraight(
                                    new Dice(game.diceList).isSmallStraight());
                            p1SmallSt.setText("" + game.scoreBoardList.get(2).getSmallStright());
                            p1SmallSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1LargeSt = (TextView)findViewById(R.id.textViewP3LargeSt);
            if (p1LargeSt.getText().equals("") || p1LargeSt.getCurrentTextColor() == Color.GRAY) {
                p1LargeSt.setTextColor(Color.GRAY);
                p1LargeSt.setText("(" + new Dice(game.diceList).isLargeStraight() + ")");
                p1LargeSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1LargeSt.getCurrentTextColor() == Color.GRAY
                                && !p1LargeSt.getText().equals("")) {
                            game.scoreBoardList.get(2).setLargeStraight(
                                    new Dice(game.diceList).isLargeStraight());
                            p1LargeSt.setText("" + game.scoreBoardList.get(2).getLargeStright());
                            p1LargeSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Yahtzee = (TextView)findViewById(R.id.textViewP3Yahtzee);
            if (p1Yahtzee.getText().equals("") || p1Yahtzee.getCurrentTextColor() == Color.GRAY) {
                p1Yahtzee.setTextColor(Color.GRAY);
                p1Yahtzee.setText("(" + new Dice(game.diceList).isYahtzze() + ")");
                p1Yahtzee.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Yahtzee.getCurrentTextColor() == Color.GRAY
                                && !p1Yahtzee.getText().equals("")) {
                            game.scoreBoardList.get(2).setYahtzze(
                                    new Dice(game.diceList).isYahtzze());
                            p1Yahtzee.setText("" + game.scoreBoardList.get(2).getYahtzze());
                            p1Yahtzee.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Chance = (TextView)findViewById(R.id.textViewP3Chance);
            if (p1Chance.getText().equals("") || p1Chance.getCurrentTextColor() == Color.GRAY) {
                p1Chance.setTextColor(Color.GRAY);
                p1Chance.setText("(" + new Dice(game.diceList).isChance() + ")");
                p1Chance.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Chance.getCurrentTextColor() == Color.GRAY
                                && !p1Chance.getText().equals("")) {
                            game.scoreBoardList.get(2)
                                    .setChance(new Dice(game.diceList).isChance());
                            p1Chance.setText("" + game.scoreBoardList.get(2).getChance());
                            p1Chance.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
        } else if (game.whoPlay == 4) {
            final TextView p1One = (TextView)findViewById(R.id.textViewP4One);
            if (p1One.getText().equals("") || p1One.getCurrentTextColor() == Color.GRAY) {
                p1One.setTextColor(Color.GRAY);
                p1One.setText("(" + new Dice(game.diceList).isOne() + ")");
                p1One.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1One.getCurrentTextColor() == Color.GRAY
                                && !p1One.getText().equals("")) {
                            game.scoreBoardList.get(3).setOne(new Dice(game.diceList).isOne());
                            p1One.setText("" + game.scoreBoardList.get(3).getOne());
                            p1One.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Two = (TextView)findViewById(R.id.textViewP4Two);
            if (p1Two.getText().equals("") || p1Two.getCurrentTextColor() == Color.GRAY) {
                p1Two.setTextColor(Color.GRAY);
                p1Two.setText("(" + new Dice(game.diceList).isTwo() + ")");
                p1Two.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Two.getCurrentTextColor() == Color.GRAY
                                && !p1Two.getText().equals("")) {
                            game.scoreBoardList.get(3).setTwo(new Dice(game.diceList).isTwo());
                            p1Two.setText("" + game.scoreBoardList.get(3).getTwo());
                            p1Two.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Three = (TextView)findViewById(R.id.textViewP4Three);
            if (p1Three.getText().equals("") || p1Three.getCurrentTextColor() == Color.GRAY) {
                p1Three.setTextColor(Color.GRAY);
                p1Three.setText("(" + new Dice(game.diceList).isThree() + ")");
                p1Three.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Three.getCurrentTextColor() == Color.GRAY
                                && !p1Three.getText().equals("")) {
                            game.scoreBoardList.get(3).setThree(new Dice(game.diceList).isThree());
                            p1Three.setText("" + game.scoreBoardList.get(3).getThree());
                            p1Three.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Four = (TextView)findViewById(R.id.textViewP4Four);
            if (p1Four.getText().equals("") || p1Four.getCurrentTextColor() == Color.GRAY) {
                p1Four.setTextColor(Color.GRAY);
                p1Four.setText("(" + new Dice(game.diceList).isFour() + ")");
                p1Four.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Four.getCurrentTextColor() == Color.GRAY
                                && !p1Four.getText().equals("")) {
                            game.scoreBoardList.get(3).setFour(new Dice(game.diceList).isFour());
                            p1Four.setText("" + game.scoreBoardList.get(3).getFour());
                            p1Four.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Five = (TextView)findViewById(R.id.textViewP4Five);
            if (p1Five.getText().equals("") || p1Five.getCurrentTextColor() == Color.GRAY) {
                p1Five.setTextColor(Color.GRAY);
                p1Five.setText("(" + new Dice(game.diceList).isFive() + ")");
                p1Five.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Five.getCurrentTextColor() == Color.GRAY
                                && !p1Five.getText().equals("")) {
                            game.scoreBoardList.get(3).setFive(new Dice(game.diceList).isFive());
                            p1Five.setText("" + game.scoreBoardList.get(3).getFive());
                            p1Five.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
            final TextView p1Six = (TextView)findViewById(R.id.textViewP4Six);
            if (p1Six.getText().equals("") || p1Six.getCurrentTextColor() == Color.GRAY) {
                p1Six.setTextColor(Color.GRAY);
                p1Six.setText("(" + new Dice(game.diceList).isSix() + ")");
                p1Six.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Six.getCurrentTextColor() == Color.GRAY
                                && !p1Six.getText().equals("")) {
                            game.scoreBoardList.get(3).setSix(new Dice(game.diceList).isSix());
                            p1Six.setText("" + game.scoreBoardList.get(3).getSix());
                            p1Six.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1ThreeOfAKind = (TextView)findViewById(R.id.textViewP4ThreeOfAKind);
            if (p1ThreeOfAKind.getText().equals("")
                    || p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY) {
                p1ThreeOfAKind.setTextColor(Color.GRAY);
                p1ThreeOfAKind.setText("(" + new Dice(game.diceList).isThreeOfAKind() + ")");
                p1ThreeOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1ThreeOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p1ThreeOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(3).setThreeOfAKind(
                                    new Dice(game.diceList).isThreeOfAKind());
                            p1ThreeOfAKind.setText(""
                                    + game.scoreBoardList.get(3).getThreeOfAKind());
                            p1ThreeOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1FourOfAKind = (TextView)findViewById(R.id.textViewP4FourOfAKind);
            if (p1FourOfAKind.getText().equals("")
                    || p1FourOfAKind.getCurrentTextColor() == Color.GRAY) {
                p1FourOfAKind.setTextColor(Color.GRAY);
                p1FourOfAKind.setText("(" + new Dice(game.diceList).isFourOfAKind() + ")");
                p1FourOfAKind.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1FourOfAKind.getCurrentTextColor() == Color.GRAY
                                && !p1FourOfAKind.getText().equals("")) {
                            game.scoreBoardList.get(3).setFourOfAKind(
                                    new Dice(game.diceList).isFourOfAKind());
                            p1FourOfAKind.setText("" + game.scoreBoardList.get(3).getFourOfAKind());
                            p1FourOfAKind.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Full = (TextView)findViewById(R.id.textViewP4Full);
            if (p1Full.getText().equals("") || p1Full.getCurrentTextColor() == Color.GRAY) {
                p1Full.setTextColor(Color.GRAY);
                p1Full.setText("(" + new Dice(game.diceList).isFullHouse() + ")");
                p1Full.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Full.getCurrentTextColor() == Color.GRAY
                                && !p1Full.getText().equals("")) {
                            game.scoreBoardList.get(3).setFullHouse(
                                    new Dice(game.diceList).isFullHouse());
                            p1Full.setText("" + game.scoreBoardList.get(3).getFullHouse());
                            p1Full.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1SmallSt = (TextView)findViewById(R.id.textViewP4SmallSt);
            if (p1SmallSt.getText().equals("") || p1SmallSt.getCurrentTextColor() == Color.GRAY) {
                p1SmallSt.setTextColor(Color.GRAY);
                p1SmallSt.setText("(" + new Dice(game.diceList).isSmallStraight() + ")");
                p1SmallSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1SmallSt.getCurrentTextColor() == Color.GRAY
                                && !p1SmallSt.getText().equals("")) {
                            game.scoreBoardList.get(3).setSmallStraight(
                                    new Dice(game.diceList).isSmallStraight());
                            p1SmallSt.setText("" + game.scoreBoardList.get(3).getSmallStright());
                            p1SmallSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1LargeSt = (TextView)findViewById(R.id.textViewP4LargeSt);
            if (p1LargeSt.getText().equals("") || p1LargeSt.getCurrentTextColor() == Color.GRAY) {
                p1LargeSt.setTextColor(Color.GRAY);
                p1LargeSt.setText("(" + new Dice(game.diceList).isLargeStraight() + ")");
                p1LargeSt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1LargeSt.getCurrentTextColor() == Color.GRAY
                                && !p1LargeSt.getText().equals("")) {
                            game.scoreBoardList.get(3).setLargeStraight(
                                    new Dice(game.diceList).isLargeStraight());
                            p1LargeSt.setText("" + game.scoreBoardList.get(3).getLargeStright());
                            p1LargeSt.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Yahtzee = (TextView)findViewById(R.id.textViewP4Yahtzee);
            if (p1Yahtzee.getText().equals("") || p1Yahtzee.getCurrentTextColor() == Color.GRAY) {
                p1Yahtzee.setTextColor(Color.GRAY);
                p1Yahtzee.setText("(" + new Dice(game.diceList).isYahtzze() + ")");
                p1Yahtzee.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Yahtzee.getCurrentTextColor() == Color.GRAY
                                && !p1Yahtzee.getText().equals("")) {
                            game.scoreBoardList.get(3).setYahtzze(
                                    new Dice(game.diceList).isYahtzze());
                            p1Yahtzee.setText("" + game.scoreBoardList.get(3).getYahtzze());
                            p1Yahtzee.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }

            final TextView p1Chance = (TextView)findViewById(R.id.textViewP4Chance);
            if (p1Chance.getText().equals("") || p1Chance.getCurrentTextColor() == Color.GRAY) {
                p1Chance.setTextColor(Color.GRAY);
                p1Chance.setText("(" + new Dice(game.diceList).isChance() + ")");
                p1Chance.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (p1Chance.getCurrentTextColor() == Color.GRAY
                                && !p1Chance.getText().equals("")) {
                            game.scoreBoardList.get(3)
                                    .setChance(new Dice(game.diceList).isChance());
                            p1Chance.setText("" + game.scoreBoardList.get(3).getChance());
                            p1Chance.setTextColor(Color.BLACK);
                            update();
                        }
                    }
                });
            }
        }
    }

    public void roll(View View) {
        deleteScoreTemp();
        game.playGameRoll();
        showDice();
        showScoreBasic();
        showScoreTemp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

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
