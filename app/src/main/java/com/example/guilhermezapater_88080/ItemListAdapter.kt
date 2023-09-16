package com.example.guilhermezapater_88080

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exerc_recyclerview.IDialog
import com.example.guilhermezapater_88080.databinding.ItemListBinding

class ItemListAdapter(private val dialogListener: IDialog) :
    RecyclerView.Adapter<ItemListAdapter.ItemLineViewHolder>() {


    private val items: MutableList<ItemListModel> = mutableListOf()

    class ItemLineViewHolder(val itemHolder: ItemListBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {
        fun bind(item: ItemListModel) {
            itemHolder.nomeSerie.text = item.nome
            itemHolder.generoSerie.text = item.genero

            if(item.recomendado){
                itemHolder.botaoLike.setImageResource(R.drawable.icon_like)
            } else {
                itemHolder.botaoLike.setImageResource(R.drawable.icon_dislike)
            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLineViewHolder {
        return ItemLineViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ItemLineViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemHolder.removeBtn.setOnClickListener {
            dialogListener.removeItem(items[position])
        }

        holder.itemHolder.cardPais.setOnClickListener {
            items[position].detailVisibility = !items[position].detailVisibility
            notifyItemChanged(position)
        }
    }



        fun setList(newItems: List<ItemListModel>) {
            items.clear()
            items.addAll(newItems)
            notifyDataSetChanged()
        }

        fun removeItem(removed:ItemListModel){
            val removedIndex = items.indexOf(removed)
            items.remove(removed)
            notifyItemRemoved(removedIndex)
            notifyItemRangeChanged(removedIndex, items.size)
        }

    }



