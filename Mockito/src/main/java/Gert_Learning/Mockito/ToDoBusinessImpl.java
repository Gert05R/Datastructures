package Gert_Learning.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusinessImpl {
	

		private ToDoService todoService;
		
		ToDoBusinessImpl(ToDoService todoService) 
		{
			this.todoService = todoService;
		}
	

	public List<String> retrieveTodosRelatedToSpring(String user) 
	{
		List<String> filteredTodos = new ArrayList <String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) 
		{
			if (todo.contains("String")) 
					{
						filteredTodos.add(todo);
					}
		}
	return filteredTodos;
	}
}

