package com.yash.springpemapp.controller;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.glass.ui.Size;
import com.yash.springpemapp.domain.Expense;
import com.yash.springpemapp.service.ExpenseService;

public class ExpenseControllerUnitTest {

	private MockMvc mockmvc;
	
	@Mock
	private ExpenseService expenseService;
	
	@InjectMocks
	private ExpenseController expenseController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(expenseController).build();
	}
	
	@Test
	public void getAllExpenses_ShouldGiveListOf() throws Exception {
		List<Expense> expenses = Arrays.asList(new Expense(1, 4, 200, Date.valueOf("2018-06-09"), "food expenses"),
					  new Expense(5, 4, 200, Date.valueOf("2018-06-09"), "food expenses"));
		
		when(expenseService.findAll()).thenReturn(expenses);
		
		mockmvc.perform(get("/expenses"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].remark", is("food expenses")))
                .andExpect(jsonPath("$[1].id", is(5)))
                .andExpect(jsonPath("$[1].remark", is("food expenses")));
		
		verify(expenseService, times(1)).findAll();
        verifyNoMoreInteractions(expenseService);
			
	}
	
	@Test
	public void updateExpense_ExpenseGiven_ShouldReturnStatusOk() throws Exception {
		Expense expense = new Expense(3, 4, 200, Date.valueOf("2018-06-3"), "food expenses");
		
		when(expenseService.findById(expense.getId())).thenReturn(expense);
		doNothing().when(expenseService).update(expense);
		
		mockmvc.perform(
				put("/expense")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(expense)))
			.andExpect(status().isOk());
		
		verify(expenseService, times(1)).findById(expense.getId());
        verify(expenseService, times(1)).update(expense);
        verifyNoMoreInteractions(expenseService);
	}

	@Test
	public void updateExpense_WhenExpenseNotFound_ShouldReturnStatusNot_Found() throws Exception {
		Expense expense = new Expense(0, 4, 200, Date.valueOf("2018-06-09"), "food expenses");
		
		when(expenseService.findById(expense.getId())).thenReturn(null);
		
		mockmvc.perform(
				put("/expense")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(expense)))
				.andExpect(status().isNotFound());
		
		verify(expenseService, times(1)).findById(expense.getId());
		verifyNoMoreInteractions(expenseService);
		
	}
	
	public static String asJsonString(Expense expense) {
		try {
            return new ObjectMapper().writeValueAsString(expense);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	
}
