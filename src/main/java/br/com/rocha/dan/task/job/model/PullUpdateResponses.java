package br.com.rocha.dan.task.job.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PullUpdateResponses {

	private List<PullUpdateResponse> pullUpdatesResponses;
	
	public PullUpdateResponses() {
		super();
		this.pullUpdatesResponses = new ArrayList();
	}
	
	public List<PullUpdateResponse> addPullUpdateResponse(PullUpdateResponse pullUpdateResponse) {
		pullUpdatesResponses.add(pullUpdateResponse);
		return pullUpdatesResponses;
	}
}
