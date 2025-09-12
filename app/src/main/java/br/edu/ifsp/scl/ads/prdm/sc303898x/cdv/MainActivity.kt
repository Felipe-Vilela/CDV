package br.edu.ifsp.scl.ads.prdm.sc303898x.cdv

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import br.edu.ifsp.scl.ads.prdm.sc303898x.cdv.databinding.ActivityMainBinding
import br.edu.ifsp.scl.ads.prdm.sc303898x.cdv.databinding.TileNameBinding
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        Log.v(getString(R.string.app_name), "onCreate: Iniciando cliclo de vida COMPLETO")

        with(amb){
            addNameBt.setOnClickListener{
                TileNameBinding.inflate(layoutInflater).let{
                    moreNameLl.addView(it.root)
                }
            }

            nextBt.setOnClickListener{
                Thread {
                    sleep(15000)
//                    Toast.makeText(this@MainActivity,
//                                    "Acordou",
//                                    Toast.LENGTH_SHORT).show()
                    amb.nameEt.setText("Acordou!")
                }.start()
            }
        }




    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val nameList = mutableListOf<String>()
        amb.moreNameLl.children.forEach { view ->
            (view as EditText).text.toString().let { name -> nameList.add(name) }
        }
        outState.putStringArray("NAMES", nameList.toTypedArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getStringArray("NAMES")?.forEach {name ->
            TileNameBinding.inflate(layoutInflater).let { tileNameBinding ->
                tileNameBinding.root.setText(name)
                amb.moreNameLl.addView(tileNameBinding.root)
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