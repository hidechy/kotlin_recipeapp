package com.codingwithme.recipeapp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    var arrMainCategory = ArrayList<CategoryItems>()

    var mainCategoryAdapter = MainCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDataFromDb()
    }

    private fun getDataFromDb() {
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()

                arrMainCategory = cat as ArrayList<CategoryItems>

                arrMainCategory.reverse()

                mainCategoryAdapter.setData(arrMainCategory)

                rv_main_category.layoutManager =
                    LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)

                rv_main_category.adapter = mainCategoryAdapter

            }
        }
    }

}
