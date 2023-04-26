package com.example.pr18

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    public var twoname = "name"
    public var twopass = ""
    lateinit var pref: SharedPreferences
    lateinit var login: EditText
    lateinit var pass: EditText
    lateinit var text: TextView
    lateinit var button: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        login = findViewById(R.id.edit1)
        pass = findViewById(R.id.edit2)
        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)
        button2 = findViewById(R.id.button2)
        button.setOnClickListener {
            if (login.toString().length == 0 || pass.toString().length == 0) {
                Toast.makeText(this,"Пустые поля",Toast.LENGTH_SHORT).show()
            } else {
                var name = login.getText().toString()
                var passe= pass.getText().toString()
                var save = pref.edit()
                save.putString(twoname, name)
                save.putString(twopass, passe)
                save.apply()
                val intent = Intent(this@MainActivity2, MainActivity3::class.java)
                startActivity(intent)
            }
        }
        button2.setOnClickListener {
            pref = getPreferences(MODE_PRIVATE)
            var passes = pref.getString(twopass, "не определено")
            var names = pref.getString(twoname, "не определено")
            if (passes.toString() == "" || names.toString() == "") {
                Toast.makeText(this,"Сохранённые данные отсутсвуют",Toast.LENGTH_SHORT).show()
            } else {
                login.setText(names)
                pass.setText(passes)
            }
        }
    }
}