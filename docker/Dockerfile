FROM rundeck/rundeck:4.15.0

COPY --chown=rundeck:root remco /etc/remco
COPY --chown=rundeck:root ./lib/rundeck_kubernetesNamespaceValidator-0.1.0.jar /home/rundeck/libext
# COPY --chown=rundeck:root volume/job-lifecycle-3.2.3-20200221.jar /home/rundeck/libext/