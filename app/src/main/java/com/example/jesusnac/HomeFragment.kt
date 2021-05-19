package com.example.jesusnac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.jesusnac.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bindings: FragmentHomeBinding
    private var num1 = 0
    private var num2 = 0
    private var resposta = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bindings.next.setOnClickListener {
            somador()
            val action = HomeFragmentDirections.actionHomeFragmentToRespostaFragment(resposta)
            findNavController().navigate(action)
        }
    }

    private fun somador() {
        num1 = Integer.parseInt(bindings.userAnswer1.text.toString())
        num2 = Integer.parseInt(bindings.userAnswer2.text.toString())
        resposta = num1 + num2
    }
}