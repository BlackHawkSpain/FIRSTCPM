package com.CP.First;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.CP.First.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class Splash extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();


        //implements and starts animation
        // objeto thunder sobre el cual aplicaremos la animación
       // ImageView thunder = findViewById(R.id.logosplash);

        //creamos un objeto animación que incorpora la animación descrita en el xml y con el método
        // startAnimation lo aplicamos al imageview del logo

       ImageView thunder = findViewById(R.id.logosplash);

       //creamos un objeto animación que incorpora la animación descrita en el xml y con el método
       // startAnimation lo aplicamos al imageview del logo
       Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
       thunder.startAnimation(myanim);


       //    Glide for loading girls
       ImageView mSea = findViewById(R.id.backView);
      // ImageView mGirl = findViewById(R.id.girl);
       Glide.with(this).load("")
               //https://www.acfligue.org/wp-content/uploads/2021/12/custom_showroom_1654840098.png
               .transition(DrawableTransitionOptions.withCrossFade(1000))
               .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
               .centerCrop()
               //.circleCrop()
               .into(mSea);

    }

    private void openApp() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//hace que no podamos ir hacia atrás en el signup Activity
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //hace que no podamos ir hacia atrás en el signup Activity
                startActivity(intent);



            }
        }, 5000);


    }

}