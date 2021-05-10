package com.abhijith.navtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.abhijith.navtest.databinding.NewLayoutBinding

class MainFrag:Fragment() {
    private lateinit var binding: NewLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //view setup
        binding.vp2.isUserInputEnabled = false
        binding.vp2.currentItem
        binding.check.setOnClickListener {
            (requireActivity() as Navigation).navigateToCame()
        }
        binding.vp2.adapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
            override fun getItemCount(): Int {
                return 5
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        BottomOneFragment()
                    }
                    1 -> {
                        BottomTwoFragmet()
                    }
                    2 -> {
                        BottomThreeFragment()
                    }
                    3 -> {
                        BottomFourFragmet()
                    }
                    4 -> {
                        BottomFifthFragment()
                    }
                    else -> throw Exception("")
                }

            }

            override fun onBindViewHolder(
                holder: FragmentViewHolder,
                position: Int,
                payloads: MutableList<Any>
            ) {
                super.onBindViewHolder(holder, position, payloads)
                if (holder.itemView is Fragment) {
                    Toast.makeText(requireContext(), "yeah its true", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "no its not true ${childFragmentManager.fragments.size}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        binding.bnv.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.one -> {
                    binding.vp2.setCurrentItem(0, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.two -> {
                    binding.vp2.setCurrentItem(1, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.three -> {
                    binding.vp2.setCurrentItem(2, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.four -> {
                    binding.vp2.setCurrentItem(3, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.five -> {
                    binding.vp2.setCurrentItem(4, false)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }
}