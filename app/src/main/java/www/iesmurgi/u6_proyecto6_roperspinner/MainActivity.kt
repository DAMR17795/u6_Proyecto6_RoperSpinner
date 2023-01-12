package www.iesmurgi.u6_proyecto6_roperspinner


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var miLista: ListView
    private lateinit var btCarrito:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Asigno variable miLista
        miLista = binding.miLista

        btCarrito = binding.btVerCarrito

        //Boton ver carrito click
        btCarrito.setOnClickListener {
            var variable=0
            for (i in Prendas.prendasSource) {
                if (i.cantidad != 0) {
                    variable++
                }
            }
            if (variable != 0) {
                val enviar = Intent (this, Carrito::class.java)
                startActivity(enviar)
            } else {
                Toast.makeText(this, "Cesta Vacía", Toast.LENGTH_SHORT).show()
            }
        }

        //PrendasAdapter para asignar al listview
        PrendasAdapter(this, Prendas.prendasSource).also {
                adaptador -> miLista.setAdapter(adaptador)}

    }


}