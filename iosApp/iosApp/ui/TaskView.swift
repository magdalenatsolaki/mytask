import SwiftUI
import shared


struct TaskView: View {
    @EnvironmentObject var modelData: ModelData
    @State private var searchText: String = ""
    @State var showCheckedOnly: Bool = false

    private var prefs = Prefs.shared

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
        ZStack{
            Text("Username: " + prefs.username)
        }}
}
