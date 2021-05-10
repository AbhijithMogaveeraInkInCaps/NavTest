package com.abhijith.navtest

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CamFragment:Fragment(R.layout.new_fragment_fresh_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("CamFragment","view_created")
        view.findViewById<ImageView>(R.id.iv).setOnClickListener {
            findNavController().navigate(R.id.action_camFragment_to_camFragment2)
        }
    }

    override fun onStart() {
        super.onStart()
        log("CamFragment","onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("CamFragment","onResume()")
    }

    override fun onPause() {
        super.onPause()
        log("CamFragment","onPause()")

    }

    override fun onStop() {
        super.onStop()
        log("CamFragment","onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        log("CamFragment","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        log("CamFragment","onDetach()")
    }
}