package dev.amol.spacexrockets.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.spacexrockets.R
import dev.amol.spacexrockets.databinding.FragmentRocketsListingBinding
import dev.amol.spacexrockets.viewmodel.RocketsViewModel

@AndroidEntryPoint
class RocketsListingFragment : Fragment() {

    private lateinit var binding: FragmentRocketsListingBinding
    private lateinit var newsAdapter: RocketListAdapter

    private lateinit var sharedViewModel: RocketsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity())[RocketsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRocketsListingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
        setObservers()
    }

    private fun setObservers() {
        sharedViewModel.getAllRocketsData()
        sharedViewModel.allRocketsData.observe(viewLifecycleOwner) {
            newsAdapter.updateList(it)
        }
    }

    private fun setRecycler() {
        newsAdapter = RocketListAdapter(){
            it.let {
                sharedViewModel.currentItemData = it
                val fragmentTransaction = parentFragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.fragmentContainer,RocketDetailFragment()).addToBackStack("RocketDetailFragment").commit()

            }
        }
        binding.rvRecycler.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}