package br.com.thasciano.agendakotlin.util

import android.app.Application
import android.util.Log

/**
 * Created by Thasciano on 30/04/2018.
 */
class MyApplication : Application() {
    private val TAG = "application"

    companion object {
        // Singleton da classe Application
        private var appInstance: MyApplication? = null

        fun getInstance(): MyApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

    // Chamado quando o Android criar o processo da aplicação
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    // Chamado quando o Android finalizar o processo da aplicação
    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "application.onTerminate()")
    }
}