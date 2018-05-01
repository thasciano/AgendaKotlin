package br.com.thasciano.agendakotlin.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.thasciano.agendakotlin.model.Pessoa
import br.com.thasciano.agendakotlin.room.dao.PessoaDAO

/**
 * Created by Thasciano on 30/04/2018.
 */
@Database(entities = arrayOf(Pessoa::class), version = 1, exportSchema = false)
abstract class AgendaDatabase : RoomDatabase() {
    abstract fun pessoaDao(): PessoaDAO
}