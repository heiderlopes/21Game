package br.com.heiderlopes.a21game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView


class SplashActivity : AppCompatActivity() {

    //Tempo que nosso splashscreen ficará visivel
    private val SPLASH_DISPLAY_LENGTH = 3500L

    lateinit var ivLogo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ivLogo = findViewById(R.id.ivLogo)
        carregar()
    }

    fun carregar() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()

        ivLogo!!.clearAnimation()
        ivLogo!!.startAnimation(anim)

        Handler().postDelayed({
            // Após o tempo definido irá executar a próxima tela
            val intent = Intent(this@SplashActivity,
                    MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}
