package com.plugin.kubernetesnamespace

import com.dtolabs.rundeck.plugins.step.PluginStepContext
import com.dtolabs.rundeck.core.execution.workflow.steps.StepException
import com.dtolabs.rundeck.plugins.PluginLogger
import spock.lang.Specification

class KubernetesnamespaceSpec extends Specification {

    def getContext(PluginLogger logger){
        Mock(PluginStepContext){
            getLogger()>>logger
        }
    }

    def "get options"(){
        given:

        def example = new Kubernetesnamespace()
        def configuration = [example:"example123",exampleBoolean:"false",]

        when:
        def options = example.getOptionValues(configuration)

        then:
        options.size() > 0
    }


}