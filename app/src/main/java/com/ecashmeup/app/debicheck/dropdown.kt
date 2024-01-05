package com.ecashmeup.app.debicheck

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown(enumClassName: String, getOptions: () -> List<String>, recurrence: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = enumClassName,
            style = MaterialTheme.typography.bodyLarge
        )

        val options = getOptions()
        var selectedOptionText by remember { mutableStateOf(options[0]) }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                readOnly = true,
                value = selectedOptionText,
                onValueChange = {},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            recurrence(selectionOption)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Preview(name = "Sign in light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun dropdownPreview() {
    var recurrence by rememberSaveable { mutableStateOf(Recurrence.Daily.name) }
    var trackIndicator by rememberSaveable { mutableStateOf(TrackIndicator.Yes.name) }
    var debtorAuthenticationCode by rememberSaveable { mutableStateOf(DebtorAuthenticationCode.CODE_0227.description) }
    var installmentOccurrence by rememberSaveable { mutableStateOf(InstallmentOccurrence.ONCEOFF.description) }

    Dropdown(
        enumClassName = "Instalment Occurrence",
        getOptions = { getInstallmentOccurrence().map { it.description } },
        recurrence = { installmentOccurrence = it }
    )
}
