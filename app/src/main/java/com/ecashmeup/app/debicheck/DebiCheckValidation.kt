package com.ecashmeup.app.debicheck

private fun validateMedication(
    name: String,
    dosage: Int,
    recurrence: String,
    endDate: Long,
    morningSelection: Boolean,
    afternoonSelection: Boolean,
    eveningSelection: Boolean,
    nightSelection: Boolean,
    onInvalidate: (Int) -> Unit,
    onValidate: () -> Unit
) {
    if (name.isEmpty()) {
//        onInvalidate(R.string.medication_name)
        return
    }

    if (endDate < 1) {
//        onInvalidate(R.string.end_date)
        return
    }

    // TODO: Out of scope for this blog post.
    onValidate()
}