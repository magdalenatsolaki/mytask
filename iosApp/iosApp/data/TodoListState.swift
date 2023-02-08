//
//  TodoListState.swift
//  iosApp
//
//  Created by Magdalena Tsolaki on 08.02.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

enum TodoListState {
    case loading
    case loaded([TodoItem])
    case failed(Error)
}
