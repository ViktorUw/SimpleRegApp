package com.example.simpleregapp

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.log

open class RegistrationViewModel : ViewModel() {
    private val _user = MutableLiveData<List<User>>(emptyList())
    val user: LiveData<List<User>> get() = _user

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun addUsers() {
        val newUsers = listOf(
            User("User1","qwerty"),
            User("User2","qwerty"),
            User("User3","qwerty"),
            User("User4","qwerty"),
            User("User5","qwerty")
        )
        val currentUsers = _user.value ?: emptyList()
        _user.postValue(currentUsers + newUsers)
    }

    fun registerUser(login: String, password: String){

        val currentUser = _user.value ?: emptyList()

        if (currentUser.any{ it.login == login}){
            _error.value = "Użytkownik już istnieje"
        }
        else{
            val newUser = User(login, password)
            _user.value = currentUser + newUser
            _error.value = null
        }
    }
    fun isUserExist(login: String, password: String): Boolean{
        val regUser = _user.value ?: emptyList()
        if (regUser.any() {it.login == login && it.password == password})
        {
            return true
        }
        else{
            _error.value = "Login lub hasło jesty zły"
            return false
        }
    }
}