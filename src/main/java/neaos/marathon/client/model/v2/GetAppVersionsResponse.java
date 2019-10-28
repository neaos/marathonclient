package neaos.marathon.client.model.v2;

import cloudnil.marathon.client.utils.ModelUtils;

public class GetAppVersionsResponse {
	private String[] versions;
	public String[] getVersions() {
		return versions;
	}
	public void setVersions(String[] versions) {
		this.versions = versions;
	}
	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
