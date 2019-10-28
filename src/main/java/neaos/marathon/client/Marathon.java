package neaos.marathon.client;

import cloudnil.marathon.client.model.v2.*;
import cloudnil.marathon.client.utils.MarathonException;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface Marathon {
    // Apps
	@RequestLine("GET /v2/apps")
	GetAppsResponse getApps();
	
	@RequestLine("POST /v2/apps")
	App createApp(App app) throws MarathonException;
	
	@RequestLine("PUT /v2/apps")
	void updateApps(List<App> app) throws MarathonException;

	//App
	@RequestLine("GET /v2/apps/{id}")
	GetAppResponse getApp(@Param("id") String id) throws MarathonException;
	
	@RequestLine("PUT /v2/apps/{app_id}")
	void updateApp(@Param("app_id") String appId, App app);
	
	@RequestLine("DELETE /v2/apps/{id}")
	Result deleteApp(@Param("id") String id) throws MarathonException;

	@RequestLine("POST /v2/apps/{id}/restart?force={force}")
	void restartApp(@Param("id") String id, @Param("force") boolean force);

	@RequestLine("GET /v2/apps/{id}/tasks")
	GetAppTasksResponse getAppTasks(@Param("id") String id) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{app_id}/tasks?host={host}&scale={scale}")
	DeleteAppTasksResponse deleteAppTasks(@Param("app_id") String appId, @Param("host") String host, @Param("scale") String scale);

	@RequestLine("DELETE /v2/apps/{app_id}/tasks/{task_id}?scale={scale}")
	DeleteAppTaskResponse deleteAppTask(@Param("app_id") String appId, @Param("task_id") String taskId, @Param("scale") String scale);

	@RequestLine("GET /v2/apps/{app_id}/versions")
	GetAppVersionsResponse getAppVersions(@Param("id") String id);

	@RequestLine("GET /v2/apps/{app_id}/versions/{version}")
	App getAppVersion(@Param("id") String id, @Param("version") String version);

	// Deployments
	@RequestLine("GET /v2/deployments")
    List<Deployment> getDeployments();

	@RequestLine("DELETE /v2/deployments/{deploymentId}?force={force}")
	void deleteDeployment(@Param("deploymentId") String id, @Param("force") boolean force);

    // Groups
	@RequestLine("GET /v2/groups")
	GetGroupsResponse getGroups() throws MarathonException;
	
	@RequestLine("POST /v2/groups")
	Result createGroup(Group group) throws MarathonException;
	
	@RequestLine("GET /v2/groups/{id}")
	Group getGroup(@Param("id") String id) throws MarathonException;
	
	@RequestLine("PUT /v2/groups/{id}")
	Result updateGroup(@Param("id") String id, Group group) throws MarathonException;
	
	@RequestLine("DELETE /v2/groups/{id}")
	Result deleteGroup(@Param("id") String id) throws MarathonException;
	
    // Tasks
	@RequestLine("GET /v2/tasks")
	GetTasksResponse getTasks();
	
    // Event Subscriptions

    @RequestLine("POST /v2/eventSubscriptions?callbackUrl={url}")
    public GetEventSubscriptionRegisterResponse register(@Param("url") String url);

    @RequestLine("DELETE /v2/eventSubscriptions?callbackUrl={url}")
    public GetEventSubscriptionRegisterResponse unregister(@Param("url") String url);

    @RequestLine("GET /v2/eventSubscriptions")
    public GetEventSubscriptionsResponse subscriptions();

    // Queue

    // Server Info
    @RequestLine("GET /v2/info")
    GetServerInfoResponse getServerInfo();
    
    @RequestLine("GET /v2/leader")
    GetServerInfoResponse getLeader();

    // Miscellaneous
}
