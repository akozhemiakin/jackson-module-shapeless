package ru.arkoit.jackson.module.shapeless

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.{Matchers, FlatSpec}
import shapeless._

class HListModuleTest extends FlatSpec with Matchers {
  class Foo[T](val hlist: T)

  val mapper = new ObjectMapper
  mapper.registerModule(new DefaultScalaModule with HListModule)

  "HListModule" should "serialize an HList" in {
    val res = mapper.writeValueAsString(new Foo(
      "bar" :: 5 :: true :: HNil
    ))

    assert(res === """{"hlist":["bar",5,true]}""")
  }

  "HListModule" should "serialize nested HList" in {
    val res = mapper.writeValueAsString(new Foo(
      "bar" :: 5 :: true :: ("baz" :: 15 :: HNil) :: HNil
    ))

    assert(res === """{"hlist":["bar",5,true,["baz",15]]}""")
  }
}
