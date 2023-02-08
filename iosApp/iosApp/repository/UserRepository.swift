//
//  UserRepository.swift
//  iosApp
//
//  Created by Magdalena Tsolaki on 07.02.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

class UserRepository {
    let userID = "username"
    let userDefaults: UserDefaults
    
    init(userDefaults: UserDefaults = .standard) {
        self.userDefaults = userDefaults
    }
    
    func storeInfo(name: String) {
        userDefaults.set(name, forKey: userID)
    }

    func getUserInfo() -> String? {
        let name: String? = userDefaults.string(forKey: userID)
        return name
    }

    func removeUserInfo() {
        userDefaults.removeObject(forKey: userID)
    }

    func isUsernameEmpty() -> Bool {
        return getUserInfo() == nil
    }
}
