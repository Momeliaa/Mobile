package com.example.wordsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.data.Food
import com.example.wordsapp.databinding.ItemFoodBinding

data class Food(val name: String, val imageResId: Int)

class FoodAdapter(private val foods: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    inner class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            binding.foodName.text = food.name // foodName과 foodImage에 대한 바인딩 설정
            binding.foodImage.setImageResource(food.imageResId)
        }
    }
}