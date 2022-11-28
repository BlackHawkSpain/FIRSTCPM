package com.CP.First;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {

    TextView enlaceSup;//enlaceSup es la imagen de fondo de la pantalla de Login
    ImageView car;  //es el icono monocromático Situado en la parte central del Login.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        enlaceSup = findViewById(R.id.enlaceSup);
        //car= findViewById(R.id.car);
        ImageView car = findViewById(R.id.car);
        //creamos la animacion de carga para que aparezca desde un fundido.
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        car.startAnimation(myanim);
        myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        car.startAnimation(myanim);

        enlaceSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }


        });
        ImageView mGirl = findViewById(R.id.girl);
        //El glide es la librería que nos carga las imágenes desde una url.
        //para que funcione tenemos que implementarlo en el build.graddle.
        Glide.with(this).load("https://www.wsupercars.com/wallpapers-phone/Formula-1/Scuderia-Ferrari/2022-Formula1-Ferrari-F1-75-010-2400p.jpg")
                //https://www.acfligue.org/wp-content/uploads/2021/12/custom_showroom_1654840098.png
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .centerCrop()
                //.circleCrop()
                .into(mGirl);

    }
    //en el xml activitylogin , en el textview enlaceSup añadimos onclick e indicamos el nombre del metodo openSignup.
    public void openSignUp() {
        Intent intent = new Intent(this, SignupActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


        startActivity(intent);


    }
    public void iniciarMain(View v)
    {
        Intent intent = new Intent(LoginActivity.this, main.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); /*PARA QUE NO SE PUEDA IR HACIA ATRAS*/
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); /*PARA QUE NO SE PUEDA IR HACIA ATRAS*/
        startActivity(intent);
    }


}