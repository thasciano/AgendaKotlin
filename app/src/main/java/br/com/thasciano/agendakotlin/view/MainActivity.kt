package br.com.thasciano.agendakotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.thasciano.agendakotlin.R
import br.com.thasciano.agendakotlin.model.Pessoa
import br.com.thasciano.agendakotlin.room.DatabaseManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = DatabaseManager.getPessoaDAO()

        var arrayPessoa = ArrayList<Pessoa>()

        for (aux in 0..100){
            arrayPessoa.add(Pessoa(aux.toLong(), "Lorem " + aux, "Lorem " + aux,
                    "Lorem " + aux, "Lorem " + aux, "Lorem " + aux))
        }

        dao.insertAll(arrayPessoa)


        var arrayPessoaBD = dao.findAll()

        for (pessoa in arrayPessoaBD)
            Log.i("roomDB", pessoa.nome.toString())

    }
}
