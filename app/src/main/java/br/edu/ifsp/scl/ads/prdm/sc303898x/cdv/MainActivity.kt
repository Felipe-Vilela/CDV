package br.edu.ifsp.scl.ads.prdm.sc303898x.cdv

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc303898x.cdv.databinding.ActivityMainBinding
import br.edu.ifsp.scl.ads.prdm.sc303898x.cdv.databinding.TileNameBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        Log.v(getString(R.string.app_name), "onCreate: Iniciando cliclo de vida COMPLETO")

        amb.addNameBt.setOnClickListener{
            TileNameBinding.inflate(layoutInflater).let{
                amb.moreNameLl.addView(it.root)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "onStart: Iniciando cliclo de vida VISIVEL")

    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "onResume: Iniciando cliclo de vida EM FOREGROUND")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "onPause: Finalizando cliclo de vida FOREGROUND")

    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "onStop: Finalizando cliclo de vida VISIVEL")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "onDestroy: Finalizando cliclo de vida COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(getString(R.string.app_name), "onRestart: Preparando execução do onStart")
    }
}