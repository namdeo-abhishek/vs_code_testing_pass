package com.example.teams;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.teams.entity.Teams;
import com.example.teams.service.TeamsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AppTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
    private MockMvc mockMvc;
    
    @MockBean
	private TeamsService teamsService;

    @BeforeEach
    public void setUp() throws Exception {
    	
    }


	@Test
	public void testGetAllTeamsResponseEmpty() throws Exception {

		List<Teams> teams = Arrays.asList();
		
		Mockito.when( teamsService.getAllTeams() ).thenReturn(teams);

		mockMvc.perform(MockMvcRequestBuilders
                .get("/winning_teams")
                .contentType(MediaType.APPLICATION_JSON)) 
                .andExpect(status().isNotFound());
		
	}
    
    @Test
	public void testGetAllWinningTeams() throws Exception {
		
	    Teams teams = new Teams();
		teams.setTeamName("RR");
		teams.setRuns(185);
		teams.setTargetRuns(170);
		teams.setYear(2011);

		Teams teams1 = new Teams();
		teams1.setTeamName("KKR");
		teams1.setRuns(120);
		teams1.setTargetRuns(130);
		teams1.setYear(2013);

			
		List<Teams> team = new ArrayList<>();
		team.add(teams);
		team.add(teams1);
		
		List<Teams> teamRes = new ArrayList<>();
		teamRes.add(teams);
	
		
		Mockito.when( teamsService.getAllTeams() ).thenReturn(team);
		
		String URI = "/winning_teams";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(teamRes);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void testGetAllWinningTeamsOK() throws Exception {
		
		Teams teams = new Teams();
		teams.setTeamName("RR");
		teams.setRuns(185);
		teams.setTargetRuns(170);
		teams.setYear(2011);

		Teams teams1 = new Teams();
		teams1.setTeamName("KKR");
		teams1.setRuns(120);
		teams1.setTargetRuns(130);
		teams1.setYear(2013);

			
		List<Teams> team = new ArrayList<>();
		team.add(teams);
		team.add(teams1);
		
		List<Teams> teamRes = new ArrayList<>();
		teamRes.add(teams);

		
		Mockito.when( teamsService.getAllTeams() ).thenReturn(team);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/winning_teams")
				.contentType(MediaType.APPLICATION_JSON)) 
				.andExpect(status().isOk());
	}
	
	@Test
	public void testGetAll2013Teams() throws Exception {
		
	    Teams teams = new Teams();
		teams.setTeamName("RR");
		teams.setRuns(185);
		teams.setTargetRuns(170);
		teams.setYear(2011);

		Teams teams1 = new Teams();
		teams1.setTeamName("KKR");
		teams1.setRuns(120);
		teams1.setTargetRuns(130);
		teams1.setYear(2013);

			
		List<Teams> team = new ArrayList<>();
		team.add(teams);
		team.add(teams1);
		
		List<Teams> teamRes = new ArrayList<>();
		teamRes.add(teams1);
	
		
		Mockito.when( teamsService.getAllTeams() ).thenReturn(team);
		
		String URI = "/team_2013";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(teamRes);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void testGetAll2013TeamsOK() throws Exception {
		
	    Teams teams = new Teams();
		teams.setTeamName("RR");
		teams.setRuns(185);
		teams.setTargetRuns(170);
		teams.setYear(2011);

		Teams teams1 = new Teams();
		teams1.setTeamName("KKR");
		teams1.setRuns(120);
		teams1.setTargetRuns(130);
		teams1.setYear(2013);

			
		List<Teams> team = new ArrayList<>();
		team.add(teams);
		team.add(teams1);
		
		List<Teams> teamRes = new ArrayList<>();
		teamRes.add(teams1);
	
		
		Mockito.when( teamsService.getAllTeams() ).thenReturn(team);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/team_2013")
				.contentType(MediaType.APPLICATION_JSON)) 
				.andExpect(status().isOk());
	}
  
	@Test
	public void testGetAll2013TeamsResponseEmpty() throws Exception {

		List<Teams> teams = Arrays.asList();
		
		Mockito.when( teamsService.getAllTeams() ).thenReturn(teams);

		mockMvc.perform(MockMvcRequestBuilders
                .get("/winning_teams")
                .contentType(MediaType.APPLICATION_JSON)) 
                .andExpect(status().isNotFound());
		
	}
  
    private String mapToJson(List<Teams> teams) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(teams);
	}

}
