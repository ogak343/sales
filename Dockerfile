FROM ubuntu:latest
LABEL authors="khamd"

ENTRYPOINT ["top", "-b"]