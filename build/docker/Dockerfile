FROM hellojava:latest
MAINTAINER nikita
ADD workShopTelegram-0.0.1-SNAPSHOT.tar /
ENTRYPOINT ["/workShopTelegram-0.0.1-SNAPSHOT/bin/workShopTelegram"]
EXPOSE 8080
RUN sed -i -e 's/# en_US.UTF-8 UTF-8/en_US.UTF-8 UTF-8/' /etc/locale.gen && \
    locale-gen
ENV LANG en_US.UTF-8  
ENV LANGUAGE en_US:en  
ENV LC_ALL en_US.UTF-8  
