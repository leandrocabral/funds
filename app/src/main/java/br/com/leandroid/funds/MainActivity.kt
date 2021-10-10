package br.com.leandroid.funds

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import br.com.leandroid.funds.presentation.funds.FundsActivity

class MainActivity : AppCompatActivity() {

    lateinit var rotateAnimation: Animation
    private val splashScreenLogo by lazy<ImageView> { findViewById(R.id.logo) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rotateAnimation()
        closeSplashScreen()
    }

    private fun rotateAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        splashScreenLogo.startAnimation(rotateAnimation)
    }

    private fun closeSplashScreen() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, FundsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}