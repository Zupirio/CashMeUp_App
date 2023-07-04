/*
 * Copyright 2023 The Android Open Source Project
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

package com.ecashmeup.app.epayment.accountVerification

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ecashmeup.app.signinsignup.otpsend.OTPSendScreen
import com.ecashmeup.app.signinsignup.otpsend.ResetPasswordViewModel
import com.ecashmeup.app.signinsignup.otpsend.ResetPasswordViewModelFactory

@Composable
fun AccountVerificationRoute(
    onResetSubmitted: () -> Unit,
    onNavUp: () -> Unit,
) {
    val resetPasswordViewModel: ResetPasswordViewModel = viewModel(factory = ResetPasswordViewModelFactory())
    AccountVerificationScreen(
        onResetSubmitted = {password ->
            resetPasswordViewModel.resetSuccess(password, onResetSubmitted)
        },
        onNavUp = onNavUp,
    )
}