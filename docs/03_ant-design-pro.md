# Ant Design Pro

## Ant Design

[Ant Design](https://ant.design/) is a design system with values of Nature and Determinacy for better user experience of enterprise applications.

## Ant Design Pro

[Ant Design Pro](https://pro.ant.design/) is an out-of-box UI solution for enterprise applications

### Install from github
```shell
$ git clone https://github.com/ant-design/ant-design-pro.git --depth=1
$ cd ant-design-pro

$ git clone --depth=1 https://github.com/ant-design/ant-design-pro.git my-project
$ cd my-project

$ npm install
$ npm start         # visit http://localhost:8000
```


### Install using CLI

Two ways, CLI recommended.

[ant-design-pro-cli](https://github.com/ant-design/ant-design-pro-cli) is the official CLI tool for `Ant Design Pro`.

##
```shell
$ npm install ant-design-pro-cli -g
$ pro new


```


# Develop

Create a page

```shell
$ pro g
```

Such as Blank page

In common/route.js, add
```javascript
'/test': {
  component: dynamicWrapper(app, ['profile'], () => import('../routes/BlankLayout')),
},
```

In common/menu.js menuData, add a top level link:
```javascript
{
  name: 'Test',
  icon: 'search',
  path: 'test'
},
```
Copy source files

Mock data

ESLint to format


