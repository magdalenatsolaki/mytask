import SwiftUI
import Kingfisher

struct TaskDetail: View {
    @ObservedObject var viewModel: TodoListViewModel
    var task: TodoItem

    var taskIndex: Int {
        viewModel.todos.firstIndex(where: { $0.id == task.id })!
    }

    var body: some View {
        List {
            HStack {
                Text("ID").bold()
                Divider()
                Text(task.id.uuidString)
            }

            HStack {
                Text("Kurzbeschreibung").bold()
                Divider()
                TextField("Kurzbeschreibung", text: $viewModel.todos[taskIndex].title)
            }

            LabeledCheckbox(labelText: "Erledigt", isChecked: $viewModel.todos[taskIndex].isCompleted)

            //KFImage(URL(string: "https://picsum.photos/seed/" + randomString(length: 5) + "/320/320")!)
        }
    }
}


func randomString(length: Int) -> String {
    let letters = "abcdefghijklmnopqrstuvwxyz"
    return String((0..<length).map { _ in letters.randomElement()! })
}
