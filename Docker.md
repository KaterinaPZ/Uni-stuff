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


