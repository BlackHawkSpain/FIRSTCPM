package com.CP.First;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class main extends AppCompatActivity {
    WebView miVisorWeb;
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TextView myContext = (TextView) findViewById(R.id.vista);
        //registerForContextMenu(myContext);

        /*Hacemos un casting de la vista web y la registramos*/
        WebView myContext = (WebView) findViewById(R.id.vista);
        registerForContextMenu(myContext);

        //La vista dentro es un webview con permiso para zoom
        miVisorWeb = (WebView) findViewById(R.id.vista);
        //  miVisorWeb.getSettings().setJavaScriptEnabled(true);
        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");

        // DENTRO del Oncreate
        // cast al Layout SwipeRefresh con el que rodeamos la vista
        // en el xml y le colocamos un listener
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.mySwipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


    }

    /*dialogo modal*/


    /*Swipe refresh al deslizar hacia abajo carga de nuevo la pagina y nos muestra una nueva cara de la web
     * thispersondoesnotexist, y un mensaje por pantalla que dice: Hi there, i dont exist.*/
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            /*toast que muestra un mensaje en pantalla cuando refrescamos*/
            Toast toast0 = Toast.makeText(main.this, "Hi there, I don´t exist", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    /*-------------------------------------------------*/

    /*El builder serán las acciones que realicemos al pulsar sobre el boton de signout*/
    public void showAlertDialogButtonClicked(main mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo
//        //por un XML a medida
        builder.setTitle("Por que tan rápido");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.ic_f1_car_svgrepo_com);
        builder.setCancelable(false);

//        // un XML a medida para el diálogo
//        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Signout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(main.this, LoginActivity.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("Stay Here", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                dialog.dismiss();
                System.exit(0);

            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            if (id == R.id.item2) {
//            showAlertDialogButtonClicked(Main.this);

                Toast toast8 = Toast.makeText(this, "Settings", Toast.LENGTH_LONG);
                toast8.show();

            }
            if (id == R.id.item1) {
                /*muestra buscar al pulsar sobre el boton*/
                Toast toast9 = Toast.makeText(this, "Search", Toast.LENGTH_LONG);
                toast9.show();
            }

            if (id == R.id.item3) {
                /*nos lleva al login activity al puslsar sobre el boton*/
                Intent intent = new Intent(main.this, LoginActivity.class);
                startActivity(intent);
            }

            if (id == R.id.item4) {
                /*nos lleva al login activity al puslsar sobre el boton*/
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }

            if (id == R.id.item5) {

                showAlertDialogButtonClicked(main.this);
            }

            return super.onOptionsItemSelected(item);
        }
        /*----------------------------------------------------*/






        /*Con el context menu, al realizar una pulsación larga nos permite realizar varias acciones que previamente hemos
         * creado en el xml menu_context*/
        @Override
        public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo
        menuInfo){
            getMenuInflater().inflate(R.menu.menu_context, menu);


        }
        /*Con el options menu, nos aparecerá la barra de menu de la parte superior donde
         * encontramos las opciones definidas en el xml menu_appbar.*/
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_appbar, menu);
            return true;

        }

        @Override
        public boolean onContextItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.item1:
                    /*El toast nos muestra en pantalla un mensaje momentaneo cuando
                     *realizamos la acción(en este caso pulsar en copiar)*/

//                Toast toast = Toast.makeText(this, "Item copied",
//                        Toast.LENGTH_LONG);
//                toast.show();

                    final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

                    Snackbar snackbar = Snackbar
                            .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                    snackbar1.show();
                                    System.exit(0);
                                }
                            });

                    snackbar.show();

                    return true;

                case R.id.item2:
                    Toast toast2 = Toast.makeText(this, "Downloading item...",
                            Toast.LENGTH_LONG);
                    toast2.show();
                    return true;

                default:
//                return super.onContextItemSelected(item);
                    return false;
            }

        }


    }
