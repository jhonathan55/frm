package com.example.frm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.frm.databinding.FragmentPregunta1Binding


class Pregunta1Fragment : Fragment(),LifecycleOwner {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!
    private val viewModel: EncuestaViewModel by activityViewModels()
//    private val viewModel=ViewModelProvider(this).get(EncuestaViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkBoxNegro.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setColorPreferido(isChecked)
        }

        viewModel.colorPreferido.observe(viewLifecycleOwner) { colorPreferido ->
            binding.checkBoxNegro.isChecked = colorPreferido
        }

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_pregunta1Fragment_to_pregunta2Fragment)
        }
    }


}