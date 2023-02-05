import SwiftUI
import shared

struct TaskRow: View {
    @EnvironmentObject var modelData: ModelData
    var task: Task

    var taskIndex: Int {
        modelData.tasks.firstIndex(where: { $0.id == task.id })!
    }

    //@State private var isChecked: Bool = false
    var body: some View {
        HStack {
            LabeledCheckbox(labelText: task.kurzbeschreibung, isChecked: $modelData.tasks[taskIndex].erledigt)
        }
    }
}
