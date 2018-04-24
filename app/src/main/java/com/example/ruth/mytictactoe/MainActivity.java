package com.example.ruth.mytictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView winnerMessage;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winnerMessage =(TextView)findViewById(R.id.winnerMessage);
    }
    byte[][] xo = new byte[3][3];
    Boolean isX = true;
    int click= 0;
    public void clicked(View v) {
        Button btn = (Button) v;
        click++;
        if (btn.getText() != "") return;
        if (isX)
            btn.setText("X");
        else
            btn.setText("O");


        String[] index = v.getTag().toString().split(",");

        xo[Integer.parseInt(index[0])][Integer.parseInt(index[1])] = (byte) (isX ? 1 : 2);

        hasWon(v);
        if (click>8){
            click =0;
        }
        isX = !isX;

    }

    private void hasWon(View v) {
        for(int i=0;i<3;i++) {
            if (xo[i][0] == xo[i][1] && xo[i][1] == xo[i][2] && xo[i][0]!=0) {
                winnerFunction();
                break;

            } else if (xo[0][i] == xo[1][i] && xo[1][i] == xo[2][i] && xo[0][i]!=0) {
                winnerFunction();
                break;
            }
        }
        if(xo[0][0] == xo[1][1] && xo[1][1] == xo[2][2] && xo[1][1]!=0){
            winnerFunction();

        }
        if(xo[0][2] == xo[1][1] && xo[1][1] == xo[2][0] && xo[0][2]!=0){
            winnerFunction();

        }
    }
    public void winnerFunction() {
        String winner="O ";
        if(isX)
            winner="X ";
            winnerMessage.setText(winner + "- is the winner"+"");
            winnerMessage.setVisibility(View.VISIBLE);



    }

    public void newGame(View view){
        int [] arr = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
        for ( int i=0;i<arr.length;i++) {
            Button btn = (Button) findViewById(arr[i]);
            btn.setText("");
            click = 0;
        }
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                xo[i][j]=0;
        isX =true;
        winnerMessage.setVisibility(View.INVISIBLE);
    }

}
