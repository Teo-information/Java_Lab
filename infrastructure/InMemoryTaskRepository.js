import { TaskRepository } from "../ports/TaskRepository.js";

export class InMemoryTaskRepository extends TaskRepository {
  constructor() {
    super();
    this.tasks = new Map();
  }

  add(task) {
    this.tasks.set(task.id, task);
  }

  getAll() {
    return Array.from(this.tasks.values());
  }

  getById(id) {
    return this.tasks.get(id);
  }

  update(task) {
    this.tasks.set(task.id, task);
  }
}
