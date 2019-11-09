package com.example.morningmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginButton.setOnClickListener {
            //バリデーション
            if(validation()) {

                // ログイン処理
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validation(): Boolean {
        var success = true

        // メールアドレスが入力されてるか
        emailEditText.error = ""
        if(emailEditText.text.isEmpty()){
            success = false;
            emailEditText.error = "メールアドレスが入力されていません"
            print("メールアドレスが入力されていません")
        }

        //　パスワードが入力されているか
        passwordEditText.error = ""
        if(passwordEditText.text.isEmpty()){
            success = false;
            passwordEditText.error = "パスワードが入力されていません"
            print("パスワードが入力されていません")
        }

        return success
    }
}
