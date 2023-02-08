//
//  TodoListViewController.swift
//  iosApp
//
//  Created by Magdalena Tsolaki on 08.02.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

class TodoListViewController {
    private let viewModel: TodoListViewModel
    private var state: TodoListState = .loading {
        didSet {
            updateView()
        }
    }

    init(viewModel: TodoListViewModel) {
        self.viewModel = viewModel
    }

    func updateView() {
        switch state {
        case .loading:
            // Show loading indicator
            break
        case .loaded(let todos):
            // Show todo items
            break
        case .failed(let error):
            // Show error message
            break
        }
    }
}
