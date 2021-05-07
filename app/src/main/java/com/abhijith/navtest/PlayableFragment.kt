package com.abhijith.navtest

import androidx.fragment.app.FragmentActivity

interface PlayableFragment{
    fun onPauseWork()
    fun onResumeWork()
    fun onRecycleWork()
}