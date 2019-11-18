package com.jo.submission.jetpackpro.ui.main

import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jo.submission.jetpackpro.BR
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.databinding.ActivityMainBinding
import com.jo.submission.jetpackpro.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    @Inject
    lateinit var mMainViewModel: MainViewModel

    override fun getLayoutId() = R.layout.activity_main

    override fun getBindingVariable() = BR.viewModel

    override fun getViewModel() = mMainViewModel

    companion object {
        const val SELECTED_MENU = "selected_menu"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mMainViewModel.setNavigator(this)
        mMainViewModel.setupResources(resources)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_movies,
                R.id.navigation_tv_show
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)

        if (savedInstanceState != null)
            savedInstanceState.getInt(SELECTED_MENU)
        else
            nav_view.selectedItemId = R.id.navigation_movies
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, nav_view.selectedItemId)
    }

    override fun handleError(throwable: Throwable?) {
        Log.d("pesan", "error di ${throwable?.localizedMessage}")
    }
}
