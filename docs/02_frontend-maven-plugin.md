# Using frontend-maven-plugin to Integrate with Node.js

## Install Node.js and NPM, or Yarn

Go to it's official website: https://nodejs.org/en/ , and download LTS version Node.js, the NPM will be installed along with the Node.js.
After installation, test with: `node -v` and `npm -v`.

If you'd like to install `Yarn` (Optional, but recommended), go: https://yarnpkg.com/ and install it's newest version. Then test: `yarn -v`.

TODO: taobao repo

## Setup frontend-maven-plugin in pom.xml

To use [frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin), define these properties in pom.xml `properties` section: (check out it's newest version at [here](https://github.com/eirslett/frontend-maven-plugin/releases))
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

## Using Yarn

Here, it use NPM to to the package things. If you'd like to ues [Yarn](https://yarnpkg.com) (which is faster package tool and recommanded).
Simply change the goals to `yarn` and `install-node-and-yarn`, and set `yarnDownloadRoot` as `https://npm.taobao.org/mirrors/yarn/`.
v1.5.1

(change npm - run build, to yarn - build)
workingDirectory
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

Before we can setup package.json, It's recommended to use [create-react-app](https://github.com/facebook/create-react-app) tool to generate our first React application.

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

Now copy the project source code created by create-react-app tool to our webapp/app/ folder.
And don't copy the .gitignore file.

```text
│  package.json
│  README.md
│  yarn.lock
│
├─node_modules
│      ...
│
├─public
│      favicon.ico
│      index.html
│      manifest.json
│
└─src
        App.css
        App.js
        App.test.js
        index.css
        index.js
        logo.svg
        registerServiceWorker.js
```

## Copy resources

plugin

Checkout it's newest version at [here](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22maven-resources-plugin%22) or [here](https://maven.apache.org/plugins/maven-resources-plugin/download.cgi)

```xml
<!-- copy resource -->
<plugin>
    <artifactId>maven-resources-plugin</artifactId>
    <version>3.0.2</version>
    <executions>
        <execution>
            <id>Copy frontend production build to resources</id>
            <phase>generate-resources</phase>
            <goals>
                <goal>copy-resources</goal>
            </goals>
            <configuration>
                <outputDirectory>${basedir}/target/classes/static</outputDirectory>
                <resources>
                    <resource>
                        <directory>src/main/webapp/app/build/</directory>
                        <filtering>true</filtering>
                    </resource>
                </resources>
            </configuration>
        </execution>
    </executions>
</plugin>
```

build -> dist
