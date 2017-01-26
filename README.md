# openjdk18-s2i-example
 A simple SpringBoot application that is deployed into OpenShift using fabric8 maven plugin.

 ##Setup
 * Go to springboot-hello-world dir: `cd springboot-hello-world`
 * Login to your OpenShift instance: `oc login "YOUR_OS_INSTANCE"`
 * Create your project: `oc new-project "YOUR_PROJECT_NAME""`
 * Run `mvn clean fabric8:deploy -Dfabric8.generator.from=DOCKER_IMAGE`
 * Get host from route: `oc get route`
 * Put the host of the route to your browser, you should get "Hello world!"