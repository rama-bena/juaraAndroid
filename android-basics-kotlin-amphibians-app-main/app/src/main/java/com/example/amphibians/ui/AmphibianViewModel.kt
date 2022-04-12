/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amphibians.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {
    /**Property*/
    private val _status = MutableLiveData<AmphibianApiStatus>()
    val status: LiveData<AmphibianApiStatus> = _status

    private val _amphibianList = MutableLiveData<List<Amphibian>>()
    val amphibianList: LiveData<List<Amphibian>> = _amphibianList

    private val _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> = _amphibian

    /**Init*/
    init {
        getAmphibian()
    }

    /**Method*/
    fun onAmphibianClicked(amphibian: Amphibian) {
        _amphibian.value = amphibian
    }

    /**Private method / helper */
    private fun getAmphibian() {
        viewModelScope.launch {
            _status.value = AmphibianApiStatus.LOADING
            try {
                _amphibianList.value = AmphibianApi.retrofitService.getAmphibian()
                _status.value = AmphibianApiStatus.DONE
            }
            catch (e: Exception) {
                _amphibianList.value = listOf()
                _status.value = AmphibianApiStatus.ERROR
            }
        }
    }
}
