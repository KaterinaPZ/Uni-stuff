# Docker
- cd /path/to/[name directory]

## Make Docker
- touch Dockerfile - create docker file
- docker file
```
FROM # base image
RUN # run a command
ADD and COPY # copy files into the image
CMD # run a command at start-up, but can be overridden
EXPOSE # expose a port
ENTRYPOINT # run a command at start-up
```
- docker build -t [name] . - Finally, the -t flag tags your image. Think of this as a human-readable name for the final image. Since you named the image [name] , you can refer to that image when you run a container.The . at the end of the docker build command tellsDocker that it should look for the Dockerfile in the current directory.
- docker image ls
- docker run -dp HOST:CONTAINER/PORT/  getting-started
- docker container ls -as - see what your containers are taking up of space
-  docker container ls -a - see the names of the containers
- docker ps - list your containers

## Delete Docker
- docker container rm [name] - delete container
- docker image rm [IMAGE ID] - delete image
