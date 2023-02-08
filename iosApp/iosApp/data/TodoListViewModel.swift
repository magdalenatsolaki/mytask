//
//  TodoListViewModel.swift
//  iosApp
//
//  Created by Magdalena Tsolaki on 08.02.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

class TodoListViewModel: ObservableObject {
    @Published var todos: [TodoItem] = []


    @Published var searchText: String = ""
    @Published var showCheckedOnly: Bool = false


    var numberOfTodos: Int {
        return todos.count
    }

    init(todos: [TodoItem] = []) {
        self.todos = [
            TodoItem(title: "Einkaufen"),
            TodoItem(title: "Gym"),
            TodoItem(title: "Arbeit"),
            TodoItem(title: "Lernen"),
        ]
    }

    func addTodo() {
        todos.append(TodoItem(title: "New Todo", isCompleted: false))
    }


    func toggleCompletion(for todo: TodoItem) {
        if let index = todos.firstIndex(where: { $0.id == todo.id }) {
            todos[index].isCompleted.toggle()
        }
    }

    func todo(at index: Int) -> TodoItem {
        return todos[index]
    }

    func getTodo() -> [TodoItem] {
        return todos
    }



    func deleteTodo(at offsets: IndexSet) {
        todos.remove(atOffsets: offsets)
    }

    func toggleTodoCompletion(at index: Int) {
        todos[index].isCompleted.toggle()
    }

    func getFilteredList() -> [TodoItem] {

        /*
        var filteredTasks: [Task] {
            if searchText.isEmpty {
                return listItems
            } else {
                return listItems.filter { task in
                    task.kurzbeschreibung.localizedCaseInsensitiveContains(searchText)
                }
            }
        }*/

        var filteredTasks: [TodoItem] {
            todos.filter { task in
                (!showCheckedOnly || !task.isCompleted)
            }
        }
        return filteredTasks

    }
}
