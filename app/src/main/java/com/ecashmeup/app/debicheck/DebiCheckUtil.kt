package com.ecashmeup.app.debicheck

enum class Recurrence {
    Daily,
    Weekly,
    Monthly
}

fun getRecurrenceList(): List<Recurrence> {
    val recurrenceList = mutableListOf<Recurrence>()
    recurrenceList.add(Recurrence.Daily)
    recurrenceList.add(Recurrence.Weekly)
    recurrenceList.add(Recurrence.Monthly)

    return recurrenceList
}

enum class TrackIndicator {
    Yes,
    No
}

fun getTrackIndicator(): List<TrackIndicator> {
    val trackIndicatorList = mutableListOf<TrackIndicator>()
    trackIndicatorList.add(TrackIndicator.Yes)
    trackIndicatorList.add(TrackIndicator.No)

    return trackIndicatorList
}

enum class DebtorAuthenticationCode(val description: String) {
    CODE_0227("0227 - Batch or Delayed Real Time Authentication"),
    CODE_0229("0229 - Real Time Authentication"),
    CODE_0230("0230 - Real Time Authentication"),
    CODE_0999("0999 - No Authentication- Migrated NAEDO Mandates")
}

fun getDebtorAuthenticationCode(): List<DebtorAuthenticationCode> {
    val debtorAuthenticationCodeList = mutableListOf<DebtorAuthenticationCode>()
    debtorAuthenticationCodeList.add(DebtorAuthenticationCode.CODE_0227)
    debtorAuthenticationCodeList.add(DebtorAuthenticationCode.CODE_0229)
    debtorAuthenticationCodeList.add(DebtorAuthenticationCode.CODE_0230)
    debtorAuthenticationCodeList.add(DebtorAuthenticationCode.CODE_0999)

    return debtorAuthenticationCodeList
}

enum class InstallmentOccurrence(val description: String) {
    ONCEOFF("Once Off"),
    RECCURRING("Recurring")
}

fun getInstallmentOccurrence(): List<InstallmentOccurrence> {
    val installmentOccurrenceList = mutableListOf<InstallmentOccurrence>()
    installmentOccurrenceList.add(InstallmentOccurrence.ONCEOFF)
    installmentOccurrenceList.add(InstallmentOccurrence.RECCURRING)

    return installmentOccurrenceList
}


enum class Frequency(val description: String) {
    Weekly("Weekly"),
    Fortnightly("Fortnightly"),
    Monthly("Monthly"),
    Quarterly("Quarterly"),
    Bi_Annual("Bi Annual"),
    Annual("Annual"),
    Monthly_By_Rule("Monthly By Rule"),
}

fun getFrequency(): List<Frequency> {
    val frequencyList = mutableListOf<Frequency>()
    frequencyList.add(Frequency.Weekly)
    frequencyList.add(Frequency.Fortnightly)
    frequencyList.add(Frequency.Monthly)
    frequencyList.add(Frequency.Quarterly)
    frequencyList.add(Frequency.Bi_Annual)
    frequencyList.add(Frequency.Annual)
    frequencyList.add(Frequency.Monthly_By_Rule)

    return frequencyList
}

enum class EntryClass(val description: String) {
    Insurance_Premium("Insurance Premium"),
    Pension_Fund_Contribution("Pension Fund Contribution"),
    Medical_Aid_Fund_Contribution("Medical Aid Fund Contribution"),
    Unit_Trust_Purchase("Unit Trust Purchase"),
    Charitable_or_religious_contributions("Charitable or religious contributions"),
    HP_Repayment("H.P Repayment"),
    Account_Repayment("Account Repayment"),
    Loan_Repayment_other_than_Mortgage("Loan Repayment (other than Mortgage)"),
    Rental_Lease_other_than_Property("Rental-Lease (other than Property)"),
    Service_Charge_Maintenance_of_Service_Agreements("Service Charge (Maintenance of Service Agreements, etc.)"),
    Service_Charge_Variable_Amounts("Service Charge (Variable Amounts)"),
    Value_Added_Tax_Vat_collection("Value Added Tax (Vat collection)"),
    Rent_Property("Rent (Property)"),
    Bond_Repayment("Bond Repayment")
}

fun getEntryClass(): List<EntryClass> {
    val entryClassList = mutableListOf<EntryClass>()
    entryClassList.add(EntryClass.Insurance_Premium)
    entryClassList.add(EntryClass.Pension_Fund_Contribution)
    entryClassList.add(EntryClass.Medical_Aid_Fund_Contribution)
    entryClassList.add(EntryClass.Unit_Trust_Purchase)
    entryClassList.add(EntryClass.Charitable_or_religious_contributions)
    entryClassList.add(EntryClass.HP_Repayment)
    entryClassList.add(EntryClass.Account_Repayment)
    entryClassList.add(EntryClass.Loan_Repayment_other_than_Mortgage)
    entryClassList.add(EntryClass.Rental_Lease_other_than_Property)
    entryClassList.add(EntryClass.Service_Charge_Maintenance_of_Service_Agreements)
    entryClassList.add(EntryClass.Service_Charge_Variable_Amounts)
    entryClassList.add(EntryClass.Value_Added_Tax_Vat_collection)
    entryClassList.add(EntryClass.Rent_Property)
    entryClassList.add(EntryClass.Bond_Repayment)

    return entryClassList
}

enum class DocumentType(val description: String) {
    ID_Document("ID Document"),
    Passport("Passport"),
    Temporary_Residence_ID("Temporary Residence ID")
}

fun getDocumentType(): List<DocumentType> {
    val documentTypeList = mutableListOf<DocumentType>()
    documentTypeList.add(DocumentType.ID_Document)
    documentTypeList.add(DocumentType.Passport)
    documentTypeList.add(DocumentType.Temporary_Residence_ID)

    return documentTypeList
}

enum class DebtorAccountType(val description: String) {
    Cheque_Account("Cheque Account"),
    Savings_Account("Savings Account"),
    Transmission_Account("Transmission Account")
}

fun getDebtorAccountType(): List<DebtorAccountType> {
    val debtorAccountTypeList = mutableListOf<DebtorAccountType>()
    debtorAccountTypeList.add(DebtorAccountType.Cheque_Account)
    debtorAccountTypeList.add(DebtorAccountType.Savings_Account)
    debtorAccountTypeList.add(DebtorAccountType.Transmission_Account)

    return debtorAccountTypeList
}

enum class DebtorBranchNumber(val description: String) {
    ABSA("ABSA"),
    Capitec("Capitec"),
    Nedbank("Nedbank"),
    Mercantile_Bank("Mercantile Bank"),
    Postbank("Postbank"),
    Investec_Bank("Investec Bank"),
    TymeBank("TymeBank"),
    Discovery("Discovery"),
    Bank_ot_Athens("Bank ot Athens"),
    African_Bank("African Bank"),
    Habib_Bank("Habib Bank"),
    Albaraka("Albaraka"),
    HBZ("HBZ"),
    MakuruBank("MakuruBank"),
    Finbond_Bank("Finbond Bank"),
    Ubank("Ubank"),
    Old_Mutual("Old Mutual"),
    Bidvest_Bank("Bidvest Bank"),
    Grindrod("Grindrod"),
    Sasfin("Sasfin")
}

fun getDebtorBranchNumber(): List<DebtorBranchNumber> {
    val debtorBranchNumberList = mutableListOf<DebtorBranchNumber>()
    debtorBranchNumberList.add(DebtorBranchNumber.ABSA)
    debtorBranchNumberList.add(DebtorBranchNumber.Capitec)
    debtorBranchNumberList.add(DebtorBranchNumber.Nedbank)
    debtorBranchNumberList.add(DebtorBranchNumber.Mercantile_Bank)
    debtorBranchNumberList.add(DebtorBranchNumber.Postbank)
    debtorBranchNumberList.add(DebtorBranchNumber.Investec_Bank)
    debtorBranchNumberList.add(DebtorBranchNumber.TymeBank)
    debtorBranchNumberList.add(DebtorBranchNumber.Discovery)
    debtorBranchNumberList.add(DebtorBranchNumber.Bank_ot_Athens)
    debtorBranchNumberList.add(DebtorBranchNumber.African_Bank)
    debtorBranchNumberList.add(DebtorBranchNumber.Habib_Bank)
    debtorBranchNumberList.add(DebtorBranchNumber.Albaraka)
    debtorBranchNumberList.add(DebtorBranchNumber.HBZ)
    debtorBranchNumberList.add(DebtorBranchNumber.MakuruBank)
    debtorBranchNumberList.add(DebtorBranchNumber.Finbond_Bank)
    debtorBranchNumberList.add(DebtorBranchNumber.Ubank)
    debtorBranchNumberList.add(DebtorBranchNumber.Old_Mutual)
    debtorBranchNumberList.add(DebtorBranchNumber.Bidvest_Bank)
    debtorBranchNumberList.add(DebtorBranchNumber.Grindrod)
    debtorBranchNumberList.add(DebtorBranchNumber.Sasfin)

    return debtorBranchNumberList
}

enum class CollectionDay {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

fun getCollectionDay(): List<CollectionDay> {
    val collectionDayList = mutableListOf<CollectionDay>()
    collectionDayList.add(CollectionDay.Monday)
    collectionDayList.add(CollectionDay.Tuesday)
    collectionDayList.add(CollectionDay.Wednesday)
    collectionDayList.add(CollectionDay.Thursday)
    collectionDayList.add(CollectionDay.Friday)
    collectionDayList.add(CollectionDay.Saturday)
    collectionDayList.add(CollectionDay.Sunday)

    return collectionDayList
}

enum class DateAdjustmentRuleIndicator {
    Yes,
    No
}

fun getDateAdjustmentRuleIndicator(): List<DateAdjustmentRuleIndicator> {
    val dateAdjustmentRuleIndicatorList = mutableListOf<DateAdjustmentRuleIndicator>()
    dateAdjustmentRuleIndicatorList.add(DateAdjustmentRuleIndicator.Yes)
    dateAdjustmentRuleIndicatorList.add(DateAdjustmentRuleIndicator.No)

    return dateAdjustmentRuleIndicatorList
}

enum class AdjustmentCategory(val description: String) {
    Never("Never"),
    Quarterly("Quarterly"),
    Annually("Annually"),
    Bi_Annually("Bi-Annually"),
    Repo("Repo")
}

fun getAdjustmentCategory(): List<AdjustmentCategory> {
    val adjustmentCategoryList = mutableListOf<AdjustmentCategory>()
    adjustmentCategoryList.add(AdjustmentCategory.Never)
    adjustmentCategoryList.add(AdjustmentCategory.Quarterly)
    adjustmentCategoryList.add(AdjustmentCategory.Annually)
    adjustmentCategoryList.add(AdjustmentCategory.Bi_Annually)
    adjustmentCategoryList.add(AdjustmentCategory.Repo)

    return adjustmentCategoryList
}