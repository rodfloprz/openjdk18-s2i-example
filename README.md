# openjdk18-s2i-example
A simple SpringBoot application that is deployed into OpenShift v3.4 with Java S2I image.

## Setup
Clone this git repository: `git clone https://github.com/RadekKoubsky/openjdk18-s2i-example.git`

The application can be deployed in various ways. The following steps describe how to deploy the application using
Source-to-Image (S2I) Build, Binary Build or fabcir8-maven-plugin.

### Source-to-Image (S2I) Build
We will provide this github repository and the openjdk docker image to the [S2I build](https://docs.openshift.com/container-platform/3.4/architecture/core_concepts/builds_and_image_streams.html#source-build) that builds the application from source code.

Log in to your OpenShift instance and create your project:

 * `oc login "YOUR_OS_INSTANCE"`
 * `oc new-project "YOUR_PROJECT_NAME""`

The following command creates the OpenShift application with all resources:

`oc new-app https://github.com/RadekKoubsky/openjdk18-s2i-example.git --context-dir=springboot-hello-world registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:latest --allow-missing-images --insecure-registry=true`

To access the application, we need to expose its service via route:

* `oc expose svc/openjdk18-s2i-example --port=8080`
* Get host from route: `oc get route`
* Put the host of the route to your browser, you should get "Hello world!"

### Binary build
We will use [Binary build](https://docs.openshift.com/container-platform/3.4/dev_guide/builds.html#binary-source) to deploy the application from provided _.jar_ file placed in _/deployments_ directory in our git repository. The jar file is result of the `mvn clean package` command from the springboot-hello-world directory.

* Create an image stream: `oc create -f image-stream.json`
* Create Binary build: `oc new-build --binary=true --name=openjdk18-s2i-example -i=openjdk18-openshift`
* Start the build: `oc start-build openjdk18-s2i-example --from-dir=. --follow`
* Create the OpenShift application: `oc new-app openjdk18-s2i-example`
* `oc expose svc/openjdk18-s2i-example --port=8080`
* Get host from route: `oc get route`
* Put the host of the route to your browser, you should get "Hello world!"

### Use fabric8-maven-plugin
This step uses the [fabric8-maven-plugin](https://maven.fabric8.io/) to deploy the application from Maven.

 * Go to springboot-hello-world dir: `cd springboot-hello-world`
 * Login to your OpenShift instance: `oc login "YOUR_OS_INSTANCE"`
 * Create your project: `oc new-project "YOUR_PROJECT_NAME""`
 * Run `mvn clean fabric8:deploy -Dfabric8.generator.from=YOUR_DOCKER_IMAGE`
 * Get host from route: `oc get route`
 * Put the host of the route to your browser, you should get "Hello world!"
