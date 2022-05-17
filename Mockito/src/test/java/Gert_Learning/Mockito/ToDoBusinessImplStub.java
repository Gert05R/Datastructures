package Gert_Learning.Mockito;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Gert_Learning.Mockito.ToDoService;
import Gert_Learning.Mockito.ToDoServiceStub;

public class ToDoBusinessImplStub {
	
	@Test
	public void usingAStub () 
	{
		ToDoService todoService = new ToDoServiceStub();
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
		List <String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Range");
		assertEquals(2, todos.size());
	}


}
