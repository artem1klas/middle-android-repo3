package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    companion object {
        private const val DELAY_DELETE_TASK = 10000L
    }
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(DELAY_DELETE_TASK)
        repository.deleteTask(taskId)
    }
}
