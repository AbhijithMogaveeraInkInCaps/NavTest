package com.abhijith.navtest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.abhijith.navtest.databinding.NewLayoutBinding
import com.abhijith.navtest.databinding.NewLayoutTwoBinding
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(),Navigation {

    private lateinit var binding: NewLayoutTwoBinding

    val vm:MainActivityStateViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewLayoutTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(binding.container.id,NavHostFragment.create(R.navigation.bottom_navigation_graph)).commitNow()
    }

    private val findNavController by lazy {
        findNavController(binding.container.id)
    }

    override fun navigateToCame() {
        findNavController.navigate(R.id.action_mainFrag_to_camFragment)
    }

    override fun onBackPressed() {
        if(!findNavController.navigateUp())
            super.onBackPressed()
    }

}

interface Navigation{
    fun navigateToCame()
}

class MainActivityStateViewModel:ViewModel(){
    var lastSelectedTab = 1

}