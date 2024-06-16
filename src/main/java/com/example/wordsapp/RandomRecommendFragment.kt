package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wordsapp.data.DataSource
import com.example.wordsapp.databinding.FragmentRandomRecommendBinding

class RandomRecommendFragment : Fragment() {

    private var _binding: FragmentRandomRecommendBinding? = null
    private val binding get() = _binding!!

    private val allFoods = DataSource.foodCategories.flatMap { it.foods }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRandomFood()

        binding.btnReRecommend.setOnClickListener {
            showRandomFood()
        }

        binding.btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_randomRecommendFragment_to_mainFragment)
        }
    }

    private fun showRandomFood() {
        val randomFood = allFoods.random()
        binding.foodName.text = randomFood.name
        binding.foodImage.setImageResource(randomFood.imageResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}