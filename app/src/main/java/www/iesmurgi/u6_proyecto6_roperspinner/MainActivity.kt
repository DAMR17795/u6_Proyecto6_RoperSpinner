package www.iesmurgi.u6_proyecto6_roperspinner


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
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

        btCarrito.setOnClickListener {
            val enviar = Intent (this, Carrito::class.java)
            startActivity(enviar)
        }

        //PrendasAdapter para asignar al listview
        PrendasAdapter(this, Prendas.prendasSource).also {
                adaptador -> miLista.setAdapter(adaptador)}

    }
}