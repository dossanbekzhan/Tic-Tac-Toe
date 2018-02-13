package com.example.beka.myapplication2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_back;
    Button button_restart;
    TextView txtViewPlayer1;
    TextView txtViewPlayer2;
    private int counter;
    private boolean gameOver;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initial all view findViewById
        initfindViewById();


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.user_option_button_1_1:
                Button b_1_1 = (Button) v;
                setXorO(b_1_1);
                position = 1;
                break;
            case R.id.user_option_button_1_2:
                Button b_1_2 = (Button) v;
                setXorO(b_1_2);
                position = 2;
                break;
            case R.id.user_option_button_1_3:
                Button b_1_3 = (Button) v;
                setXorO(b_1_3);
                position = 3;
                break;
            case R.id.user_option_button_2_1:
                Button b_2_1 = (Button) v;
                position = 4;
                setXorO(b_2_1);
                break;
            case R.id.user_option_button_2_2:
                Button b_2_2 = (Button) v;
                position = 5;
                setXorO(b_2_2);
                break;
            case R.id.user_option_button_2_3:
                Button b_2_3 = (Button) v;
                position = 6;
                setXorO(b_2_3);
                break;
            case R.id.user_option_button_3_1:
                Button b_3_1 = (Button) v;
                position = 7;
                setXorO(b_3_1);
                break;
            case R.id.user_option_button_3_2:
                Button b_3_2 = (Button) v;
                setXorO(b_3_2);
                position = 8;
                break;
            case R.id.user_option_button_3_3:
                Button b_3_3 = (Button) v;
                setXorO(b_3_3);
                position = 9;
                break;

            case R.id.button_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button_restart:
                doRestart();
                break;

            case R.id.textView_player1:
                setNamePlayer(txtViewPlayer1);
                break;
            case R.id.textView_player2:
                setNamePlayer(txtViewPlayer2);
                break;

        }
        if (counter >= 5 && isGameOver(position) && !gameOver) {

            gameOver = true;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


            alertDialogBuilder.setTitle(R.string.game_over);

            String player1Name = ((TextView) findViewById(R.id.textView_player1)).getText().toString();
            String player2Name = ((TextView) findViewById(R.id.textView_player2)).getText().toString();

            if (counter % 2 == 0) {

                alertDialogBuilder
                        .setMessage(player2Name + getString(R.string.text_for_won))
                        //BAG
                        .setMessage(R.string.restart_game)
                        .setCancelable(false)
                        .setPositiveButton(R.string.text_positive, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                doRestart();
                            }
                        })
                        .setNegativeButton(R.string.text_negative, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

            } else {
                alertDialogBuilder
                        .setMessage(player1Name + getString(R.string.text_for_won))
                        .setMessage(R.string.restart_game)
                        .setCancelable(false)
                        .setPositiveButton(R.string.text_positive, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                doRestart();
                            }
                        })
                        .setNegativeButton(R.string.text_negative, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
            }


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else if (counter == 9 && !gameOver) {

            gameOver = true;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.game_over)
                    .setMessage(R.string.textDraw)
                    .setCancelable(false)
                    .setPositiveButton(R.string.text_positive, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            doRestart();
                        }
                    })
                    .setNegativeButton(R.string.text_negative, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();

            alertDialog.show();

        }
    }

    private void doRestart() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.restart)
                .setMessage(R.string.doYouWantToRestart)
                .setPositiveButton(R.string.text_OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((Button) findViewById(R.id.user_option_button_1_1)).setText("");
                        ((Button) findViewById(R.id.user_option_button_1_2)).setText("");
                        ((Button) findViewById(R.id.user_option_button_1_3)).setText("");
                        ((Button) findViewById(R.id.user_option_button_2_1)).setText("");
                        ((Button) findViewById(R.id.user_option_button_2_2)).setText("");
                        ((Button) findViewById(R.id.user_option_button_2_3)).setText("");
                        ((Button) findViewById(R.id.user_option_button_3_1)).setText("");
                        ((Button) findViewById(R.id.user_option_button_3_2)).setText("");
                        ((Button) findViewById(R.id.user_option_button_3_3)).setText("");
                        ((TextView) findViewById(R.id.textView_player1)).setText(R.string.player1);
                        ((TextView) findViewById(R.id.textView_player2)).setText(R.string.player2);
                        counter = 0;
                        gameOver = false;
                    }
                })
                .setNegativeButton(R.string.text_Cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();


    }

    public void setNamePlayer(final TextView namePlayer) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.text_enter_name);
        alertDialogBuilder.setMessage(R.string.text_enter_playerName);

        final EditText editText = new EditText(this);
        alertDialogBuilder.setView(editText);


        alertDialogBuilder.setPositiveButton(R.string.text_OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String value = editText.getText().toString();
                if (value != null && value.length() > 0) {
                    namePlayer.setText(value);
                }
            }
        });
        alertDialogBuilder.setNegativeButton(R.string.text_Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alertDialogBuilder.show();
    }

    public void setXorO(Button b) {
        if (b.getText().toString().length() == 0) {
            if (counter % 2 == 0) {
                b.setText(R.string.option_x);
            } else b.setText(R.string.option_o);
            counter++;
        }

    }

    private boolean isGameOver(int position) {

        String data11 = ((Button) findViewById(R.id.user_option_button_1_1)).getText().toString();
        String data12 = ((Button) findViewById(R.id.user_option_button_1_2)).getText().toString();
        String data13 = ((Button) findViewById(R.id.user_option_button_1_3)).getText().toString();
        String data21 = ((Button) findViewById(R.id.user_option_button_2_1)).getText().toString();
        String data22 = ((Button) findViewById(R.id.user_option_button_2_2)).getText().toString();
        String data23 = ((Button) findViewById(R.id.user_option_button_2_3)).getText().toString();
        String data31 = ((Button) findViewById(R.id.user_option_button_3_1)).getText().toString();
        String data32 = ((Button) findViewById(R.id.user_option_button_3_2)).getText().toString();
        String data33 = ((Button) findViewById(R.id.user_option_button_3_3)).getText().toString();

        switch (position) {

            case 1:
                if (data11.equals(data12) ? data11.equals(data13) : false) {
                    return true;
                }
                if (data11.equals(data21) ? data11.equals(data31) : false) {
                    return true;
                }
                if (data11.equals(data22) ? data11.equals(data33) : false) {
                    return true;
                }
                break;
            case 2:
                if (data12.equals(data11) ? data12.equals(data13) : false) {
                    return true;
                }
                if (data12.equals(data22) ? data12.equals(data32) : false) {
                    return true;
                }
                break;
            case 3:
                if (data13.equals(data11) ? data13.equals(data12) : false) {
                    return true;
                }
                if (data13.equals(data22) ? data13.equals(data31) : false) {
                    return true;
                }
                if (data13.equals(data23) ? data13.equals(data33) : false) {
                    return true;
                }
                break;
            case 4:
                if (data21.equals(data11) ? data21.equals(data31) : false) {
                    return true;
                }
                if (data21.equals(data22) ? data21.equals(data23) : false) {
                    return true;
                }
                break;
            case 5:
                if (data22.equals(data12) ? data22.equals(data32) : false) {
                    return true;
                }
                if (data22.equals(data21) ? data22.equals(data23) : false) {
                    return true;
                }
                if (data22.equals(data11) ? data22.equals(data33) : false) {
                    return true;
                }
                if (data22.equals(data13) ? data22.equals(data31) : false) {
                    return true;
                }
                break;
            case 6:
                if (data23.equals(data13) ? data23.equals(data33) : false) {
                    return true;
                }
                if (data23.equals(data21) ? data23.equals(data22) : false) {
                    return true;
                }
                break;
            case 7:
                if (data31.equals(data11) ? data31.equals(data21) : false) {
                    return true;
                }
                if (data31.equals(data32) ? data31.equals(data33) : false) {
                    return true;
                }
                if (data31.equals(data22) ? data31.equals(data13) : false) {
                    return true;
                }
                break;
            case 8:
                if (data32.equals(data12) ? data32.equals(data22) : false) {
                    return true;
                }
                if (data32.equals(data31) ? data32.equals(data33) : false) {
                    return true;
                }
                break;
            case 9:
                if (data33.equals(data11) ? data33.equals(data22) : false) {
                    return true;
                }
                if (data33.equals(data13) ? data33.equals(data23) : false) {
                    return true;
                }
                if (data33.equals(data31) ? data33.equals(data32) : false) {
                    return true;
                }
                break;
        }
        return false;
    }


    private void initfindViewById() {
        View user11Button = findViewById(R.id.user_option_button_1_1);
        user11Button.setOnClickListener(this);
        View user12Button = findViewById(R.id.user_option_button_1_2);
        user12Button.setOnClickListener(this);
        View user13Button = findViewById(R.id.user_option_button_1_3);
        user13Button.setOnClickListener(this);
        View user21Button = findViewById(R.id.user_option_button_2_1);
        user21Button.setOnClickListener(this);
        View user22Button = findViewById(R.id.user_option_button_2_2);
        user22Button.setOnClickListener(this);
        View user23Button = findViewById(R.id.user_option_button_2_3);
        user23Button.setOnClickListener(this);
        View user31Button = findViewById(R.id.user_option_button_3_1);
        user31Button.setOnClickListener(this);
        View user32Button = findViewById(R.id.user_option_button_3_2);
        user32Button.setOnClickListener(this);
        View user33Button = findViewById(R.id.user_option_button_3_3);
        user33Button.setOnClickListener(this);


        button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(this);
        button_restart = findViewById(R.id.button_restart);
        button_restart.setOnClickListener(this);

        txtViewPlayer1 = findViewById(R.id.textView_player1);
        txtViewPlayer1.setOnClickListener(this);
        txtViewPlayer2 = findViewById(R.id.textView_player2);
        txtViewPlayer2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.game_menu, menu);
        return true;
    }
}