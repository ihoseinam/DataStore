package ir.hoseinahmadi.datastore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hoseinahmadi.datastore.datastore.DataStoreRepository
import ir.hoseinahmadi.datastore.datastore.DataStoreRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {
    companion object {
        const val UserPhoneKey = "UserPhoneKey"
    }

    fun saveUserPhone(phone: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.putString(UserPhoneKey, phone)
        }
    }

    val userPhone = MutableStateFlow("")
    fun getUserPhone() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getString(UserPhoneKey)?.let {
                userPhone.emit(it)
            }
        }
    }

    suspend fun getUserPhone2(): String? = repository.getString(UserPhoneKey)


}


