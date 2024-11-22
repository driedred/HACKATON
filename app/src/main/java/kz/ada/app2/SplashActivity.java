package kz.ada.app2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Задержка 2 секунды перед переходом на экран регистрации
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Переход на экран регистрации
                Intent intent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();  // Закрыть текущую активность (SplashScreen)
            }
        }, 2000); // 2 секунды
    }
}


