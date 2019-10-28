package neaos.marathon.client.model.v2;

import cloudnil.marathon.client.utils.ModelUtils;

import java.util.Collection;

public class DeleteAppTasksResponse {
	private Collection<Task> tasks;

	public Collection<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Collection<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

}
