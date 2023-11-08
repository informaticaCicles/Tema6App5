package com.example.tema6app5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.tema6app5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDefecto.setOnClickListener {
            Toast.makeText(this, "Se ha pulsado el botón", Toast.LENGTH_LONG).show()
        }

        binding.btnGravity.setOnClickListener {
            var toastGravity = Toast.makeText(this, "Toast con gravity", Toast.LENGTH_LONG)
            toastGravity.setGravity(Gravity.CENTER_HORIZONTAL, 10, 0)
            toastGravity.show()
        }

        binding.btnPersonalizado.setOnClickListener {
            var toastPersonalizado = Toast(applicationContext)

            var inflater = layoutInflater
            var layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.lytLayout))

            val txtMsg = layout.findViewById<TextView>(R.id.txtMensaje)
            txtMsg.text = "Toast de más de una línea, Este es un ejemplo de texto que puedes copiar y pegar en tu aplicación o documento. Si necesitas texto adicional,... "

            toastPersonalizado.duration = Toast.LENGTH_SHORT
            toastPersonalizado.view = layout
            toastPersonalizado.show()

        }

        binding.btnSnack.setOnClickListener {
            Snackbar.make(it, "Texto a mostrar", Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.CYAN)
                .setAction("Pulse para ejecutar", View.OnClickListener {
                    //Código a ejecutar
                }).show()
        }


    }
}