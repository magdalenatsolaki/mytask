import Foundation
import shared
import Combine

final class ModelData: ObservableObject {
    @Published var tasks: [Task] = SampleDataKt.listItems
}

extension Task: Identifiable {
}