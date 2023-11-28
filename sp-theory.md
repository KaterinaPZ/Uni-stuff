# read
ssize_t read(int fd, void buf[.count], size_t count);

четене от файлов дескриптор

## описание

read() се опитва да прочете до брой байтове [count] от файловия дескриптор fd в буфера започвайки от buf


При файлове, които поддържат търсене, операцията за четене започва от отместването на файла и изместването на файла се увеличава с числото прочетени байтове. Ако изместването на файла е в или след края на файла, не се четат байтове и read() връща нула.

Ако броячът е нула, read() може да открие грешките, описани по-долу. При липса на грешки или ако read() не проверява за грешки, read() с брой 0 връща нула и няма друг ефекти.

## връщане

При успех се връща броят на прочетените байтове (нула показва край на файла), а позицията на файла се придвижва напред с това число. Не е грешка, ако това число е по-малко от броя на искани байтове; това може да се случи например поради по-малко байтове всъщност са налични в момента (може би защото бяхме близо до край на файла, или защото четем от тръба, или от a терминал), или защото read() е прекъснат от сигнал.

При грешка се връща -1 и errno е настроено да указва грешката. В този случай остава неуточнено дали позицията на файла (ако има такива) промени.

## грешки

- EAGAIN - Файловият дескриптор fd се отнася до файл, различен от сокет и е маркиран като неблокиращ (O_NONBLOCK), и четенето ще блокира.
- EAGAIN or EWOULDBLOCK
- EBADF
- EFAULT
- EINTR
- EINVAL
- EINVAL
- EIO
- EISDIR - файловия дескриптор fd сочи към директория

# write
ssize_t write(int fd, const void buf[.count], size_t count);

# close
int close(int fd);

# open
int open(const char *pathname, int flags);
int open(const char *pathname, int flags, mode_t mode);

# lseek
off_t lseek(int fd, off_t offset, int whence);

# pipe
int pipe(int pipefd[2]);

# mkfifo
int mkfifo(const char *pathname, mode_t mode);

# stat
int stat(const char *restrict pathname, struct stat *restrict statbuf);

# chmod
int chmod(const char *pathname, mode_t mode);

# chown
int chown(const char *pathname, uid_t owner, gid_t group);

# unmask
mode_t umask(mode_t mask);

# utime
int utime(const char *filename, const struct utimbuf *_Nullable times);

# fcntl
int fcntl(int fd, int cmd, ... /* arg */ );

# dup
int dup(int oldfd);

# link
int link(const char *oldpath, const char *newpath);

# symlink
int symlink(const char *target, const char *linkpath);

# unlink
int unlink(const char *pathname);

# mkdir
int mkdir(const char *pathname, mode_t mode);

# rmdir
int rmdir(const char *pathname);

# chdir
int chdir(const char *path);

# opendir
DIR *opendir(const char *name);

# readdir
struct dirent *readdir(DIR *dirp);v

# closedir
int closedir(DIR *dirp);

# rewinddir
void rewinddir(DIR *dirp);

# fork

# exit

# atexit

# wait

# exec

# getpid

# getppid

# signal

# kill

# pause

# alarm

# socket

# connect

# bind

# listen 

# accept
