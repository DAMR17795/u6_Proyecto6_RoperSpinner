package www.iesmurgi.u6_proyecto6_roperspinner

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.PantallaSegundaBinding

class SegundaPantalla: AppCompatActivity() {
    private lateinit var binding: PantallaSegundaBinding
    private lateinit var btCompra: Button
    private lateinit var nombrePrenda:TextView
    private lateinit var cantidadCarrito:TextView
    private lateinit var precioCarrito:TextView
    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PantallaSegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Boton Carrito
        btCompra = binding.btCarrito
        nombrePrenda = binding.nombreAtuendo
        cantidadCarrito = binding.cantidadAtuendo
        precioCarrito = binding.precioAtuendo

        //Muestra el item de listView
        mostrar()

        //Variables y constantes para los métodos de los botones
        var contador = 1
        val bundle = intent.extras
        var precioActual = bundle?.getDouble("PRECIO")

        //Metodo al botonMenos para quitar cantidad
        binding.botonMenos.setOnClickListener{
            if (precioActual != null) {
                if (contador > 1) {
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

        //Metodo para añadir a la cesta
        btCompra.setOnClickListener {
            actualizarTallaArray()
            actualizarCantidadArray(cantidadCarrito.text.toString().toInt())
            cargar()
            Toast.makeText(this, getString(R.string.aniadido), Toast.LENGTH_SHORT).show()
            //Prendas.prendasCogidas.clear()
            println("*******************ARRAY PRENDAS SOURCE*********************")
            for (i in Prendas.prendasSource){
                println("ID: " + i.id + ", Cantidad: " + i.cantidad + ", Talla:" + i.talla)
            }
        }
    }


    private fun actualizarCantidadArray(cantidad:Int){
        val mibundle=intent.extras
        val tamanio = mibundle?.getString("TALLA")
        Prendas.prendasSource.filter { it.id == id.toString().toInt() && it.talla == tamanio.toString()}.forEach { it.cantidad += cantidad}
    }

    private fun actualizarTallaArray(){
        val mibundle=intent.extras
        val tamanio = mibundle?.getString("TALLA")
        Prendas.prendasSource.filter { it.id == id.toString().toInt()}.forEach { it.talla =
            tamanio.toString()
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
        id = mibundle?.getInt("ID").toString()

        //Establecemos los valores en el xml
        nombreAtuendo.setText(nombre)
        descripcionAtuendo.setText(getString(R.string.descripcion) + " " + descripcion)
        imagen?.let { imagenAtuendo.setImageResource(it) }
        talla.setText(getString(R.string.talla) + " " + tamanio)
        precioPrenda.setText(getString(R.string.precio) + " " + precio.toString() + " €")
        cantidad.setText("1")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val mibundle=intent.extras
        val tamanio = mibundle?.getString("TALLA")
        Prendas.prendasSource.filter { it.id == id.toString().toInt() && it.talla == tamanio.toString()}.forEach { it.cantidad = 0}
        finish()
    }

    fun cargar() {
        //Bucle for y añadimos a la lista vacia
        //las prendas que tengan cantidad mayor a 0
        var contador = 0
        var contador2 = 0

        var prendasActualizadas= mutableListOf<Prendas>()
        var prendasAniadidas = mutableListOf<Prendas>()
        println("*********************AL EMPEZAR*******************")
        println("Prendas dentro array Cogidas: " + Prendas.prendasCogidas.size)
        for (i in Prendas.prendasCogidas) {
            println("Prenda en  array cogidas: " + i.descripcion + ", Talla: " + i.talla + ", Cantidad: " + i.cantidad)
        }
        println("Prendas dentro array Finales: " + Prendas.prendasFinales.size)
        for (i in Prendas.prendasFinales) {
            println("Prenda en  array finales: " + i.descripcion + ", Talla: " + i.talla + ", Cantidad: " + i.cantidad)
        }
        for (i in Prendas.prendasSource) {
            if(i.cantidad != 0) {
                var prenda: Prendas=Prendas(i.id, i.nombre, i.numPrenda,i.descripcion, i.imagen, i.precio,i.cantidad, i.talla)
                if (i.talla == "XS") {
                    prenda.precio = prenda.precio -1
                } else if (i.talla == "M") {
                    prenda.precio = prenda.precio + 1
                }  else if (i.talla == "L") {
                    prenda.precio = prenda.precio + 2
                }  else if (i.talla == "XL") {
                    prenda.precio = prenda.precio + 3
                }
                Prendas.prendasCogidas.add(prenda)
                Prendas.prendasFinales.add(prenda)
                /*if (Prendas.prendasCogidas.size > 0 && Prendas.prendasCogidas.contains(prenda)) {
                    Prendas.prendasCogidas.removeAt(contador)
                }*/
                /*if (Prendas.prendasCogidas.size > 0 && Prendas.prendasFinales.size > 0) {
                    for (c in Prendas.prendasCogidas) {
                        if (!Prendas.prendasFinales.contains(c)) {
                            Prendas.prendasFinales.add(c)
                            }
                    }

                }*/
                //prendasAniadidas.add(Prendas.prendasCogidas.get(contador))
                //prendasAniadidas.add(prenda)
                contador++
            }

            for (j in Prendas.prendasFinales) {
                if (i.id == j.id && i.cantidad != j.cantidad && i.talla == j.talla) {
                    println("*********************Dentro de IF*******************")
                    println("Tamaño array cogidas: " + Prendas.prendasCogidas.size)
                    println("Tamaño array finales: " + Prendas.prendasFinales.size)
                    //prendasActualizadas.add(Prendas.prendasCogidas.get(contador2))
                    //prendasActualizadas.add(i)
                    //Prendas.prendasCogidas.get(contador2).cantidad = i.cantidad

                    //prendasAniadidas.removeAt(contador2)
                    //Prendas.prendasCogidas.removeAt(contador2)
                    Prendas.prendasFinales.removeAt(contador2)
                    contador2++
                }/* else if (i.id == j.id && i.cantidad == j.cantidad && i.talla == j.talla) {
                    prendasActualizadas.add(i)
                    contador2++
                }  else if (i.id == j.id && i.cantidad == j.cantidad && i.talla == j.talla) {
                    //prendasActualizadas.add(i)
                    contador2++
                }*/
                contador2++
            }
            contador2=0
        }
        println("*********************Al ACABAR EL BUCLE*******************")
        println("Tamaño array cogidas: " + Prendas.prendasCogidas.size)
        println("Tamaño array Finales: " + Prendas.prendasFinales.size)

        contador=0


        /*for (i in prendasAniadidas) {
            if (prendasActualizadas.contains(prendasAniadidas.get(contador))) {
                prendasAniadidas.removeAt(contador)
                contador++
            }
        }*/

        println("************************FIN******************************")
        println("Prendas dentro array Cogidas: " + Prendas.prendasCogidas.size)
        for (i in Prendas.prendasCogidas) {
            println("Prenda en  array cogidas: " + i.descripcion + ", Talla: " + i.talla + ", Cantidad: " + i.cantidad + " ,Precio: " + i.precio)
        }
        println("Prendas dentro array Finales: " + Prendas.prendasFinales.size)
        for (i in Prendas.prendasFinales) {
            println("Prenda en  array finales: " + i.descripcion + ", Talla: " + i.talla + ", Cantidad: " + i.cantidad + " ,Precio: " + i.precio)
        }

        Prendas.prendasCogidas.clear()
        //Prendas.prendasCogidas.addAll(prendasAniadidas)
        Prendas.prendasCogidas.addAll(Prendas.prendasFinales)
        Prendas.prendasFinales.clear()


        //prendasAniadidas.clear()
        println("*********************AL BORRAR*******************")
        println("Tamaño array cogidas: " + Prendas.prendasCogidas.size)
        println("Tamaño array Finales: " + Prendas.prendasFinales.size)


        //prendasActualizadas.clear()
        //prendasAniadidas.clear()

    }

    //Options menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menucarrito, menu)
        return true
    }

    //Options item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Op -> {
                var variable=0
                for (i in Prendas.prendasCogidas) {
                    if (i.cantidad != 0) {
                        variable++
                    }
                }
                if (variable != 0) {
                    val enviar = Intent (this, Carrito::class.java)
                    startActivity(enviar)
                } else {
                    Toast.makeText(this, getString(R.string.carrito), Toast.LENGTH_SHORT).show()
                }
                true
            }
            R.id.MnOp1 -> {
                Toast.makeText(this, getString(R.string.creacion), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}