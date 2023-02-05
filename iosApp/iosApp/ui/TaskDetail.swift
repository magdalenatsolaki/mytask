import SwiftUI
import shared
import Kingfisher

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

            //KFImage(URL(string: "https://picsum.photos/seed/" + randomString(length: 5) + "/320/320")!)
        }
    }
}


func randomString(length: Int) -> String {
    let letters = "abcdefghijklmnopqrstuvwxyz"
    return String((0..<length).map { _ in letters.randomElement()! })
}
