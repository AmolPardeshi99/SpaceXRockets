package dev.amol.spacexrockets.ui

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.spacexrockets.databinding.FragmentRocketDetailBinding
import dev.amol.spacexrockets.model.local.Rocket
import dev.amol.spacexrockets.model.local.convertToRocketDataClass
import dev.amol.spacexrockets.viewmodel.RocketsViewModel

@AndroidEntryPoint
class RocketDetailFragment : Fragment() {

    private lateinit var sharedViewModel: RocketsViewModel
    private lateinit var binding: FragmentRocketDetailBinding
    private lateinit var flickerImagesAdapter: FlickerImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity())[RocketsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRocketDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: Rocket? = sharedViewModel.currentItemData
        setUpUI(data)
        setObservers()
    }

    private fun setUpUI(data: Rocket?) {
        requireActivity().actionBar?.title = data?.name ?: "Rocket Detail Screen"
        data?.let {
            setUpRecycler(it)
            setUpRocketText(it)
        }
    }

    private fun setUpRocketText(spacexRocketDto: Rocket) {
        binding.rocketDetailsCardLayout.apply {
            binding.titleRocketNames.text = spacexRocketDto.name
            tvActiveStatus.text = if (spacexRocketDto.activeStatus) "Active" else "Inactive"
            tvCostPerLaunch.text = spacexRocketDto.costPerLaunch.toString()
            tvSuccessRatePercent.text = "${spacexRocketDto.successRatePct} %"
            tvHeight.text = spacexRocketDto.height.toString()
            tvDiameter.text = spacexRocketDto.diameter.toString()
            tvDescription.text = spacexRocketDto.description
            tvWikipediaLink.text = spacexRocketDto.wikipedia
            tvWikipediaLink.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        }
    }

    private fun setUpRecycler(spacexRocketDto: Rocket) {
        flickerImagesAdapter = FlickerImagesAdapter()
        flickerImagesAdapter.updateUI(spacexRocketDto.flickrImages)
        binding.rvFlickerImages.apply {
            adapter = flickerImagesAdapter
        }
    }

    private fun setObservers() {
        sharedViewModel.getSpecificRocketData()
        sharedViewModel.specificRocketData.observe(viewLifecycleOwner) {
            setUpUI(convertToRocketDataClass(it))
        }
    }

}