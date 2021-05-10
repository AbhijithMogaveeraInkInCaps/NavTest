package com.abhijith.navtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import kotlin.random.Random

class BottomOneFragment : Fragment(R.layout.activity_main),PlayableFragment {

    val vm:MainActivityStateViewModel by activityViewModels()

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
                                TabOneFragmet()
                            }
                            1 -> {
                                TabTwoFragment()
                            }
                            2 -> {
                                TabThreeFragment()
                            }
                            3 -> {
                                TabFourFragment()
                            }
                            4 -> {
                                TabFifthFrament()
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
            findViewById<TabLayout>(R.id.tl)?.let {
                it.selectedTabPosition
                it.selectTab(it.getTabAt(vm.lastSelectedTab))
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
        log("FragmentOne","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentOne","onResume()")
    }

    override fun onPause() {
        super.onPause()
        vm.lastSelectedTab = view?.findViewById<TabLayout>(R.id.tl)?.selectedTabPosition?:2
        log("FragmentOne","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentOne","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentOne","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentOne","onDetach()")

    }
}

class TabOneFragmet : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}

class BottomTwoFragmet : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}

class SubTabOneFragment : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}

class SubTabTwoFragment : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}
class SubTabThreeFragment : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}
class SubTabFourFragment : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}
class SubTabFiveFragment : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Two"
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
        log("FragmentTwo","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentTwo","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentTwo","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentTwo","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentTwo","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentTwo","onDetach()")

    }
}

class TabThreeFragment : Fragment(R.layout.third_layout),PlayableFragment {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Three"
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
        log("FragmentThree","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentThree","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentThree","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentThree","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentThree","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentThree","onDetach()")

    }
}

class BottomThreeFragment : Fragment(R.layout.third_layout),PlayableFragment {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Three"
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
        log("FragmentThree","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentThree","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentThree","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentThree","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentThree","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentThree","onDetach()")

    }
}

class TabFourFragment : Fragment(R.layout.third_layout),PlayableFragment {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Four"
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
        log("FragmentFour","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentFour","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentFour","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentFour","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentFour","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentFour","onDetach()")

    }
}


class BottomFourFragmet : Fragment(R.layout.third_layout),PlayableFragment {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Four"
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
        log("FragmentFour","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentFour","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentFour","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentFour","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentFour","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentFour","onDetach()")

    }
}

class BottomFifthFragment : Fragment(R.layout.third_layout),PlayableFragment {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Five"
        }
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
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
        log("FragmentFive","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentFive","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentFive","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentFive","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentFive","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentFour","onDetach()")

    }
}

class TabFifthFrament : Fragment(R.layout.third_layout),PlayableFragment {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Five"
        }
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
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
        log("FragmentFive","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentFive","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentFive","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentFive","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentFive","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentFour","onDetach()")

    }
}

class FragmentSix : Fragment(R.layout.third_layout),PlayableFragment {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.tv).text = Random.nextInt().toString() + "Fragment Six"
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
        log("FragmentSix","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("FragmentSix","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("FragmentSix","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("FragmentSix","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("FragmentSix","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("FragmentSix","onDetach()")

    }
}

class TabTwoFragment : Fragment(R.layout.activity_main),PlayableFragment {
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

fun Fragment.log(from:String,message:String){
    Log.e(from,message+"ABhHH $javaClass.name", )
}