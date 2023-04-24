package compose.material.theme

import android.content.res.loader.ResourcesProvider
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ch.benlu.composeform.validators.NotEmptyValidator
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
): ViewModel() {
    var form = FormMain(resourcesProvider)

    fun validate() {
        form.validate(true)
        form.logRawValue()
        Log.d("MainViewModel", "Submit (form is valid: ${form.isValid})")
    }

    fun doSomething() {
        form.name.validators.removeIf { it::class == NotEmptyValidator::class }
        form.name.state.value = "Benji"
    }
}
