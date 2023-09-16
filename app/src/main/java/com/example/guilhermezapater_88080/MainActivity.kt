package com.example.guilhermezapater_88080

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.exerc_recyclerview.IDialog
import com.example.guilhermezapater_88080.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IDialog {

    private lateinit var bind: ActivityMainBinding
    private val adapter = ItemListAdapter( this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.itensRecycler.layoutManager = LinearLayoutManager(this)
        bind.itensRecycler.adapter = adapter


        adapter.setList(
            mutableListOf(
                ItemListModel(
                    "THE BEAR",
                    "DRAMA",
                    true,
                    true
                ),
                ItemListModel(
                    "TED LASSO",
                    "COMÉDIA",
                    true,
                    true
                ),
                ItemListModel(
                    "8 temporada de GAME OF THRONES",
                    "FANTASIA",
                    true,
                    false
                ),
                ItemListModel(
                    "13 REASONS WHY",
                    "DRAMA",
                    true,
                    false
                )
            )
        )
    }


    override fun removeItem(item: ItemListModel) {
        val confirmDialog = AlertDialog.Builder(this)
        confirmDialog.setTitle("Exclusao")
        confirmDialog.setMessage("Confirma a exclusão do ${item.nome}")
        confirmDialog.setPositiveButton("Sim") { dialog, _ ->
            adapter.removeItem(item)
            dialog.cancel()
        }
        confirmDialog.setNegativeButton("Não") { dialog, _ ->
            dialog.cancel()
        }
        confirmDialog.show()
    }
}