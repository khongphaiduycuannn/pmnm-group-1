package com.ndmq.moneynote.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.ndmq.moneynote.R
import com.ndmq.moneynote.base.BaseActivity
import com.ndmq.moneynote.databinding.ActivityMainBinding
import com.ndmq.moneynote.utils.constant.Screen
import com.ndmq.moneynote.utils.extension.getColorFromResource

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        observeData()
    }

    private fun initView() {
        initStatusBarColor()
    }

    private fun initStatusBarColor() {
        window.statusBarColor = getColorFromResource(R.color.primaryColor)
    }

    private fun observeData() {
        observeCurrentScreen()
    }

    private fun observeCurrentScreen() {
        viewModel.currentScreen.observe(this) {
            when (it) {
                Screen.ADD_NOTE -> {
                    resetBottomBarIcon()
                    binding.ivInput.setColorFilter(getColorFromResource(R.color.highlightIconColor))
                    binding.tvInput.setTextColor(getColorFromResource(R.color.highlightIconColor))
                    binding.tvInput.visibility = View.VISIBLE
                }

                Screen.CALENDAR -> {
                    resetBottomBarIcon()
                    binding.ivCalendar.setColorFilter(getColorFromResource(R.color.highlightIconColor))
                    binding.tvCalendar.setTextColor(getColorFromResource(R.color.highlightIconColor))
                    binding.tvCalendar.visibility = View.VISIBLE
                }

                Screen.REPORT -> {
                    resetBottomBarIcon()
                    binding.ivReport.setColorFilter(getColorFromResource(R.color.highlightIconColor))
                    binding.tvReport.setTextColor(getColorFromResource(R.color.highlightIconColor))
                    binding.tvReport.visibility = View.VISIBLE
                }

                Screen.SETTING -> {
                    resetBottomBarIcon()
                    binding.ivSetting.setColorFilter(getColorFromResource(R.color.highlightIconColor))
                    binding.tvSetting.setTextColor(getColorFromResource(R.color.highlightIconColor))
                    binding.tvSetting.visibility = View.VISIBLE
                }

                else -> {
                    resetBottomBarIcon()
                }
            }
        }
    }

    fun setCurrentScreen(screen: Screen) {
        viewModel.currentScreen.value = screen
    }

    private fun resetBottomBarIcon() {
        with(binding) {
            llBottomNavBar.visibility = View.VISIBLE

            ivInput.setColorFilter(getColorFromResource(R.color.defaultIconColor))
            ivCalendar.setColorFilter(getColorFromResource(R.color.defaultIconColor))
            ivReport.setColorFilter(getColorFromResource(R.color.defaultIconColor))
            ivSetting.setColorFilter(getColorFromResource(R.color.defaultIconColor))

            tvInput.setTextColor(getColorFromResource(R.color.defaultIconColor))
            tvCalendar.setTextColor(getColorFromResource(R.color.defaultIconColor))
            tvReport.setTextColor(getColorFromResource(R.color.defaultIconColor))
            tvSetting.setTextColor(getColorFromResource(R.color.defaultIconColor))

            tvInput.visibility = View.GONE
            tvCalendar.visibility = View.GONE
            tvReport.visibility = View.GONE
            tvSetting.visibility = View.GONE
        }
    }
}