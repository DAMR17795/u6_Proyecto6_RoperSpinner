package www.iesmurgi.u6_proyecto6_roperspinner

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get


class PrendasAdapter (context: Context, prendas:List<Prendas>):ArrayAdapter<Prendas>(context, 0, prendas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vista = convertView?: LayoutInflater.from(context).inflate(R.layout.esqueleto, parent, false)
        getItem(position)?.let { armario ->
            vista.findViewById<TextView>(R.id.nombrePrenda).apply {
                text= armario.nombre

                if (text.equals("Camiseta")) {
                    text = context.resources.getString(R.string.camiseta) + armario.numPrenda
                }

                if (text.equals("Gorra")) {
                    text = context.resources.getString(R.string.gorra) + armario.numPrenda
                }

                if (text.equals("Sudadera")) {
                    text = context.resources.getString(R.string.sudadera) + armario.numPrenda
                }

                if (text.equals("Pantalon")) {
                    text = context.resources.getString(R.string.pantalon) + armario.numPrenda
                }

                if (text.equals("Calcetin")) {
                    text = context.resources.getString(R.string.calcetin) + armario.numPrenda
                }

                if (text.equals("Vestido")) {
                    text = context.resources.getString(R.string.vestido) + armario.numPrenda
                }

                if (text.equals("Legging")) {
                    text = context.resources.getString(R.string.legging) + armario.numPrenda
                }
            }
            vista.findViewById<ImageView>(R.id.imagenPrenda).apply {
                setImageResource(armario.imagen)
            }

            /*vista.findViewById<TextView>(R.id.precioPrenda).apply {
                text= context.resources.getString(R.string.precio) + " " + armario.precio.toString() + " €"
            }*/

            //Spinner
            val spinner = vista.findViewById<Spinner>(R.id.spinnerTalla)
            val tallas = arrayOf(context.resources.getString(R.string.seleccionTam), "S: " + "" + armario.precio + " €", "M: " + armario.precio + " €", "L: " + armario.precio + " €")

            val adapter: ArrayAdapter<String> = ArrayAdapter<String> (
                context, android.R.layout.simple_spinner_item, tallas
            )
            spinner.setAdapter(adapter)

            //OnItemSelectedListener en Spinner para mostrar precio
            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val txtPrecio = vista.findViewById<TextView>(R.id.precioPrenda)
                    val spinner = vista.findViewById<Spinner>(R.id.spinnerTalla)
                    if (spinner.selectedItem.toString().equals("S: " + "" + armario.precio + " €")) {
                        txtPrecio.setText(context.resources.getString(R.string.precio) + " " + armario.precio + " €")
                    } else if (spinner.selectedItem.toString().equals("M: " + "" + armario.precio + " €")) {
                        txtPrecio.setText(context.resources.getString(R.string.precio) + " " + armario.precio + " €")
                    } else if (spinner.selectedItem.toString().equals("L: " + "" + armario.precio + " €")) {
                        txtPrecio.setText(context.resources.getString(R.string.precio) + " " + armario.precio + " €")
                    } else {
                        txtPrecio.setText("")
                    }
                }
            }

            //Metodo para enviar la información a la segunda
            //pantalla mediante click en
            //el item
            vista.setOnClickListener{

                //Recogemos valores
                var nombrePrenda = armario.nombre
                var descripcion = armario.descripcion
                val imagen = armario.imagen
                val precio = armario.precio
                val spinner = vista.findViewById<Spinner>(R.id.spinnerTalla)
                val txtPrecio = vista.findViewById<TextView>(R.id.precioPrenda)


                //Para establecer el string para la traducción
                if (nombrePrenda.equals("Camiseta")) {
                    nombrePrenda = context.resources.getString(R.string.camiseta) + armario.numPrenda

                    if (descripcion.equals("Camiseta azul")) {
                        descripcion = context.resources.getString(R.string.camisetaazul)
                    }
                    if (descripcion.equals("Camiseta verde")) {
                        descripcion = context.resources.getString(R.string.camisetaverde)
                    }
                    if (descripcion.equals("Camiseta amarilla")) {
                        descripcion = context.resources.getString(R.string.camisetaamarilla)
                    }
                    if (descripcion.equals("Camiseta rosa")) {
                        descripcion = context.resources.getString(R.string.camisetarosa)
                    }
                }
                if (nombrePrenda.equals("Gorra")) {
                    nombrePrenda = context.resources.getString(R.string.gorra) + armario.numPrenda
                    if (descripcion.equals("Gorra marron")) {
                        descripcion = context.resources.getString(R.string.gorramarron)
                    }
                    if (descripcion.equals("Gorra naranja")) {
                        descripcion = context.resources.getString(R.string.gorranaranja)
                    }
                    if (descripcion.equals("Gorra roja")) {
                        descripcion = context.resources.getString(R.string.gorraroja)
                    }
                }
                if (nombrePrenda.equals("Sudadera")) {
                    nombrePrenda = context.resources.getString(R.string.sudadera) + armario.numPrenda
                    if (descripcion.equals("Sudadera comoda roja")) {
                        descripcion = context.resources.getString(R.string.sudaderaroja)
                    }
                    if (descripcion.equals("Sudadera comoda blanca")) {
                        descripcion = context.resources.getString(R.string.sudaderablanca)
                    }
                    if (descripcion.equals("Sudadera comoda verde")) {
                        descripcion = context.resources.getString(R.string.sudaderaverde)
                    }
                    if (descripcion.equals("Sudadera comoda azul")) {
                        descripcion = context.resources.getString(R.string.sudaderaazul)
                    }
                }
                if (nombrePrenda.equals("Pantalon")) {
                    nombrePrenda = context.resources.getString(R.string.pantalon) + armario.numPrenda
                    if (descripcion.equals("Pantalones comodos grises")) {
                        descripcion = context.resources.getString(R.string.pantalongris)
                    }
                    if (descripcion.equals("Pantalones comodos azules")) {
                        descripcion = context.resources.getString(R.string.pantalonazul)
                    }
                    if (descripcion.equals("Pantalones comodos amarillos")) {
                        descripcion = context.resources.getString(R.string.pantalonamarillo)
                    }
                }
                if (nombrePrenda.equals("Calcetin")) {
                    nombrePrenda = context.resources.getString(R.string.calcetin) + armario.numPrenda
                    if (descripcion.equals("Calcetines grises comodos")) {
                        descripcion = context.resources.getString(R.string.calcetingris)
                    }
                    if (descripcion.equals("Calcetines rojos comodos")) {
                        descripcion = context.resources.getString(R.string.calcetinrojo)
                    }
                    if (descripcion.equals("Calcetines azules comodos")) {
                        descripcion = context.resources.getString(R.string.calcetinazul)
                    }
                    if (descripcion.equals("Calcetines multicolor comodos")) {
                        descripcion = context.resources.getString(R.string.calcetinmulticolor)
                    }
                }
                if (nombrePrenda.equals("Vestido")) {
                    nombrePrenda = context.resources.getString(R.string.vestido) + armario.numPrenda
                    if (descripcion.equals("Vestido verde comodo")) {
                        descripcion = context.resources.getString(R.string.vestidoverde)
                    }
                    if (descripcion.equals("Vestido rojo comodo")) {
                        descripcion = context.resources.getString(R.string.vestidorojo)
                    }
                    if (descripcion.equals("Vestido precioso")) {
                        descripcion = context.resources.getString(R.string.vestidoprecioso)
                    }
                }
                if (nombrePrenda.equals("Legging")) {
                    nombrePrenda = context.resources.getString(R.string.legging) + armario.numPrenda
                    if (descripcion.equals("Legging azul")) {
                        descripcion = context.resources.getString(R.string.leggingazul)
                    }
                    if (descripcion.equals("Legging negro")) {
                        descripcion = context.resources.getString(R.string.leggingnegro)
                    }
                }

                //Comprobamos que cualquiera de los radiobutton esté marcado
                var texto = spinner.selectedItem.toString()

                if (texto.equals(context.resources.getString(R.string.seleccionTam))) {
                    Toast.makeText(context, context.resources.getString(R.string.seleccion), Toast.LENGTH_SHORT).show()
                } else {
                    //Intent segunda pantalla
                    val enviar = Intent (context, SegundaPantalla::class.java)

                    //Enviamos datos
                    enviar.putExtra("NOMBRE", nombrePrenda)
                    enviar.putExtra("DESCRIPCION", descripcion)
                    enviar.putExtra("IMAGEN", imagen)
                    enviar.putExtra("PRECIO", precio)


                    if (texto.equals("L: " + "" + precio + " €")) {
                        enviar.putExtra("TALLA", "L")
                    }

                    if (texto.equals("M: " + "" + precio + " €")) {
                        enviar.putExtra("TALLA", "M")
                    }

                    if (texto.equals("S: " + "" + precio + " €")) {
                        enviar.putExtra("TALLA", "S")
                    }

                    //Comienza la actividad
                    context.startActivity(enviar)
                }
            }

            //OnLongClickListener
            /*vista.setOnLongClickListener{
                if (armario.descripcion.equals("Camiseta azul")) {
                    Toast.makeText(context, context.resources.getString(R.string.camisetaazul) + " " + context.resources.getString(R.string.oferta), Toast.LENGTH_SHORT).show()
                }
                if (armario.descripcion.equals("Camiseta verde")) {
                    Toast.makeText(context, context.resources.getString(R.string.camisetaverde) + " " + context.resources.getString(R.string.oferta), Toast.LENGTH_SHORT).show()
                }
                if (armario.descripcion.equals("Camiseta amarilla")) {
                    descripcion = context.resources.getString(R.string.camisetaamarilla)
                }
                if (armario.descripcion.equals("Camiseta rosa")) {
                    descripcion = context.resources.getString(R.string.camisetarosa)
                }
                Toast.makeText(context, context.resources.getString() + " " + context.resources.getString(R.string.oferta), Toast.LENGTH_SHORT).show()
                true
            }*/
        }

        return vista
    }


}