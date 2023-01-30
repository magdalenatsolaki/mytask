import SwiftUI
import shared

@main
struct iOSApp: App {
    @StateObject private var modelData = ModelData()
    var body: some Scene {
        WindowGroup {
            ContentView()
                    .environmentObject(modelData)
        }
    }
}
