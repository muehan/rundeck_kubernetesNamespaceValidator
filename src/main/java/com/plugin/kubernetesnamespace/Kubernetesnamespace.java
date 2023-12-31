package com.plugin.kubernetesnamespace;

import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.core.plugins.configuration.Describable;
import com.dtolabs.rundeck.core.plugins.configuration.Description;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.descriptions.PluginDescription;
import com.dtolabs.rundeck.plugins.option.OptionValue;
import com.dtolabs.rundeck.plugins.option.OptionValuesPlugin;
import com.dtolabs.rundeck.plugins.util.DescriptionBuilder;
import com.dtolabs.rundeck.plugins.util.PropertyBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Plugin(service=ServiceNameConstants.OptionValues,name="kubernetesnamespace")
@PluginDescription(title="kubernetesNamespace", description="My Option plugin description")
public class Kubernetesnamespace implements OptionValuesPlugin, Describable{

    public static final String SERVICE_PROVIDER_NAME = "kubernetesnamespace";

   /**
     * Overriding this method gives the plugin a chance to take part in building the {@link
     * com.dtolabs.rundeck.core.plugins.configuration.Description} presented by this plugin.  This subclass can use the
     * {@link DescriptionBuilder} to modify all aspects of the description, add or remove properties, etc.
     */
   @Override
   public Description getDescription() {
        return DescriptionBuilder.builder()
            .name(SERVICE_PROVIDER_NAME)
            .title("kubernetesNamespace")
            .description("Example Workflow Step")
            .property(PropertyBuilder.builder()
                          .string("example")
                          .title("Example String")
                          .description("Example description")
                          .required(false)
                          .build()
            )
            .property(PropertyBuilder.builder()
                          .booleanType("exampleBoolean")
                          .title("Example Boolean")
                          .description("Example Boolean?")
                          .required(false)
                          .defaultValue("false")
                          .build()
            )
            .build();
   }

   @Override
   public List<OptionValue> getOptionValues(final Map config) {
       List<OptionValue> options = new ArrayList<>();
       options.add(new StandardOptionValue("Alpha","alpha"));
       options.add(new StandardOptionValue("Beta","beta"));
       options.add(new StandardOptionValue("Gamma","gamma"));
       return options;
   }

   class StandardOptionValue implements OptionValue {

       private String name;
       private String value;
       StandardOptionValue(String name, String value) {
           this.name = name;
           this.value = value;
       }
       @Override
       public String getName() {
           return name;
       }

       @Override
       public String getValue() {
           return value;
       }
   }

}