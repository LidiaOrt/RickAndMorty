package com.lidorttol.rickandmorty.ui.characters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.databinding.FragmentCharacterRowBinding

class CharacterAdapter(
    private val list: List<CharacterBo>,
    private val onCharacterClick: OnCharacterClickListener
) : PagingDataAdapter<CharacterBo, CharacterAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentCharacterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setupItem(
            list[position],
            onCharacterClick
        )
    }

    override fun getItemCount() = list.size
    class ViewHolder(
        private val binding: FragmentCharacterRowBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setupItem(item: CharacterBo?, onClickListener: OnCharacterClickListener) {
            binding.root.setOnClickListener {
                item?.id?.let { idNotNull -> onClickListener.onCharacterClick(idNotNull) }
            }

            binding.characterRowLabelName.text = item?.name
            binding.characterRowImageCharacter.let {
                Glide.with(context)
                    .load(item?.image)
                    .into(it)
            };
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

    interface OnCharacterClickListener {
        fun onCharacterClick(id: Long)
    }
}