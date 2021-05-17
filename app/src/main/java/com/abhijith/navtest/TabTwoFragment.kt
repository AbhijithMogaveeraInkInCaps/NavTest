package com.abhijith.navtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class TabTwoFragment : Fragment(R.layout.activity_main), PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            view.findViewById<ViewPager2>(R.id.vp).isUserInputEnabled = false
            findViewById<TabLayout>(R.id.tl)?.apply {
                addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        view.findViewById<ViewPager2>(R.id.vp).setCurrentItem(
                            findViewById<TabLayout>(R.id.tl).selectedTabPosition,
                            false
                        )
                        //noting
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {
                        //noting
                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {
                        //noting
                    }
                })
            }
            findViewById<ViewPager2>(R.id.vp)?.apply {
                adapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
                    override fun getItemCount(): Int {
                        return 5
                    }

                    override fun createFragment(position: Int): Fragment {
                        return when (position) {
                            0 -> {
                                SubTabOneFragment()
                            }
                            1 -> {
                                SubTabTwoFragment()
                            }
                            2 -> {
                                SubTabThreeFragment()
                            }
                            3 -> {
                                SubTabFourFragment()
                            }
                            4 -> {
                                SubTabFiveFragment()
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
                            Toast.makeText(requireContext(), "yeah its true", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "no its not true ${childFragmentManager.fragments.size}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    override fun onPauseWork() {
        //do nothing
    }

    override fun onResumeWork() {
        //do nothing
    }

    override fun onRecycleWork() {
        //do nothing
    }
    override fun onStart() {
        super.onStart()
        log("FragmentSeven","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentSeven","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentSeven","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentSeven","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentSeven","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentSeven","onDetach()")

    }
}