//
// Created by Magdalena Tsolaki on 30.01.23.
// Copyright (c) 2023 orgName. All rights reserved.
//

import Foundation
import shared

class TaskProvider: ObservableObject {

    @Published var task: Task?

    init(task initialValue: Task? = nil) {
        self.task = initialValue
    }

    func fetch() {
        //.. fetch pricing from a service
    }
}