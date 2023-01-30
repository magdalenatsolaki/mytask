import SwiftUI
import shared

struct TaskDetail: View {
    @EnvironmentObject var modelData: ModelData
    var task: Task

    var taskIndex: Int {
        modelData.tasks.firstIndex(where: { $0.id == task.id })!
    }

    var body: some View {
        List {
            HStack {
                Text("ID").bold()
                Divider()
                Text(task.id)
            }

            HStack {
                Text("Kurzbeschreibung").bold()
                Divider()
                TextField("Kurzbeschreibung", text: $modelData.tasks[taskIndex].kurzbeschreibung)
            }

            LabeledCheckbox(labelText: "Erledigt", isChecked: $modelData.tasks[taskIndex].erledigt)
        }
    }
}
