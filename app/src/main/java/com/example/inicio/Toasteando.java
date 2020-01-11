package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Toasteando extends AppCompatActivity
{

    Button btnToasteando;

    EditText txtDesplaVerti;
    EditText txtDesplaHori;
    EditText txtTexto;

    int despHorizontal;
    int despVertical;
    String texto;
    int i;
    int o;

    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

    RadioGroup rg2;
    RadioButton rb4;
    RadioButton rb5;
    RadioButton rb6;

    Spinner spn;
    ArrayAdapter adaptadorDeArray;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasteando);
        setTitle("Toast");

        txtDesplaVerti = findViewById(R.id.txtVerti);
        txtDesplaHori = findViewById(R.id.txtHori);
        txtTexto = findViewById(R.id.txtTitulo);

        rg = findViewById(R.id.rGroup);
        rb1 = findViewById(R.id.rbTop);
        rb2 = findViewById(R.id.rbCenter);
        rb3 = findViewById(R.id.rbBottom);

        rg2 = findViewById(R.id.rGroup2);
        rb4 = findViewById(R.id.rbLeft);
        rb5 = findViewById(R.id.rbCentro);
        rb6 = findViewById(R.id.rbRight);

        btnToasteando = findViewById(R.id.btnToasteando);

        btnToasteando.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                despHorizontal = Integer.parseInt(txtDesplaHori.getText().toString());
                despVertical = Integer.parseInt(txtDesplaVerti.getText().toString());
                texto = txtTexto.getText().toString();

                i = eleccionAliVertical(rb1, rb2, rb3);

                o = eleccionAliHorizontal(rb4, rb5, rb6);

                Toast t1 = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG);
                t1.setGravity(i | o, despHorizontal, despVertical);

                TextView txt = (TextView) t1.getView().findViewById(android.R.id.message);
                txt.setTextColor(Color.BLACK);
                View view = t1.getView();
                view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

                t1.show();
            }
        });

    }


    public int eleccionAliVertical(RadioButton rb1, RadioButton rb2, RadioButton rb3)
    {

        if (rb1.isChecked())
        {
            i = Gravity.TOP;
        }
        else if (rb2.isChecked())
        {
            i = Gravity.CENTER;
        }
        else if (rb3.isChecked())
        {
            i = Gravity.BOTTOM;
        }

        return i;
    }


    public int eleccionAliHorizontal(RadioButton rb4, RadioButton rb5, RadioButton rb6)
    {
        if (rb4.isChecked())
        {
            o = Gravity.LEFT;
        }
        else if (rb5.isChecked())
        {
            o = Gravity.CENTER;
        }
        else if (rb6.isChecked())
        {
            o = Gravity.RIGHT;
        }

        return o;
    }
}