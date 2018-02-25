package edu.rvc.student.week7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        txtMessage.requestFocus()

        btnSubmit.setOnClickListener{
            Toast.makeText(this,"The message is: ${txtMessage.text.toString()}", Toast.LENGTH_LONG) .show()

            hideKeyboard()

            txtMessage.setText("")
            txtMessage.requestFocus()
        }
    }

    fun hideKeyboard() {
        try {val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e:Exception) {
            // TODO: exceptions
        }

    }
}
