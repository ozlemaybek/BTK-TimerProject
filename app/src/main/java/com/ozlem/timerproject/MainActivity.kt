package com.ozlem.timerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
// MainActivity ve XML arasındaki senkronizasyonu sağlamak için:
import kotlinx.android.synthetic.main.activity_main.*

// Bu projede bir sayaç yapacağız

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Süslü parantez açtığımızda object'te hata verecek.
        // Alt+Enter yaptığımızda "Implements member" seçeneğini seç.
        // Böylece zorunlu olan fonksiyonları ekleyeceğiz.
        object : CountDownTimer(15000,1000){

            // Bu fonksiyonda; sayaç bir geri geldiğinde ne yapılacağını yazarız.
            // Bizim ayarlarımıza göre bu fonksiyon bir sn'de bir çalıştırılacak:
            // millisUntilFinished: geriye kaç sn kaldığı
            override fun onTick(millisUntilFinished: Long) {
                textViewID.text = "Remaining: ${millisUntilFinished / 1000}"
            }

            // Sayaç bittiğinde ne olacak:
            override fun onFinish() {
                textViewID.text = "Remaining: 0"
            }
        //objenin bittiği yere start() diyoruz böylece zamanlayıcı başlatılıyor:
        }.start()
    }
}