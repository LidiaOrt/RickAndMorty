package com.lidorttol.rickandmorty.ui.characterdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.utils.EventAsyncResultObserver
import com.lidorttol.rickandmorty.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private var binding: FragmentCharacterDetailBinding? = null
    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterDetailViewModel::class.java] }
    private var characterId: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharacterDetailBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterId = arguments?.getLong(CHARACTER_ID)

        setupObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun setupObservers() {
        setupCharactersObserver()
    }

    private fun setupCharactersObserver() {
        viewModel.apply {
            getCharacter().observe(viewLifecycleOwner, object: EventAsyncResultObserver<CharacterBo?>() {
                override fun onSuccess(response: CharacterBo?) {
                    if (response != null) {
                            setupCharacter(response)
                    } else {
                        // TODO(show message/icon no data)
                    }
                }

                override fun onLoading(loading: Boolean) {
                    super.onLoading(loading)
                    // TODO: show loading
                }

                override fun onError(error: String, response: CharacterBo?) {
                    Log.e("ERROR -> ", error)
                    super.onError(error, response)
                }
            })
        }
        characterId?.let { viewModel.requestCharacterById(it) }
    }


    private fun setupCharacter(item: CharacterBo) {
        // SET CHARACTER
        binding?.apply {
            characterDetailImageCharacter.let {
                Glide.with(this@CharacterDetailFragment)
                    .load(item.image)
                    .into(it)
            }
            characterDetailLabelName.text = item.name
        }
    }

    companion object {
        private const val CHARACTER_ID = "CHARACTER_ID"

        fun newInstance(characterId: Long) = CharacterDetailFragment().apply {
                arguments = Bundle().apply { putLong(CHARACTER_ID, characterId) }
        }
    }

}