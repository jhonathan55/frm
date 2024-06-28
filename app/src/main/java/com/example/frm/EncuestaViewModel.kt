package com.example.frm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EncuestaViewModel:ViewModel() {

    private val _colorPreferido = MutableLiveData<Boolean>()
    val colorPreferido get() = _colorPreferido

    private val _email = MutableLiveData<String>()
    val email get() = _email

    private val _sugerencia = MutableLiveData<String>()
    val sugerencia get() = _sugerencia

    fun setColorPreferido(color: Boolean) {
        _colorPreferido.value = color
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setSugerencia(sugerencia: String) {
        _sugerencia.value = sugerencia
    }
}