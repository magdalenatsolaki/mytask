import SwiftUI

struct LabeledCheckbox: View {
    var labelText: String
    @Binding var isChecked: Bool

    var body: some View {
        Button(action: {
            self.isChecked.toggle()
        }) {
            HStack {
                Toggle(labelText, isOn: $isChecked)
                    .toggleStyle(CheckboxToggleStyle())
            }
        }
    }
}
