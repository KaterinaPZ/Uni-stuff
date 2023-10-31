# Docker

## Docker Container
An isolated, runnable environment that holds everything needed to run an application.

## Docker Image
A lightweight, standalone package that contains all necessary code, libraries, and dependencies to run an application.

- docker run [name] - Docker has now already downloaded the image locally, and can therefore execute the container straight away
- docker pull [name] - The pull command fetches the [name] image from the Docker registry and saves it in your system
- docker image ls - command to see a list of all images on your system.
- docker run [name] ls -l - run docker based on image [name]
- docker run [name] echo "hello from [name]" - In this case, the Docker client ran the `echo` command in our alpine container and then exited it.
- docker run -it [name] /bin/sh - The flags -it are short for -i -t which again are the short forms of --interactive (Keep STDIN open) and --tty (Allocate a terminal) - Exit out of the container by giving the exit command.
- docker ps - shows you all containers that are currently running.
- docker ps -a - listing all containers, both stopped and started

All containers have an ID and a name. Both the ID and name is generated every time a new container spins up with a random seed for uniqueness.

- docker run --name - If you want to assign a specific name to a container then you can use the --name option. That can make it easier for you to reference the container going forward.

- docker run --rm -it [name] - If you are creating a lot of new containers eg. to test something, you can tell the Docker daemon to remove the container once stopped
- docker image rm [ID] - ou deleted the container instance above, but not the image so to remove the image use the docker image rm command together with the id of the docker image
What docker did here was to untag the image removing the references to the sha of the image. After the image has no references, it deletes the two layers the image itself is comprised of.

When building, running and rebuilding images, you download and store a lot of layers. These layers will not be deleted, as docker takes a very conservative approach to clean up
Docker provides a prune command, taking all dangling containers/images/networks/volumes.

docker container prune
docker image prune
docker network prune
docker volume prune

The docker image prune command allows you to clean up unused images. By default, docker image prune only cleans up dangling images. A dangling image is one that is not tagged and is not referenced by any container. To remove all unused resources, resources that are not directly used by any existing containers, use the -a switch as well.

If you want a general cleanup, then docker system prune is your friend.

# Docker Cheatsheet

### Containers
-docker run --name <container_name> <image_name> - Create and run a container from an image, with a custom name
-docker run -p <host_port>:<container_port> <image_name> - Run a container and publish a container’s port(s) to the host
-docker run -d <image_name> - Run a container in the background
-docker start|stop <container_name> (or <container-id>) - Start or stop an existing container
-docker rm <container_name> - Remove a stopped container
-docker exec -it <container_name> sh - Open a shell inside a running container
-docker logs -f <container_name> - Fetch and follow the logs of a container
-docker inspect <container_name> (or <container_id>) - Inspect a running container
-docker ps - List currently running containers
-docker ps --all - List all docker containers (running and stopped)
-docker container stats - View resource usage stats

### Images
-docker build -t <image_name> - Build an Image from a Dockerfile
-docker build -t <image_name> . --no-cache - Build an Image from a Dockerfile without the cache
-docker images - List local images
-docker rmi <image_name> - Delete an Image
-docker image prune - Remove all unused images

### Docker Registries
-docker login -u <username> - Login into Docker
-docker push <username>/<image_name> - Publish an image to Docker Hub
-docker search <image_name> - Search Hub for an image
-docker pull <image_name> - Pull an image from Docker Hub
-docker tag <image_name>:<tag> <username>/<image_name>:<tag> - Tag an image for a registry
