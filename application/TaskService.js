import { Task } from "../domain/Task.js";

export class TaskService {
  constructor(taskRepository) {
    this.taskRepository = taskRepository;
  }

  createTask(title) {
    const id = Date.now().toString();
    const task = new Task(id, title);
    this.taskRepository.add(task);
    return task;
  }

  listTasks() {
    return this.taskRepository.getAll();
  }

  completeTask(id) {
    const task = this.taskRepository.getById(id);
    if (!task) throw new Error("Tarea no encontrada");
    task.complete();
    this.taskRepository.update(task);
    return task;
  }
}
