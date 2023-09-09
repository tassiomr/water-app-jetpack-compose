package com.example.basicstatecodelab

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel
    ) {
    Column(modifier = modifier) {
        StatefulCount(modifier = modifier)

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)},
            onCloseTask = { task ->
                Log.d(task.label, "WELLNESSSCREEN")
                wellnessViewModel.remove(task)

            }
        )
    }
}

