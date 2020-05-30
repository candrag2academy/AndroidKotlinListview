package co.candra.listviewapp

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapterKota: ArrayAdapter<*>? = null
    var listKota = arrayOf(
        "Jakarta Selatan",
        "Jakarta Barat",
        "Jakarta Utara",
        "Medan",
        "Surabaya",
        "Bandung",
        "Semarang",
        "Jogjakarta",
        "Denpasar",
        "Bekasi"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniData()
        onClickGroup()
    }
    fun iniData(){
        adapterKota =
            ArrayAdapter(this, R.layout.item_row, listKota)
        cityListView.adapter = adapterKota
    }
    fun onClickGroup(){
        cityListView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Toast.makeText(applicationContext, position.toString(),
                    Toast.LENGTH_SHORT).show()
                val selectedKota = "Kota : ${listKota[position]} "
                selectedTextView.text= selectedKota
            }
    }
}
