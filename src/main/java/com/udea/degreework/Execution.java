package com.udea.degreework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Execution {
	private List<Team> teams = new ArrayList<Team>();
	private Map<String, Object> config = new HashMap<String, Object>();

	public Execution(List<Team> teams) {
		this.teams = teams;
	}

	public void loadConfig(Map<String, Object> config) {
		this.config = config;
		validateData();
	}

	public void start() {
		System.out.println("Starting execution");
	}

	private void validateData() {
		try {
			if (config.get("target") == null) {
				throw new Exception("Config: target is Expected");
			} else if (config.get("errorRange") == null) {
				throw new Exception("Config: errorRange is Expected");
			} 
//			else if (config.get("") == null) {
//				throw new Exception("Config:  is Expected");
//			}
			
			if(config.get("numberOfTeams") != null) {
				if(teams.size() != (int)config.get("numberOfTeams")) {
					throw new Exception("Config: the expected numberOfTeams is different from the declared teams");
				}
			}
			
			if (config.get("numberOfWorkersPerTeam") != null) {
				int numberOfWorkersPerTeam = (int) config.get("numberOfWorkersPerTeam");
				for (Team team : teams) {
					if (team.getWorkers().size() != numberOfWorkersPerTeam) {
						throw new Exception("Config: the expected numberOfWorkersPerTeam is different from the declared workers per team");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
