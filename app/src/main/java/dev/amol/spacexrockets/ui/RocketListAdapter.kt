package dev.amol.spacexrockets.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amol.spacexrockets.databinding.RocketItemLayoutBinding
import dev.amol.spacexrockets.model.local.Rocket

class RocketListAdapter(val onItemClick: ((Rocket) -> Unit))
    : RecyclerView.Adapter<RocketListAdapter.RocketsListViewHolder>() {


    private var rocketDataList: List<Rocket> = mutableListOf()

    class RocketsListViewHolder(private val binding: RocketItemLayoutBinding,  private val onItemClick: ((Rocket) -> Unit)) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(item:Rocket){
                binding.root.setOnClickListener {onItemClick(item)}
                binding.apply {
                    tvRocketName.text = item.name
                    tvRocketCountry.text = item.country
                    tvRocketEngineCount.text = item.engineCount.toString()
                    Glide.with(ivRocketFlickerImgLayout.ivRocketFlickerImage).load(item.flickrImages.first()).into(ivRocketFlickerImgLayout.ivRocketFlickerImage)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RocketItemLayoutBinding.inflate(layoutInflater,parent,false)
        return RocketsListViewHolder(binding,onItemClick)
    }

    override fun getItemCount(): Int = rocketDataList.size


    override fun onBindViewHolder(holder: RocketsListViewHolder, position: Int) {
        rocketDataList[position].apply {
            holder.onBind(this)
        }
    }


    fun updateList(newData:List<Rocket>){
        rocketDataList = newData
        notifyDataSetChanged()
    }
}