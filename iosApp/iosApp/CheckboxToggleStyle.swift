import SwiftUI
import shared

struct CheckboxToggleStyle: ToggleStyle {

    // MARK: - Config
    private enum Config {
        static let iconSize: CGFloat = 22
        static let animationDuration: TimeInterval = 0.15
        static let onIconName = "checkmark.circle"
        static let offIconName = "circle"
    }

    // MARK: - Public properties
    var onColor: Color = .blue
    var offColor: Color = .gray

    // MARK: - Public methods
    func makeBody(configuration: Configuration) -> some View {
        HStack {
            ZStack {
                Image(systemName: Config.offIconName)
                        .resizable()
                        .foregroundColor(offColor)

                Image(systemName: Config.onIconName)
                        .resizable()
                        .foregroundColor(onColor)
                        // Toggling opacity is the easiest way to animate
                        // the image transition.
                        .opacity(configuration.isOn ? 1 : 0)
            }
                    .frame(width: Config.iconSize, height: Config.iconSize)
                    .animation(.easeInOut(duration: Config.animationDuration))
                    .onTapGesture {
                        configuration.isOn.toggle()
                    }
            configuration.label

        }

    }
}