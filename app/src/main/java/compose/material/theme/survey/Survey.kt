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

package compose.material.theme.survey

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.material.theme.survey.question.DateQuestion
import compose.material.theme.survey.question.MultipleChoiceQuestion
import compose.material.theme.survey.question.PhotoQuestion
import compose.material.theme.survey.question.SingleChoiceQuestion
import compose.material.theme.survey.question.SliderQuestion
import compose.material.theme.survey.question.Superhero
import compose.material.theme.R

@Composable
fun FreeTimeQuestion(
    selectedAnswers: List<Int>,
    onOptionSelected: (selected: Boolean, answer: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    MultipleChoiceQuestion(
        titleResourceId = R.string.in_my_free_time,
        directionsResourceId = R.string.select_all,
        possibleAnswers = listOf(
            R.string.read,
            R.string.work_out,
            R.string.draw,
            R.string.play_games,
            R.string.dance,
            R.string.watch_movies,
        ),
        selectedAnswers = selectedAnswers,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}

@Composable
fun SuperheroQuestion(
    selectedAnswer: Superhero?,
    onOptionSelected: (Superhero) -> Unit,
    modifier: Modifier = Modifier,
) {
    SingleChoiceQuestion(
        titleResourceId = R.string.pick_superhero,
        directionsResourceId = R.string.select_one,
        possibleAnswers = listOf(
            Superhero(R.string.spark, R.drawable.padlock),
            Superhero(R.string.lenz, R.drawable.padlock),
            Superhero(R.string.bugchaos, R.drawable.padlock),
            Superhero(R.string.frag, R.drawable.padlock),
        ),
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}

@Composable
fun TakeawayQuestion(
    dateInMillis: Long?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DateQuestion(
        titleResourceId = R.string.takeaway,
        directionsResourceId = R.string.select_date,
        dateInMillis = dateInMillis,
        onClick = onClick,
        modifier = modifier,
    )
}

@Composable
fun FeelingAboutSelfiesQuestion(
    value: Float?,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    SliderQuestion(
        titleResourceId = R.string.selfies,
        value = value,
        onValueChange = onValueChange,
        startTextResource = R.string.strongly_dislike,
        neutralTextResource = R.string.neutral,
        endTextResource = R.string.strongly_like,
        modifier = modifier,
    )
}

@Composable
fun TakeSelfieQuestion(
    imageUri: Uri?,
    getNewImageUri: () -> Uri,
    onPhotoTaken: (Uri) -> Unit,
    modifier: Modifier = Modifier,
) {
    PhotoQuestion(
        titleResourceId = R.string.selfie_skills,
        imageUri = imageUri,
        getNewImageUri = getNewImageUri,
        onPhotoTaken = onPhotoTaken,
        modifier = modifier,
    )
}
