package com.lidorttol.rickandmorty.ui.characters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.utils.EventAsyncResultObserver
import com.lidorttol.rickandmorty.databinding.FragmentCharactersBinding
import com.lidorttol.rickandmorty.ui.MainActivity
import com.lidorttol.rickandmorty.ui.characterdetail.CharacterDetailFragment

class CharactersFragment : Fragment() {

    private var binding: FragmentCharactersBinding? = null
    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharactersViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            getCharacters().observe(viewLifecycleOwner, object: EventAsyncResultObserver<List<CharacterBo>?>() {
                override fun onSuccess(response: List<CharacterBo>?) {
                    if (!response.isNullOrEmpty()) {
                            setupList(response)
                    } else {
                        // TODO(show message/icon no data)
                    }
                }

                override fun onLoading(loading: Boolean) {
                    super.onLoading(loading)
                    // TODO: show loading
                }

                override fun onError(error: String, response: List<CharacterBo>?) {
                    Log.e("ERROR -> ", error)
                    super.onError(error, response)
                }
            })
        }
        viewModel.requestCharacters()
    }

    private fun setupList(items: List<CharacterBo>) {
        val onCharacterClickListener = object : CharacterAdapter.OnCharacterClickListener {
            override fun onCharacterClick(id: Long) {
                if (activity != null && activity is MainActivity) {
                    (activity as MainActivity).loadFragment(
                        CharacterDetailFragment.newInstance(id)
                    )
                }
            }
        }
        val adapter = CharacterAdapter(items, onCharacterClickListener)
        binding?.charactersListCharacters?.adapter = adapter
    }

    companion object {

        fun newInstance() = CharactersFragment()

    }

}