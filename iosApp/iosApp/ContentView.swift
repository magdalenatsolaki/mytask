import SwiftUI
import shared

struct ContentView: View {
    @EnvironmentObject var modelData: ModelData
    @State private var searchText: String = ""
    @State var showCheckedOnly: Bool = false
/*
    var filteredTasks: [Task] {
        if searchText.isEmpty {
            return listItems
        } else {
            return listItems.filter { task in
                task.kurzbeschreibung.localizedCaseInsensitiveContains(searchText)
            }
        }
    }*/

    var filteredTasks: [Task] {
        modelData.tasks.filter { task in
            (!showCheckedOnly || !task.isAbgeschlossen())
        }
    }

    var body: some View {
        NavigationView {
            List {
                Toggle(isOn: $showCheckedOnly) {
                    Text("Nur offene")
                }
                ForEach(filteredTasks) { task in
                    NavigationLink {
                        TaskDetail(task: task)
                    } label: {
                        TaskRow(task: task)
                    }

                }
            }
                    .searchable(text: $searchText, prompt: "Suche")
                    .navigationTitle("MyTask")
        }
    }
}
