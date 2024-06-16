package com.example.wordsapp.data

import com.example.wordsapp.R

data class Food(val name: String, val imageResId: Int)

data class FoodCategory(val name: String, val foods: List<Food>)

object DataSource {
    val foodCategories = listOf(
        FoodCategory("Korean", listOf(
            Food("부대찌개", R.drawable.korean1),
            Food("비빔밥", R.drawable.korean2),
            Food("불고기", R.drawable.korean3),
            Food("된장찌개", R.drawable.korean4),
            Food("삼겹살", R.drawable.korean5)
        )),
        FoodCategory("Chinese", listOf(
            Food("짜장면", R.drawable.chinese1),
            Food("짬뽕", R.drawable.chinese2),
            Food("탕수육", R.drawable.chinese3),
            Food("마파두부", R.drawable.chinese4)
        )),
        FoodCategory("Japanese", listOf(
            Food("초밥", R.drawable.japanese1),
            Food("라멘", R.drawable.japanese2),
            Food("덴푸라", R.drawable.japanese3),
            Food("우동", R.drawable.japanese4),
            Food("타코야키", R.drawable.japanese5)
        )),
        FoodCategory("Western", listOf(
            Food("스테이크", R.drawable.western1),
            Food("파스타", R.drawable.western2),
            Food("피자", R.drawable.western3),
            Food("버거", R.drawable.western4),
            Food("샐러드", R.drawable.western5)
        ))
    )
}