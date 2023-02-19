package dev.amol.spacexrockets.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.spacexrockets.databinding.FragmentRocketDetailBinding
import dev.amol.spacexrockets.model.network.SpacexRocketDto
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
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRocketDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().actionBar?.title = "Rocket Detail Screen"
        setUpUI()
        setObservers()
    }

    private fun setUpUI() {
        val data : SpacexRocketDto? = sharedViewModel.currentItemData
        data?.let {
            requireActivity().actionBar?.title = data.name
            setUpRecycler(it)
            setUpRocketText(it)
            setUpLinkPreview(it)
        }
    }

    private fun setUpLinkPreview(spacexRocketDto: SpacexRocketDto) {
        binding.wikipediaLinkPreviewCard.apply {
            Glide.with(ivLinkPreview).load(spacexRocketDto.wikipedia).into(ivLinkPreview)
        }
    }

    private fun setUpRocketText(spacexRocketDto: SpacexRocketDto) {
        binding.rocketDetailsCardLayout.apply {
            tvActiveStatus.text = if(spacexRocketDto.active) "Active" else "Inactive"
            tvCostPerLaunch.text = spacexRocketDto.costPerLaunch.toString()
            tvSuccessRatePercent.text =  "${spacexRocketDto.successRatePct} %"
            tvHeightDiameter.text = spacexRocketDto.height.toString()+"/ "+spacexRocketDto.diameter
            tvDescription.text = spacexRocketDto.description
        }
    }

    private fun setUpRecycler(spacexRocketDto: SpacexRocketDto) {
        flickerImagesAdapter = FlickerImagesAdapter()
        flickerImagesAdapter.updateUI(spacexRocketDto.flickrImages)
        binding.rvFlickerImages.apply {
            adapter = flickerImagesAdapter
        }
    }

    private fun setObservers() {
        sharedViewModel.getSpecificRocketData()
        sharedViewModel.specificRocketData.observe(viewLifecycleOwner){
            flickerImagesAdapter.updateUI(it.flickrImages)
        }
    }

    private fun setUI(spacexRocketDto: SpacexRocketDto) {

    }

}