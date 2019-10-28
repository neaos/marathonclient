package neaos.marathon.client.model.v2;

import cloudnil.marathon.client.utils.ModelUtils;

public class GetLeaderResponse {
	private String leader;

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
