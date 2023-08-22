package com.plugin.kubernetesnamespace;

import com.dtolabs.rundeck.core.execution.ExecutionLifecyclePluginException;
import com.dtolabs.rundeck.core.jobs.ExecutionLifecycleStatus;
import com.dtolabs.rundeck.core.jobs.JobExecutionEvent;
import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.descriptions.PluginDescription;
import com.dtolabs.rundeck.plugins.jobs.ExecutionLifecyclePlugin;

@Plugin(name = "kubernetesnamespacevalidator", service = ServiceNameConstants.ExecutionLifecycle)
@PluginDescription(title = "Check if Kubernetes Namespace exists", description = "Adds extra logging before/after the execution, and appends XKCD comic.")
public class KubernetesnamespaceValidator implements ExecutionLifecyclePlugin {
    @Override
    public ExecutionLifecycleStatus beforeJobStarts(JobExecutionEvent event) throws ExecutionLifecyclePluginException {

        String name = event.getUserName();
        event.getExecutionLogger().log(1, String.format("Beginning the job for %s!", name));

        return null;
    }

    @Override
    public ExecutionLifecycleStatus afterJobEnds(JobExecutionEvent event) throws ExecutionLifecyclePluginException {

        String name = event.getUserName();
        event.getExecutionLogger().log(1, String.format("Ends the job for %s!", name));

        return null;
    }
}
