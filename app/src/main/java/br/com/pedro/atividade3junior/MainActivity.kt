package br.com.pedro.atividade3junior

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

private lateinit var btnLogin:Button
lateinit var editUsername: TextView
private lateinit var editPassword: TextView
private lateinit var textView: TextView

//private val username:String = editUsername.text.toString()

//    fun get(): String{
//        return username
//    }

fun getName(name:String):String{
    return name.toString()
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin = findViewById(R.id.btn_login)
        editUsername = findViewById(R.id.edit_username)
        editPassword = findViewById(R.id.edit_password)
        textView = findViewById(R.id.view_test)

        editUsername.text = "Pedro"
        editPassword.text = "123"


    }
    public fun onClickLogin(view: View){
        if(editUsername.text.toString() == "Pedro" && editPassword.text.toString() == ("123")){
            textView.text = "LOGADO COM SUCESSO"
            enterHelloActivity()
            val intent = Intent(this,Hello::class.java)
            intent.putExtra("USERNAME_KEY",editUsername.text.toString())
            startActivity(intent)

        }else{
            loginErrorDialog()
        }
    }


   private fun loginErrorDialog(){
        var alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Login Falhou :(")
        alertDialogBuilder.setMessage("Usuário ou senha invalido")

        alertDialogBuilder.setPositiveButton("Ok"){dialog,id ->
        editUsername.setText("")
            editPassword.setText("")
        }

        val dialog = alertDialogBuilder.create()
        dialog.show()
    }

    private fun enterHelloActivity(){
        val secondActivity = Intent(this,Hello::class.java)
        startActivity(secondActivity)
    }

}