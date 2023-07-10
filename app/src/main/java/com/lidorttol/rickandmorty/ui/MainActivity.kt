package com.lidorttol.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lidorttol.rickandmorty.databinding.ActivityMainBinding
import com.lidorttol.rickandmorty.ui.characters.CharactersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        loadFragment(
            CharactersFragment.newInstance()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    fun loadFragment(fragment: Fragment) {
        binding?.let {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    it.mainActivityContainerMain.id,
                    fragment
                ).commit()
        }

    }
}