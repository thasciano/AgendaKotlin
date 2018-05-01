package br.com.thasciano.agendakotlin.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Thasciano on 30/04/2018.
 */
@Entity(tableName = "pessoa")
class Pessoa() : Parcelable {
    @PrimaryKey
    var id: Long? = null
    var nome: String? = null
    var telefone: String? = null
    var celular: String? = null
    var email: String? = null
    var endereco: String? = null

    constructor(id: Long, nome: String, telefone: String, celular: String, email: String, endereco: String) : this() {
        this.id = id
        this.nome = nome
        this.telefone = telefone
        this.celular = celular
        this.email = email
        this.endereco = endereco
    }

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        nome = parcel.readString()
        telefone = parcel.readString()
        celular = parcel.readString()
        email = parcel.readString()
        endereco = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nome)
        parcel.writeString(telefone)
        parcel.writeString(celular)
        parcel.writeString(email)
        parcel.writeString(endereco)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pessoa> {
        override fun createFromParcel(parcel: Parcel): Pessoa {
            return Pessoa(parcel)
        }

        override fun newArray(size: Int): Array<Pessoa?> {
            return arrayOfNulls(size)
        }
    }


}
