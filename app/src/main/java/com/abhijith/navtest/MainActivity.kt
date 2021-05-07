package com.abhijith.navtest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.abhijith.navtest.databinding.NewLayoutBinding
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private lateinit var binding: NewLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NewLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //view setup
        binding.check.setOnClickListener {
            getActiveFragments().forEach {
                Log.e("TESTTEST","${it.hashCode()}, ${supportFragmentManager.fragments.size} ${fragList.size}")
            }
        }
        binding.vp2.isUserInputEnabled = false
        binding.vp2.currentItem
        binding.vp2.adapter = object : FragmentStateAdapter(supportFragmentManager, lifecycle) {
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
                    Toast.makeText(this@MainActivity, "yeah its true", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "no its not true ${supportFragmentManager.fragments.size}",
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

    private var fragList: MutableList<WeakReference<PlayableFragment>> = ArrayList()

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is PlayableFragment)
            fragList.add(WeakReference(fragment));
    }

    private fun getActiveFragments(): List<PlayableFragment> {
        val ret = ArrayList<PlayableFragment>()
        for (ref in fragList) {
            val f = ref.get()
            if (f != null && f is Fragment && f.isVisible) {
                ret.add(f)
            }
        }
        return ret
    }
}

