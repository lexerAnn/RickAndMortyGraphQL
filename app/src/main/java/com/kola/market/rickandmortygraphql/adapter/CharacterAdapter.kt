package com.kola.market.rickandmortygraphql.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kola.market.rickandmortygraphql.databinding.ListItemCharactersBinding
import com.kola.market.rickandmortygraphql.datasource.models.SingleCharacterModel

class CharacterAdapter(
    private val onItemClick: ((item: SingleCharacterModel) -> Unit)? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<SingleCharacterModel>() {

        override fun areItemsTheSame(oldItem: SingleCharacterModel, newItem: SingleCharacterModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SingleCharacterModel, newItem: SingleCharacterModel): Boolean {
            return oldItem.id == newItem.id
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return CharacterViewHolder(
            ListItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<SingleCharacterModel>) {
        differ.submitList(list)
    }

    class CharacterViewHolder(
        private val binding: ListItemCharactersBinding,
        private val onItemClick: ((item: SingleCharacterModel) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SingleCharacterModel,) = with(binding) {

            Glide.with(root.context)
                .load(item.image)
                .into(image)

            name.text = item.name

        }
    }
}

