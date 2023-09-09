package com.example.basicstatecodelab

import android.util.Log
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        Log.d(item.label, "VIEWMODEL")
        _tasks.remove(item)
    }

    fun changeTaskChecked (task: WellnessTask, checked: Boolean) {
        tasks.find { it.id == task.id }?.let {
            task -> task.checked = checked
        }
    }
}

private fun getWellnessTasks() = List(6) { i -> WellnessTask(i, "Task # $i") }

