package com.verizon.tls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.tls.Model.Customer;
import com.verizon.tls.Model.Plans;
import com.verizon.tls.Service.CustomerServImpl;
import com.verizon.tls.Service.CustomerService;
import com.verizon.tls.Service.PlansServImpl;
import com.verizon.tls.Service.PlansService;
import com.verizon.tls.restApi.TaranginiApi;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaranginiApi.class)
public class TaranginiApiUnitTest {
	
		private MockMvc mockMvc;

		@Autowired
		private WebApplicationContext webApplicationContext;

		@MockBean
		private  CustomerService cusServMock;
		
		@MockBean
		private  PlansService plansServMock;

		@Before
		public void setUp() {
			mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}

		@After
		public void tearDown() {
			mockMvc = null;
		}

		@Test
		public void testGetAllPlans() throws Exception {
			assertThat(this.plansServMock).isNotNull();

			List<Plans> plansList = new ArrayList<>();
			plansList.add(new Plans());

			when(plansServMock.getAllPlans()).thenReturn(plansList);

			mockMvc.perform(get("/Tarangini")).andExpect(status().isOk()).andDo(print());

		}

		@Test
		public void testGetCustomerById() throws Exception {
			assertThat(this.cusServMock).isNotNull();
			
			int orderNum=1;

			Customer cust=new Customer();
			
			cust.setOrderNumber(1);
			cust.setMobile(87878787);
			cust.setAddress("Chennai");
			cust.setName("Herooo");
			cust.setPkgId("TL#450");
			cust.setTime("12-3");
			cust.setDateOfRequest(null);
			
			when(cusServMock.getCustomerByOrderNumber(orderNum)).thenReturn(cust);

			mockMvc.perform(get("/Tarangini/1")).andExpect(status().isOk()).andDo(print());

		}

		@Test
		public void testGetAllPlanss() throws Exception {
			assertThat(this.plansServMock).isNotNull();

			int charge=1000;
			int speed=100;
			int usage=1000;
			
			List<Plans> plansList = new ArrayList<>();
			plansList.add(new Plans());

			when(plansServMock.findAllByChargePerMonth(charge)).thenReturn(plansList);
			when(plansServMock.findAllByMaxSpeed(speed)).thenReturn(plansList);
			when(plansServMock.findAllByMaxUsage(usage)).thenReturn(plansList);
			
			
			mockMvc.perform(get("/Tarangini/maxSpeed/100")).andExpect(status().isOk()).andDo(print());

		}

		@Test
		public void testAddCustomer() throws Exception {
			assertThat(this.cusServMock).isNotNull();

			Customer cust=new Customer();
			
			cust.setMobile(444360814);
			cust.setAddress("Chennai");
			cust.setName("Yash");
			cust.setPkgId("TPL-50-599");
			cust.setTime("12-3");
			cust.setDateOfRequest(null);
		

			Customer custAdded=new Customer();
			

			when(cusServMock.addCustomer(Mockito.any(Customer.class))).thenReturn(custAdded);

			mockMvc.perform(post("/Tarangini")
					.contentType(TestUtil.APPLICATION_JSON_UTF8)
					.content(TestUtil.convertObjectToJsonBytes(cust))).andDo(print()).andExpect(status().isOk())
					.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

		}

}