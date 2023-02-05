import SimpleToast
import SwiftUI

struct ContentView: View {
    @EnvironmentObject var modelData: ModelData
    @State private var username: String = ""
    @State var showUsernameView: Bool
    @State private var searchText: String = ""
    @State private var showToast = false
    private let toastOptions = SimpleToastOptions(
        hideAfter: 5
    )

    private var prefs = Prefs.shared

    init() {
        showUsernameView = prefs.isUsernameEmpty()
    }
    var body: some View {

        NavigationView {
            if showUsernameView {
                List {
                    VStack {
                        TextField("Username", text: $username)
                        Button("Login", action: {
                            prefs.username = username
                            showToast.toggle()
                            showUsernameView.toggle()
                        })
                    }
                }
                    .navigationTitle("MyTask")
            }
            else {
                List {
                    VStack {
                        TaskView()
                    }
                        .simpleToast(isPresented: $showToast, options: toastOptions) {
                        HStack {
                            Text("Willkommen " + prefs.username)
                        }
                            .padding()
                            .background(Color.gray.opacity(0.8))
                            .foregroundColor(Color.white)
                            .cornerRadius(10)
                    }
                }
                    .searchable(text: $searchText, prompt: "Suche")
                    .navigationTitle("MyTask")
            }
        }
    }
}
