package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wordsapp.databinding.FragmentFoodCategoriesBinding

class FoodCategoriesFragment : Fragment() {

    private var _binding: FragmentFoodCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKorean.setOnClickListener {
            val action = FoodCategoriesFragmentDirections.actionFoodCategoriesFragmentToFoodListFragment("Korean")
            findNavController().navigate(action)
        }

        binding.btnChinese.setOnClickListener {
            val action = FoodCategoriesFragmentDirections.actionFoodCategoriesFragmentToFoodListFragment("Chinese")
            findNavController().navigate(action)
        }

        binding.btnJapanese.setOnClickListener {
            val action = FoodCategoriesFragmentDirections.actionFoodCategoriesFragmentToFoodListFragment("Japanese")
            findNavController().navigate(action)
        }

        binding.btnWestern.setOnClickListener {
            val action = FoodCategoriesFragmentDirections.actionFoodCategoriesFragmentToFoodListFragment("Western")
            findNavController().navigate(action)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_foodCategoriesFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
