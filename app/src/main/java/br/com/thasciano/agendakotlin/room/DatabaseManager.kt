package br.com.thasciano.agendakotlin.room

import android.arch.persistence.room.Room
import br.com.thasciano.agendakotlin.room.dao.PessoaDAO
import br.com.thasciano.agendakotlin.util.MyApplication

/**
 * Created by Thasciano on 30/04/2018.
 */
object DatabaseManager {
    // Singleton do Room: banco de dados
    private var dbInstance: AgendaDatabase

    init {
        val appContext = MyApplication.getInstance().applicationContext
        // Configura o Room
        dbInstance = Room.databaseBuilder(
                appContext,
                AgendaDatabase::class.java,
                "agenda.sqlite")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

    fun getPessoaDAO(): PessoaDAO {
        return dbInstance.pessoaDao()
    }
}