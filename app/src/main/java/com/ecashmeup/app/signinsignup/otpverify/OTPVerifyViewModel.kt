/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ecashmeup.app.signinsignup.otpverify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ecashmeup.app.signinsignup.UserRepository

class ResetPasswordViewModel(private val userRepository: UserRepository) : ViewModel() {

    /**
     * Consider all sign ins successful
     */
    fun resetSuccess(
        password: String,
        onSignInComplete: () -> Unit,
    ) {
        UserRepository.resetPassword(password)
        onSignInComplete()
    }
}

class ResetPasswordViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResetPasswordViewModel::class.java)) {
            return ResetPasswordViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
