package www.iesmurgi.u6_proyecto6_roperspinner

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.CarritoBinding

class Carrito : AppCompatActivity() {
    private lateinit var binding:CarritoBinding
    private lateinit var lista:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = binding.miListaCarrito

        CarritoAdapter(this, Prendas.prendasSource).also {
                adaptador -> lista.setAdapter(adaptador)}
    }
}