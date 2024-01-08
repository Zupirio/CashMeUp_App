package com.ecashmeup.app.debicheck

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecashmeup.app.R
import com.ecashmeup.app.survey.simpleDateFormatPattern
import com.ecashmeup.app.util.getDefaultDateInMillis
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DebiCheckQuestions(
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

    var trackIndicator by rememberSaveable { mutableStateOf(TrackIndicator.Yes.name) }
    var debtorAuthenticationCode by rememberSaveable { mutableStateOf(DebtorAuthenticationCode.CODE_0227.description) }
    var installmentOccurrence by rememberSaveable { mutableStateOf(InstallmentOccurrence.ONCEOFF.description) }
    var frequency by rememberSaveable { mutableStateOf(Frequency.Weekly.description) }
    var entryClass by rememberSaveable { mutableStateOf(EntryClass.Insurance_Premium.description) }
    var documentType by rememberSaveable { mutableStateOf(DocumentType.ID_Document.description) }
    var debtorAccountType by rememberSaveable { mutableStateOf(DebtorAccountType.Savings_Account.description) }
    var debtorBranchNumber by rememberSaveable { mutableStateOf(DebtorBranchNumber.ABSA.description) }
    var collectionDay by rememberSaveable { mutableStateOf(CollectionDay.Monday.name) }
    var dateAdjustmentRuleIndicator by rememberSaveable { mutableStateOf(DateAdjustmentRuleIndicator.Yes.name) }
    var adjustmentCategory by rememberSaveable { mutableStateOf(AdjustmentCategory.Never.description) }
    var endDate by rememberSaveable { mutableStateOf(Date().time) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        InputFields("Reference")

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Customer Reference")

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Tracking Indicator",
            getOptions = { getTrackIndicator().map { it.name } },
            recurrence = { trackIndicator = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Debtor Authentication Code",
            getOptions = { getDebtorAuthenticationCode().map { it.description } },
            recurrence = { debtorAuthenticationCode = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Instalment Occurrence",
            getOptions = { getInstallmentOccurrence().map { it.description } },
            recurrence = { installmentOccurrence = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Frequency",
            getOptions = { getFrequency().map { it.description } },
            recurrence = { frequency = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        DateTextField(
            dateNameString = "Mandate Initiation Date",
            endDate = { endDate = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        DateTextField(
            dateNameString = "First Collection Date",
            endDate = { endDate = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Collection Amount")

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Maximum Collection Amount")

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Entry Class",
            getOptions = { getEntryClass().map { it.description } },
            recurrence = { entryClass = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Debtor Account Name")

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Document Type",
            getOptions = { getDocumentType().map { it.description } },
            recurrence = { documentType = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Debtor Identification")

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Debtor Account Number")

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Debtor Account Type",
            getOptions = { getDebtorAccountType().map { it.description } },
            recurrence = { debtorAccountType = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Debtor Branch Number",
            getOptions = { getDebtorBranchNumber().map { it.description } },
            recurrence = { debtorBranchNumber = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("Debtor Telephone Contact")

        Spacer(modifier = Modifier.height(10.dp))

        InputFields("Debtor Email Contact")

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Collection Day",
            getOptions = { getCollectionDay().map { it.name } },
            recurrence = { collectionDay = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Date Adjustment Rule Indicator",
            getOptions = { getDateAdjustmentRuleIndicator().map { it.name } },
            recurrence = { dateAdjustmentRuleIndicator = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Dropdown(
            enumClassName = "Adjustment Category",
            getOptions = { getAdjustmentCategory().map { it.description } },
            recurrence = { adjustmentCategory = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        NumberField("First Collection Amount")

        Spacer(modifier = Modifier.height(10.dp))

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

@Preview(name = "Sign in light theme", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun debiPreview() {
    DebiCheckQuestions(onClick = {})
}