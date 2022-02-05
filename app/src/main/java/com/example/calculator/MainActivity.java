package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    /*
        Hello there, I am Prodipto Roy Dipto. I am the developer of this app.:)
        Email: diptoprodipto@gmail.com
    */

    TextView edt1,edt2;
    String process,finalResult, check;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDivision, buttonEqual, buttonDel,buttonClear,buttonAns, buttonDot, buttonPercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonPercent = (Button) findViewById(R.id.Remainder);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonEqual = (Button) findViewById(R.id.buttonEql);
        buttonClear = findViewById(R.id.buttonClear);
        buttonAns = findViewById(R.id.buttonAns);

        edt1 = (TextView) findViewById(R.id.calculationId);
        edt2 = (TextView) findViewById(R.id.answerId);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "-");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "x");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "/");
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();
                edt1.setText(process + "%");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = edt1.getText().toString();

                if(process!="") {

                    process = process.replaceAll("x", "*");
                    process = process.replaceAll("%", "/100");

                    Context rhino = Context.enter();

                    rhino.setOptimizationLevel(-1);

                    finalResult = "";

                    try {
                        Scriptable scriptable = rhino.initStandardObjects();
                        finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();

                    } catch (Exception e) {
                        finalResult = "0";
                    }

                    edt2.setText(finalResult);
                }
                else
                {
                    edt2.setText("0");
                }

            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String str;
                    str = edt1.getText().toString();
                    str = str.substring(0,str.length()-1);
                    edt1.setText(str);
                }
                catch (Exception e){

                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
            }
        });

        buttonAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = edt1.getText().toString();

                if(finalResult==null)
                {
                    if(check=="")
                    {
                        edt1.setText("");
                    }
                    else
                    {
                        edt1.setText(check);
                    }

                }
                else {

                    process = edt1.getText().toString();

                    if (process != null)
                    {

                        edt1.setText(process + finalResult);
                    }
                    else
                    {
                        edt1.setText(finalResult + "");

                    }
                }

            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process = edt1.getText().toString();
                edt1.setText(process + ".");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.aboutMenuId)
        {
            Intent i = new Intent(MainActivity.this,About.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
