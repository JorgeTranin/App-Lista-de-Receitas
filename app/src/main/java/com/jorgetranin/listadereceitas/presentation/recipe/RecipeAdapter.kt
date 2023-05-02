package com.jorgetranin.listadereceitas.presentation.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jorgetranin.listadereceitas.databinding.ItemRecipeBinding
import com.jorgetranin.listadereceitas.domain.model.RecipeDomain

class RecipeAdapter : ListAdapter<RecipeDomain, RecipeAdapter.ViewHolder>(DiffCalback()) {

    var click: (RecipeDomain) -> Unit = {}
    inner class ViewHolder (
        private val binding: ItemRecipeBinding
            ): RecyclerView.ViewHolder(binding.root){
                fun bind(item: RecipeDomain){
                    binding.tvNome.text = item.name
                }
            }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecipeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}
//Se caso a lista for reciclada ele só atualiza o item que foi modificado mantendo os que estao iguais, dando performace a lista
class DiffCalback: DiffUtil.ItemCallback<RecipeDomain>() {
    override fun areItemsTheSame(oldItem: RecipeDomain, newItem: RecipeDomain) = oldItem == newItem

    override fun areContentsTheSame(oldItem: RecipeDomain, newItem: RecipeDomain) = oldItem.id == newItem.id

}