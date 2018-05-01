package br.com.thasciano.agendakotlin.room.dao

import android.arch.persistence.room.*
import br.com.thasciano.agendakotlin.model.Pessoa

/**
 * Created by Thasciano on 30/04/2018.
 */
@Dao
interface PessoaDAO {
    @Query("SELECT * FROM pessoa where id = :arg0")
    fun getById(id: Long): Pessoa?

    @Query("SELECT * FROM pessoa")
    fun findAll(): List<Pessoa>

    @Insert
    fun insert(objeto: Pessoa)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(objeto: List<Pessoa>)

    @Delete
    fun delete(objeto: Pessoa)

    @Query("DELETE FROM pessoa")
    fun nukeTable()
}
