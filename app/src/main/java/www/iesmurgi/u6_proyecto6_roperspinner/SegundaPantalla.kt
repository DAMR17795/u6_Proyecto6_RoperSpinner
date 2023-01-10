package www.iesmurgi.u6_proyecto6_roperspinner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.PantallaSegundaBinding

class SegundaPantalla: AppCompatActivity() {
    private lateinit var binding: PantallaSegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PantallaSegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Muestra el item de listView
        mostrar()

        //Variables y constantes para los métodos de los botones
        var contador = 1
        val bundle = intent.extras
        var precioActual = bundle?.getDouble("PRECIO")

        //Boton al botonMenos para quitar cantidad
        binding.botonMenos.setOnClickListener{
            if (precioActual != null) {
                if (contador >1) {
                    contador -=1
                    binding.cantidadAtuendo.setText(contador.toString())
                    var precio = precioActual * contador
                    binding.precioAtuendo.setText(getString(R.string.precio) + " " + precio.toFloat().toString() + " €")

                }
            }
        }

        //Metodo al botonMas para añadir cantidad
        binding.botonMas.setOnClickListener{
            if (precioActual != null) {
                contador +=1
                binding.cantidadAtuendo.setText(contador.toString())
                var precio = precioActual * contador
                binding.precioAtuendo.setText(getString(R.string.precio) + " " + precio.toFloat().toString() + " €")
            }
        }
    }


    fun mostrar() {
        //Constantes binding-xml
        val nombreAtuendo = binding.nombreAtuendo
        val descripcionAtuendo = binding.descripcionAtuendo
        val imagenAtuendo = binding.imagenAtuendo
        val talla = binding.tallaAtuendo
        val precioPrenda = binding.precioAtuendo
        val cantidad = binding.cantidadAtuendo

        //Recogida del intent
        val mibundle=intent.extras
        val nombre = mibundle?.getString("NOMBRE")
        val imagen = mibundle?.getInt("IMAGEN")
        val descripcion = mibundle?.getString("DESCRIPCION")
        val tamanio = mibundle?.getString("TALLA")
        val precio = mibundle?.getDouble("PRECIO")

        //Establecemos los valores en el xml
        nombreAtuendo.setText(nombre)
        descripcionAtuendo.setText(getString(R.string.descripcion) + " " + descripcion)
        imagen?.let { imagenAtuendo.setImageResource(it) }
        talla.setText(getString(R.string.talla) + " " + tamanio)
        precioPrenda.setText(getString(R.string.precio) + " " + precio.toString() + " €")
        cantidad.setText("1")
    }



}