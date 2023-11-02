# Git commands
- new commit
```
git commit 
```
- git branch [name] - makes new branch
- git checkout [name] - goes to that branch
- git checkout -b [name] - creates new branch and goes to it
- git merge [name] - /name of the branch we want main to be merged with/ - Merging in Git creates a special commit that has two unique parents
- git rebase [name] - Rebasing essentially takes a set of commits, "copies" them, and plops them down somewhere else -/if we rebase main we need to move the main to the branch with rebase/
- HEAD is the symbolic name for the currently checked out commit -- it's essentially what commit you're working on top of. HEAD always points to the most recent commit which is reflected in the working tree. Normally HEAD points to a branch name (like bugFix). When you commit, the status of bugFix is altered and this change is visible through HEAD
- git checkout [branch hash name] - detach head
- git log - see hashes
- git checkout main^ -the first parent of main / ^ - Moving upwards one commit at a time with / - moves HEAD
- git checkout HEAD~4 - ~<num> - Moving upwards a number of times with
- git branch -f main HEAD~3 - moves (by force) the main branch to three parents behind HEAD
- git reset - reverses changes by moving a branch reference backwards in time to an older commit - will move a branch backwards as if the commit had never been made in the first place.        both HEAD MUST BE ON IT - git reset HEAD~1 / removes 1/
- git revert - In order to reverse changes and share those reversed changes with others - With reverting, you can push out your changes to share with others - git revert HEAD
- git cherry-pick <Commit1> <Commit2> <...>

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
