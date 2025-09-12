package br.edu.ifsp.scl.ads.prdm.sc303898x.cdv

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc303898x.cdv.databinding.ActivityAnotherBinding

class AnotherActivity : AppCompatActivity() {

    private val aab: ActivityAnotherBinding by lazy{ActivityAnotherBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(aab.root)

        setSupportActionBar(aab.toolbarIn.toolbar)
        supportActionBar?.subtitle = this.localClassName

        Log.v(getString(R.string.app_name) + "/" + this.localClassName,
            "onCreate: Iniciando cliclo de vida COMPLETO")

        aab.closeBt.setOnClickListener{
            finish()
        }

    }
    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name) + "/" + this.localClassName , "onStart: Iniciando cliclo de vida VISIVEL")

    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name) + "/" + this.localClassName, "onResume: Iniciando cliclo de vida EM FOREGROUND")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name) + "/" + this.localClassName, "onPause: Finalizando cliclo de vida FOREGROUND")

    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name) + "/" + this.localClassName, "onStop: Finalizando cliclo de vida VISIVEL")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name) + "/" + this.localClassName, "onDestroy: Finalizando cliclo de vida COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(getString(R.string.app_name) + "/" + this.localClassName, "onRestart: Preparando execução do onStart")
    }
}