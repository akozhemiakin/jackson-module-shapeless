# Jackson Shapeless Module
[![Build Status](https://travis-ci.org/numesmat/jackson-module-shapeless.svg?branch=master)](https://travis-ci.org/numesmat/jackson-module-shapeless)
## Overview
This is a tiny module for the [Jackson][] serialization library. This module allows to serialize [Shapeless][] HLists.
## Installation
This module is published at Maven Central. Use the following _sbt_ snippet ...

* for the _stable_ release:

```scala
libraryDependencies ++= Seq(
  "ru.arkoit.jackson.module" %% "shapeless" % "0.1.0"
)
```

* for the `SNAPSHOT` version:

```scala
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "ru.arkoit.jackson.module" %% "shapeless" % "0.1.1-SNAPSHOT" changing()
)
```
## Usage
Mixin this module as you usually do with other Scala Jackson Modules. For example, it can be used like this:
```scala
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import ru.arkoit.jackson.module.shapeless.HListModule

val mapper = new ObjectMapper
mapper.registerModule(new DefaultScalaModule with HListModule)
```
## Future plans
For now this module is only able to serialize HLists. However, other shapeless related stuff may be added in the future as well. You are welcome to make pull requests in this direction.

[Jackson]: http://jackson.codehaus.org/
[Shapeless]: https://github.com/milessabin/shapeless