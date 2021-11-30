package com.example.starwarsdatabase.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.starwarsdatabase.R
import com.example.starwarsdatabase.api.Characters
import com.example.starwarsdatabase.api.extentions.makeToast
import com.example.starwarsdatabase.databinding.FragmentHomeBinding
import com.example.starwarsdatabase.main.view.adapter.AdapterStarWars
import com.example.starwarsdatabase.main.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    lateinit var adapter: AdapterStarWars
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterStarWars(Characters())
        viewModel.fetchCharacters()
    }

    override fun observeLiveData() {
        viewModel.loading.observe(viewLifecycleOwner) {
            progressHome.isVisible = it
        }
        viewModel.characters.observe(viewLifecycleOwner) {
            rvHome.adapter = AdapterStarWars(it)
            adapter.notifyDataSetChanged()
        }
        viewModel.error.observe(viewLifecycleOwner) {
            context?.makeToast(R.string.error_message)
        }

    }
}
