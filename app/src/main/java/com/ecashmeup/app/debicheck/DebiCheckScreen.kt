package com.ecashmeup.app.debicheck

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecashmeup.app.R
import com.ecashmeup.app.survey.simpleDateFormatPattern
import com.ecashmeup.app.ui.theme.md_theme_light_secondary
import com.ecashmeup.app.ui.theme.slightlyDeemphasizedAlpha
import com.ecashmeup.app.util.getDefaultDateInMillis
import com.ecashmeup.app.util.supportWideScreen
import compose.material.theme.signinsignup.SignInSignUpTopAppBar
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class) // Scaffold is experimental in m3
@Composable
fun DebiCheckScreen(
    onNavUp: () -> Unit,
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val snackbarErrorText = stringResource(id = R.string.done)
    val snackbarActionLabel = stringResource(id = R.string.dismiss)

    Scaffold(
        topBar = {
            SignInSignUpTopAppBar(
                topAppBarText = stringResource(id = R.string.title_activity_debicheck_mandate),
                onNavUp = onNavUp,
            )
        },
        content = { contentPadding ->
            SubmitButton(
                modifier = Modifier.supportWideScreen(),
                contentPadding = contentPadding,
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                        EPaymentContent(
                            onClick = onNavUp
                        )
                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }
    )

    Box(modifier = Modifier.fillMaxSize()) {
        ErrorSnackbar(
            snackbarHostState = snackbarHostState,
            onDismiss = { snackbarHostState.currentSnackbarData?.dismiss() },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun EPaymentContent(
    onClick: () -> Unit,
) {
    val context = LocalContext.current
    val dateFormat = SimpleDateFormat(simpleDateFormatPattern, Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone(("Africa/Johannesburg"))
    val dateString = dateFormat.format(getDefaultDateInMillis())
    var isValid by remember { mutableStateOf(false) }
//    var frequency by rememberSaveable { mutableStateOf(frequency.Weekly.name) }
    var expanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        InputFields("Reference")

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Customer Reference")

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Tracking Indicator")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Authentication Code")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Installment Occurrence")

        Spacer(modifier = Modifier.height(10.dp))

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {

            DropdownMenuItem(
                text = { Text("Item") },
                onClick = { /* TODO */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                })
        }



        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Mandate Initiation Date")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("First Collection Date")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Collection Amount")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Maximum Collection Amount")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Entry Class")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Account Name")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Document type")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Identification")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Account Number")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Account Type")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Branch Number")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Telephone Contact")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Email Contact")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Collection Day")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Date Adjustment Rule Indicator")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Adjustment Category")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("First Collection Amount")

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            enabled = false,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
                    .copy(alpha = slightlyDeemphasizedAlpha),
            ),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .height(54.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)),
        ) {
            Text(
                text = dateString,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
//            Icon(
//                imageVector = Icons.Filled.ArrowDropDown,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(0.2f)
//            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Details Submitted Successfully!",
                    Toast.LENGTH_LONG
                ).show()
                  },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8C00),
            ),
//            enabled = isValid
        ) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun InputFields(
    labelText: String,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }
    val context = LocalContext.current

    OutlinedTextField(
        value = text,
        onValueChange = {text = it
                                isValid = it.isNotBlank()
                        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = outlinedTextFieldColors(
            cursorColor = Color.LightGray,
            focusedBorderColor = md_theme_light_secondary,
            unfocusedBorderColor = Color.LightGray,
        ),
        textStyle = MaterialTheme.typography.bodyMedium,
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        isError = !isValid,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
    )
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NumberField(
    labelText: String
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = {text = it
                        isValid = it.isNotBlank()
                        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = outlinedTextFieldColors(
            cursorColor = Color.LightGray,
            focusedBorderColor = md_theme_light_secondary,
            unfocusedBorderColor = Color.LightGray,
        ),
        textStyle = MaterialTheme.typography.bodyMedium,
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        isError = !isValid,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
    )
}

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        item {
            Spacer(modifier = Modifier.height(44.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                content()
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ErrorSnackbar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = { }
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                content = {
                    Text(
                        text = data.visuals.message,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                action = {
                    data.visuals.actionLabel?.let {
                        TextButton(onClick = onDismiss) {
                            Text(
                                text = stringResource(id = R.string.dismiss),
                                color = MaterialTheme.colorScheme.inversePrimary
                            )
                        }
                    }
                }
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom)
    )
}

@Preview(name = "Sign in light theme", uiMode = UI_MODE_NIGHT_NO)
//@Preview(name = "Sign in dark theme", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignInPreview() {
    DebiCheckScreen(
            onNavUp = {},
        )
    }

