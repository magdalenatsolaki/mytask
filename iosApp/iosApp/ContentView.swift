import SwiftUI

struct ContentView: View {
    @ObservedObject var viewModel = TodoListViewModel()
    @State private var username: String = ""
    @State var showUsernameView: Bool
    @State private var searchText: String = ""

    private var user = UserRepository()

    init() {
        showUsernameView = user.isUsernameEmpty()
    }
    var body: some View {

        NavigationView {
            if showUsernameView {
                List {
                    VStack {
                        TextField("Username", text: $username)
                        Button("Login", action: {
                            user.storeInfo(name: username)
                            showUsernameView.toggle()
                        })
                    }
                }
                    .navigationTitle("MyTask")
            }
            else {
                List {
                    TaskView(viewModel: viewModel)
                }
                    .searchable(text: $searchText, prompt: "Suche")
                    .navigationTitle("MyTask")
                    .navigationBarItems(trailing: Button(action: viewModel.addTodo) {
                        Image(systemName: "plus")
                    })
            }
        }
    }
}
