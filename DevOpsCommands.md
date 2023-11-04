# Git commands
```
git add .
git commit -m "[massege]"
git status
git push
```
- new commit
```
git commit 
```
- Update remote refs along with associated objects
```
git push
```
- clone a repository into a new directory
```
git clone [repo link]
```
-without arguments will update all the remote-tracking branches
```
git fetch
```
- without arguments will in addition merge the remote master branch into the current master branch
```
git pull
```
- makes new branch
```
git branch [name]
```
- goes to that branch
```
git checkout [name]
```
- creates new branch and goes to it
```
git checkout -b [name]
```
- /name of the branch we want main to be merged with/ - Merging in Git creates a special commit that has two unique parents
```
git merge [name]
```
- Rebasing essentially takes a set of commits, "copies" them, and plops them down somewhere else -/if we rebase main we need to move the main to the branch with rebase/
```
git rebase [name]
```
- HEAD is the symbolic name for the currently checked out commit -- it's essentially what commit you're working on top of. HEAD always points to the most recent commit which is reflected in the working tree. Normally HEAD points to a branch name (like bugFix). When you commit, the status of bugFix is altered and this change is visible through HEAD
- detach head
```
git checkout [branch hash name]
```
- see hashes
```
git log
```
-the first parent of main / ^ - Moving upwards one commit at a time with / - moves HEAD
```
git checkout main^
```
- ~<num> - Moving upwards a number of times with
```
git checkout HEAD~4
```
- moves (by force) the main branch to three parents behind HEAD
```
git branch -f main HEAD~3
```
- reverses changes by moving a branch reference backwards in time to an older commit - will move a branch backwards as if the commit had never been made in the first place.
```
git reset
```
```
both HEAD MUST BE ON IT - git reset HEAD~1 / removes 1/
```
- In order to reverse changes and share those reversed changes with others - With reverting, you can push out your changes to share with others - git revert HEAD
```
git revert
```
```
git cherry-pick <Commit1> <Commit2> <...>
```

# Docker
- go to directory path
```
cd /path/to/[name directory]
```

## Make Docker
- create docker file
```
touch Dockerfile
```
- docker file
```
FROM # base image
RUN # run a command
ADD and COPY # copy files into the image
CMD # run a command at start-up, but can be overridden
EXPOSE # expose a port
ENTRYPOINT # run a command at start-up
```
- Finally, the -t flag tags your image. Think of this as a human-readable name for the final image. Since you named the image [name] , you can refer to that image when you run a container.The . at the end of the docker build command tellsDocker that it should look for the Dockerfile in the current directory.
```
docker build -t [name] .
```
```
docker image ls
```
```
docker run -dp HOST:CONTAINER/PORT/  [name]
```
- see what your containers are taking up of space
```
docker container ls -as
```
- see the names of the containers
```
docker container ls -a
```
- list your containers
```
docker ps
```

## Delete Docker
- delete container
```
docker container rm [name]
```
- delete image
```
docker image rm [IMAGE ID]
```
```
cloudshell_open --repo_url
```

