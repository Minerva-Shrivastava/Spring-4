package com.yash.springpemapp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.springpemapp.domain.Expense;
import com.yash.springpemapp.service.ExpenseService;

public class ExpenseControllerUnitTest {

	private MockMvc mockMvc;
	
	@Mock
	private ExpenseService expenseService;
	
	@InjectMocks
	private ExpenseController expenseController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
	}
	
	@Test
	public void getAllExpenses_ShouldGiveListOfExpenses() throws Exception {
		List<Expense> expenses = Arrays.asList(new Expense(1, 4, 200, Date.valueOf("2018-06-09"), "food expenses"),
					  new Expense(5, 4, 200, Date.valueOf("2018-06-09"), "food expenses"));
		
		when(expenseService.findAll()).thenReturn(expenses);
		
		mockMvc.perform(get("/expenses"))
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
	public void findById_ExpenseIdGiven_ShouldReturnExpenseOfThatId() throws Exception {
		Expense expense = new Expense(1, 4, 200, Date.valueOf("2018-06-09"), "Food Expenses");
		
		when(expenseService.findById(expense.getId())).thenReturn(expense);
		
		mockMvc.perform(get("/expense/{expenseId}", expense.getId()))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        		.andExpect(jsonPath("$.id", is(1)))
        		.andExpect(jsonPath("$.remark", is("Food Expenses")));
		
		verify(expenseService, times(1)).findById(1);
		verifyNoMoreInteractions(expenseService);
	}
	
	@Test
	public void findById_ExpenseInvalidIdGiven_ShouldReturnStatus_Not_Found() throws Exception {
		
		when(expenseService.findById(0)).thenReturn(null);
	    mockMvc.perform(get("/expense/{expenseId}", 0))
	            .andExpect(status().isNotFound());
	    
	    verify(expenseService, times(1)).findById(0);
	    verifyNoMoreInteractions(expenseService);
	    
	}
	
	@Test
	public void updateExpense_ExpenseGiven_ShouldReturnStatusOk() throws Exception {
		Expense expense = new Expense(3, 4, 200, Date.valueOf("2018-06-3"), "food expenses");
		
		when(expenseService.findById(expense.getId())).thenReturn(expense);
		doNothing().when(expenseService).update(expense);
		
		mockMvc.perform(
				put("/expense")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(expense)))
			.andExpect(status().isOk());
		
		verify(expenseService, times(1)).findById(expense.getId());
        verify(expenseService, times(1)).update(expense);
        verifyNoMoreInteractions(expenseService);
	}

	@Test
	public void updateExpense_WhenExpenseNotFound_ShouldReturnStatus_Not_Found() throws Exception {
		Expense expense = new Expense(0, 4, 200, Date.valueOf("2018-06-09"), "food expenses");
		
		when(expenseService.findById(expense.getId())).thenReturn(null);
		
		mockMvc.perform(
				put("/expense")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(expense)))
				.andExpect(status().isNotFound());
		
		verify(expenseService, times(1)).findById(expense.getId());
		verifyNoMoreInteractions(expenseService);
		
	}
	
	@Test
	public void deleteExpenseById_ExpenseIdGiven_ShouldReturnStatusOk() throws Exception {
		
	}
	
	public static String asJsonString(Expense expense) {
		try {
            return new ObjectMapper().writeValueAsString(expense);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	
}
