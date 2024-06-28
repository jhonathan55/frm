package com.example.frm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.frm.databinding.FragmentPregunta2Binding


class Pregunta2Fragment : Fragment() {
    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    private val viewModel: EncuestaViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newValue = s.toString()
                if (viewModel.email.value != newValue) {
                    viewModel.setEmail(newValue)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        viewModel.email.observe(viewLifecycleOwner) { email ->
            if (binding.editTextEmail.text.toString() != email) {
                binding.editTextEmail.setText(email)
            }
        }
        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_pregunta2Fragment_to_resultadosFragment)
        }

    }




}