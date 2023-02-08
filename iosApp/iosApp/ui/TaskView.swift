import SwiftUI
import shared


struct TaskView: View {
    @ObservedObject var viewModel: TodoListViewModel

    let user = UserRepository()

    var body: some View {
        Toggle(isOn: $viewModel.showCheckedOnly) {
            Text("Nur offene")
        }
        ForEach(viewModel.getFilteredList()) { task in
            NavigationLink {
                TaskDetail(viewModel: viewModel, task: task)
            } label: {
                TaskRow(viewModel: viewModel, task: task)
            }

        }
            .onDelete(perform: viewModel.deleteTodo)
        ZStack {
            Text("Username: " + user.getUserInfo()!)
        } }
}
