package dev.amol.spacexrockets.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amol.spacexrockets.databinding.FlickerImagesItemLayoutBinding

class FlickerImagesAdapter:RecyclerView.Adapter<FlickerImagesAdapter.FlickerImagesViewHolder>() {


    private var flickerImagesList:List<String> = mutableListOf()


    class FlickerImagesViewHolder(private val binding: FlickerImagesItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(url:String){
            Glide.with(binding.ivRocketFlickerImg).load(url).into(binding.ivRocketFlickerImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickerImagesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FlickerImagesItemLayoutBinding.inflate(layoutInflater,parent,false)
        return FlickerImagesViewHolder(binding)
    }

    override fun getItemCount(): Int = flickerImagesList.size

    override fun onBindViewHolder(holder: FlickerImagesViewHolder, position: Int) {
        holder.onBind(flickerImagesList[position])
    }

    fun updateUI(flickrImages: List<String>) {
        flickerImagesList = flickrImages
        notifyDataSetChanged()
    }

}