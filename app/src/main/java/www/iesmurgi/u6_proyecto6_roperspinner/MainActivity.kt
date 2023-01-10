package www.iesmurgi.u6_proyecto6_roperspinner


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var miLista: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Asigno variable miLista
        miLista = binding.miLista

        //PrendasAdapter para asignar al listview
        PrendasAdapter(this, Prendas.prendasSource).also {
                adaptador -> miLista.setAdapter(adaptador)}

    }
}