package ru.arkoit.jackson.module.shapeless

import ru.arkoit.jackson.module.shapeless.ser._
import com.fasterxml.jackson.module.scala.JacksonModule

trait HListModule extends JacksonModule {
  this += (_ addSerializers HListSerializerResolver)
}
