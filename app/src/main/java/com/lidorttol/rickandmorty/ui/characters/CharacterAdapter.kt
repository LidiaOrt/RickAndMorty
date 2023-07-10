package com.lidorttol.rickandmorty.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.databinding.FragmentCharacterRowBinding

class CharacterAdapter(private val list: List<CharacterBo>) : PagingDataAdapter<CharacterBo, CharacterAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentCharacterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(list[position])
    }

    override fun getItemCount() = list.size
    class ViewHolder(private val binding: FragmentCharacterRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(item: CharacterBo?) {
            binding.characterRowLabelName.text = item?.name
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CharacterBo>() {
            override fun areItemsTheSame(oldItem: CharacterBo, newItem: CharacterBo): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CharacterBo, newItem: CharacterBo): Boolean =
                oldItem == newItem
        }
    }
}