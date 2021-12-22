FROM markhobson/maven-chrome:latest

ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

COPY ./ /tests
COPY pom.xml /tests
WORKDIR /tests

ADD start.sh /
RUN chmod +x /start.sh

CMD ["/start.sh"]
