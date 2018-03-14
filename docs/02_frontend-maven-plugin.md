# Using frontend-maven-plugin to Integrate with Node.js

## Setup frontend-maven-plugin in pom.xml

To use frontend-maven-plugin, define these properties in pom.xml `properties` section:
```xml
<!-- for frontend plugins -->
<frontend-maven-plugin.version>1.6</frontend-maven-plugin.version>
<node.version>v8.10.0</node.version>
<npm.version>5.6.0</npm.version>
```

Then, define the plugin in `build/plugins`
```xml
<!-- Frontend Maven Plugin -->
<plugin>
    <groupId>com.github.eirslett</groupId>
    <artifactId>frontend-maven-plugin</artifactId>
    <version>${frontend-maven-plugin.version}</version>
    <configuration>
        <installDirectory>target</installDirectory>
        <workingDirectory>src/main/webapp/app</workingDirectory>
    </configuration>
    <executions>
        <execution>
            <id>install node and npm</id>
            <goals>
                <goal>install-node-and-npm</goal>
            </goals>
            <configuration>
                <nodeVersion>${node.version}</nodeVersion>
                <npmVersion>${npm.version}</npmVersion>
                <nodeDownloadRoot>https://npm.taobao.org/mirrors/node/</nodeDownloadRoot>
                <npmDownloadRoot>https://registry.npm.taobao.org/npm/-/</npmDownloadRoot>
            </configuration>
        </execution>

        <execution>
            <id>npm install</id>
            <goals>
                <goal>npm</goal>
            </goals>
            <configuration>
                <npmInheritsProxyConfigFromMaven>false</npmInheritsProxyConfigFromMaven>
            </configuration>
        </execution>
    </executions>
</plugin>
```
This will:
1. Install node and npm in `src/main/webapp/app` folder.
1. run `npm install` to install all dependencies, depends on your `package.json`.
1. run `npm run build` to build production optimized frontend application.

It's just a simple version, we will modify it later to use more complex tools to satisfy more situation.

Here, it use NPM to to the package things. If you'd like to ues [Yarn](https://yarnpkg.com) (which is faster package tool and recommanded).
Simply change the goals to `yarn` and `install-node-and-yarn`, and set `yarnDownloadRoot` as `https://npm.taobao.org/mirrors/yarn/`.

> _Notice:_ The xxxDownloadRoot is just needed when you have issue on visiting the official download site such as in GFW of China.

## TODO

```xml
<execution>
    <id>build</id>
    <goals>
        <goal>npm</goal>
    </goals>
    <configuration>
        <arguments>run build</arguments>
    </configuration>
</execution>
```
```xml
<!-- Frontend Maven Plugin -->
<plugin>
    <groupId>com.github.eirslett</groupId>
    <artifactId>frontend-maven-plugin</artifactId>
    <version>${frontend-maven-plugin.version}</version>
    <configuration>
        <installDirectory>target</installDirectory>
        <!--<workingDirectory>src/main/webapp/app</workingDirectory>-->
    </configuration>
    <executions>
        <execution>
            <id>install node and npm</id>
            <goals>
                <goal>install-node-and-npm</goal>
            </goals>
            <configuration>
                <nodeVersion>${node.version}</nodeVersion>
                <npmVersion>${npm.version}</npmVersion>
                <nodeDownloadRoot>https://npm.taobao.org/mirrors/node/</nodeDownloadRoot>
                <npmDownloadRoot>https://registry.npm.taobao.org/npm/-/</npmDownloadRoot>
            </configuration>
        </execution>

        <execution>
            <id>npm install</id>
            <goals>
                <goal>npm</goal>
            </goals>
            <configuration>
                <npmInheritsProxyConfigFromMaven>false</npmInheritsProxyConfigFromMaven>
            </configuration>
        </execution>

        <execution>
            <id>webpack build</id>
            <goals>
                <goal>webpack</goal>
            </goals>
        </execution>

    </executions>
</plugin>
```

## create-react-app tool

Before we can setup package.json, It's recommanded to use [create-react-app](https://github.com/facebook/create-react-app) tool to generate our first React application.

**Install create-react-app tool**
```shell
# Preferred - it's faster
yarn global install create-react-app
# Also works:
npm install --global create-react-app
```
Or you can follow it's newest guide:
```shell
npx create-react-app my-app
cd my-app
npm start
```
(npx comes with npm 5.2+ and higher)

When installed, create a sample project:
```shell
npx create-react-app my-app
# Or if you don't have the npx tool
create-react-app app --verbose
```

All done. Just go in, install dependencies, run:
```shell
cd my-app
npm start
# Or
yarn start
```

Visit http://localhost:3000, you will see your `Welcome to React` text.

## Setup package.json

To setup the `package.json` file, 


## Copy resources