package com.example.pipe.appventapromociones;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class ActivityPromocionesCompra extends AppCompatActivity{
    MediaPlayer mp;

    public void repoducirSonido()
    {
        if(mp!= null)
        {
            mp.stop();
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(this, R.raw.cerveza2);
        mp.start();
    }
    private void OnClickBtn1() {
        repoducirSonido();
    }
    private void OnClickBtn2() {
        repoducirSonido();
    }
    private void OnClickBtn3() {
        repoducirSonido();
    }

    private void OnClickBtn4() {
        if(mp!= null)
        {
            mp.stop();
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(this, R.raw.cerveza1);
        mp.start();
    }

    private void MensajeCompra()
    {
        Toast toast = Toast.makeText(this,"enviando Solicitud",Toast.LENGTH_SHORT);
        toast.show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_promociones_compra);

        Button btnPromo1 = (Button) findViewById(R.id.btnPromo1);
        Button btnPromo2 = (Button) findViewById(R.id.btnPromo2);
        Button btnPromo3 = (Button) findViewById(R.id.btnPromo3);
        Button btnComprar = (Button)findViewById(R.id.btnComprar);

        btnPromo1.setOnClickListener(new View.OnClickListener() {


            //@Override
            public void onClick(View v) {
                OnClickBtn1();
                Intent intent = new Intent(ActivityPromocionesCompra.this, ActivityPromo1.class);
                startActivity(intent);
            }


        });
        btnPromo2.setOnClickListener(new View.OnClickListener() {

            //@Override
            public void onClick(View v) {
                OnClickBtn2();
                Intent intent = new Intent(ActivityPromocionesCompra.this, ActivityPromo2.class);
                startActivity(intent);
            }
        });
        btnPromo3.setOnClickListener(new View.OnClickListener() {

            //@Override
            public void onClick(View v) {
                OnClickBtn3();
                Intent intent = new Intent(ActivityPromocionesCompra.this, ActivityPromo3.class);
                startActivity(intent);
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {

            //@Override
            public void onClick(View v) {
                EditText edTxtCelular = (EditText) findViewById(R.id.edTxtCelular),
                        edTxtNombre = (EditText) findViewById(R.id.edTxtNombre),
                        edTxtDireccion = (EditText) findViewById(R.id.edTxtDireccion),
                        edTxtPromo = (EditText) findViewById(R.id.edTxtPromo);

                String strCelular = edTxtCelular.getText().toString(),
                        strNombre = edTxtNombre.getText().toString(),
                        strDireccion = edTxtDireccion.getText().toString(),
                        strPromo = edTxtPromo.getText().toString()
                ;

                if(TextUtils.isEmpty(strCelular) || TextUtils.isEmpty(strDireccion) || TextUtils.isEmpty(strNombre) ||
                    TextUtils.isEmpty(strPromo))
                {
                    if(TextUtils.isEmpty(strCelular))
                    {
                        edTxtCelular.setError("No puede quedar en Blanco");
                    }
                    if(TextUtils.isEmpty(strDireccion))
                    {
                        edTxtDireccion.setError("No puede quedar en Blanco");
                    }
                    if(TextUtils.isEmpty(strNombre))
                    {
                        edTxtNombre.setError("No puede quedar en Blanco");
                    }
                    if(TextUtils.isEmpty(strPromo))
                    {
                        edTxtPromo.setError("No puede quedar en Blanco");
                    }
                    return;
                }

                else {
                    MensajeCompra();
                    OnClickBtn4();
                    Intent intent = new Intent(ActivityPromocionesCompra.this, ActivityCompraRealizada.class);
                    startActivity(intent);
                }
                }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_promociones_compra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        EditText txtDireccion = (EditText) findViewById(R.id.edTxtDireccion);





        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
