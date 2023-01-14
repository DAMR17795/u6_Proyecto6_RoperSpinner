package www.iesmurgi.u6_proyecto6_roperspinner

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.CarritoBinding

class Carrito : AppCompatActivity() {
    private lateinit var binding:CarritoBinding
    private lateinit var lista:ListView
    private lateinit var resultado:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lista = binding.miListaCarrito
        resultado = binding.precioFinal
        //cargar()
        var precioF =0.0
        for (i in Prendas.prendasCogidas) {
            /*if (i.talla == "XS") {
                precioF += (i.cantidad * (i.precio-1))
            } else if (i.talla == "S") {
                precioF += (i.cantidad * i.precio)
            } else if (i.talla == "M") {
                precioF += (i.cantidad * (i.precio+1))
            } else if (i.talla == "L") {
                precioF += (i.cantidad * (i.precio+2))
            } else if (i.talla == "XL") {
                precioF += (i.cantidad * (i.precio+3))
            }*/
            precioF += (i.cantidad * i.precio)
        }
        resultado.setText(getString(R.string.precioTotal) + " "+ precioF.toFloat().toString() + " €")
        CarritoAdapter(this, Prendas.prendasCogidas).also {
                adaptador -> lista.setAdapter(adaptador)}

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}