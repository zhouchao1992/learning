# 这个是一个完整的docler-compose部署的项目

## 该项目是个spring boot项目，基于docker-compose自动化部署的

###配置步骤：
1. 在pom.xml文件中加入打包的插件 内容如下：
     
            <!-- Docker -->
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>1.0.0</version>
                <!-- 将插件绑定在某个phase执行 -->
                <executions>
                    <execution>
                        <id>build-image</id>
                        <!-- 用户只需执行mvn package ，就会自动执行mvn docker:build -->
                        <phase>package</phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <!-- 指定生成的镜像名 -->
                    <imageName>${docker.image.prefix}/${project.artifactId}:${project.version}</imageName>
                    <!-- 指定标签 -->
                    <imageTags>
                        <imageTag>${project.version}</imageTag>
                    </imageTags>
                    <!-- 指定 Dockerfile 路径 -->
                    <dockerDirectory>src/main/docker</dockerDirectory>
                    <!-- 指定远程 docker api地址 -->
                    <dockerHost>http://129.28.158.68:2375</dockerHost>
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <!-- jar包所在的路径此处配置的对应target目录 -->
                            <directory>${project.build.directory}</directory>
                            <!-- 需要包含的jar包,这里对应的是Dockerfile中添加的文件名　-->
                            <include>${project.build.finalName}.jar</include>
                        </resource>
                    </resources>
                </configuration>
            </plugin>

2.在项目的src/main/下面建立docker文件夹在docker目录下创建Dockerfile文件，文件内容如下：<br/>
    FROM java:8<br/>
    VOLUME /tmp<br/>
    ADD dockercompose-0.0.1-SNAPSHOT.jar dockercompose-0.0.1-SNAPSHOT.jar<br/>
    ENTRYPOINT ["java","-jar","/dockercompose-0.0.1-SNAPSHOT.jar"]<br/>
    
3.执行maven的package命令进行build  把项目进行构建成镜像发布到远程服务器上  ，可以执行docker images命令查看生成的镜像文件

4.配置docker-compose.yml文件   将文件传到服务器上执行docker-compose up 命令
