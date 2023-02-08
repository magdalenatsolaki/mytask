import SwiftUI
import shared

struct TaskRow: View {
    @ObservedObject var viewModel: TodoListViewModel
    var task: TodoItem

    var body: some View {
        if let index = viewModel.todos.firstIndex(where: { $0.id == task.id }) {
            HStack {
                LabeledCheckbox(labelText: task.title, isChecked: $viewModel.todos[index].isCompleted)
            }
        }
    }
}
