package com.example.frm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.frm.databinding.FragmentResultadosBinding


class ResultadosFragment : Fragment() {

    private var _binding: FragmentResultadosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EncuestaViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.colorPreferido.observe(viewLifecycleOwner) { colorPreferido ->
            binding.textViewColorPreferido.text =
                "Color preferido: ${if (colorPreferido) "Negro" else "otro"}"
        }
        viewModel.email.observe(viewLifecycleOwner){email->
            binding.textViewEmail.text="Email: $email"
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}