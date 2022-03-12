package com.mustafaoguzbaran.kotlinstoringdataapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mustafaoguzbaran.kotlinstoringdataapp.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {
 lateinit var sharedPreferences: SharedPreferences
var nameFromDatabase : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
        //SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.mustafaoguzbaran.kotlinstoringdataapp", MODE_PRIVATE)
         nameFromDatabase = sharedPreferences.getString("name", "Your Name")
        if (nameFromDatabase == "Your Name"){
            textView.text = "Your Name"
        }else{
            textView.text = "My Name is ${nameFromDatabase}"
        }
    }
    fun push(view: View){
        //Shared Preferences

        var myName = editText.text.toString()
        if (myName == ""){
            textView.text = "Error"
            }else{
                textView.text = "My Name is ${myName}"
            sharedPreferences.edit().putString("name",myName).apply()
            }
    }
    fun delete(view: View) {
        nameFromDatabase = sharedPreferences.getString("name", "Your Name")
        if(nameFromDatabase != "Your Name"){
            sharedPreferences.edit().remove("name").apply()
            textView.text = "Your Name"
        }
    }
}