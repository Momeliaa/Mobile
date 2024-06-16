package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.data.DataSource
import com.example.wordsapp.databinding.FragmentFoodListBinding

class FoodListFragment : Fragment() {

    private var _binding: FragmentFoodListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FoodAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var isGrid = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString("category") ?: return
        val foodCategory = DataSource.foodCategories.find { it.name == category }
        val foods = foodCategory?.foods ?: emptyList()

        adapter = FoodAdapter(foods)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager

        binding.btnGrid.setOnClickListener {
            // 그리드 레이아웃으로 변경
            toggleLayoutManager()
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_foodListFragment_to_foodCategoriesFragment)
        }
    }

    private fun toggleLayoutManager() {
        if (isGrid) {
            // 현재 그리드 레이아웃이면 리니어 레이아웃으로 변경
            layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.layoutManager = layoutManager
            binding.btnGrid.text = "grid 정렬"
        } else {
            // 현재 리니어 레이아웃이면 그리드 레이아웃으로 변경
            layoutManager = GridLayoutManager(requireContext(), 2) // 2는 열의 수
            binding.recyclerView.layoutManager = layoutManager
            binding.btnGrid.text = "리스트 정렬"
        }
        isGrid = !isGrid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}