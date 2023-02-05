import Foundation


class Prefs
{
    private let defaults = UserDefaults.standard

    private let keyUsername = "username"

    var username: String {
        set(username) {
            defaults.setValue(username, forKey: keyUsername)
        }
        get {
            return defaults.string(forKey: keyUsername)!
        }
    }
    func isUsernameEmpty() -> Bool {
        return defaults.data(forKey: keyUsername) == nil
    }

    class var shared: Prefs {
        struct Static {
            static let instance = Prefs()
        }

        return Static.instance
    }
}
