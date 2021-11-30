package com.example.starwarsdatabase.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.starwarsdatabase.R
import com.example.starwarsdatabase.api.extentions.makeToast
import com.example.starwarsdatabase.databinding.FragmentDetailBinding
import com.example.starwarsdatabase.main.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint
class DetailFragment : BaseFragment() {
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private var uid = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        viewModel.fetchCharacterDetails()
    }

    private fun getArgs() {
        uid = args.uid
        viewModel.uid.value = uid
    }

    override fun observeLiveData() {
        viewModel.loading.observe(viewLifecycleOwner) {
            progressDetail.isVisible = it
        }
        viewModel.characterProperties.observe(viewLifecycleOwner) {
            tvCharNameDetail.text = it.name
            tvHeightDetail.text = it.height
            tvGenderDetail.text = it.gender
            tvCharHairColorDetail.text = it.hair_color
            tvEyeColorDetail.text = it.eye_color
            tvBirthYearDetail.text = it.birth_year
        }
        viewModel.characterPropertiesVisibility.observe(viewLifecycleOwner) {
            tvCharNameDetail.isVisible = it
            tvCharHairColorDetail.isVisible = it
            tvGenderDetail.isVisible = it
            tvHeightDetail.isVisible = it
            tvEyeColorDetail.isVisible = it
            tvBirthYearDetail.isVisible = it
        }
        viewModel.error.observe(viewLifecycleOwner) {
            context?.makeToast(R.string.error_message)
        }
    }
}


