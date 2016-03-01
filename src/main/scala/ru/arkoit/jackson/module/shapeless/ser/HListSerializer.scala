package ru.arkoit.jackson.module.shapeless.ser

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind._
import ser.Serializers
import shapeless._

class HListSerializer extends JsonSerializer[HList] {
  override def serialize(value: HList, gen: JsonGenerator, provider: SerializerProvider) = {
    gen.writeStartArray()
    def ser(x: HList): Unit = x match {
      case ::(h: AnyRef, c) =>
        provider.findValueSerializer(h.getClass).serialize(h, gen, provider)
        ser(c)
      case _ =>
    }
    ser(value)
    gen.writeEndArray()
  }
}

object HListSerializerResolver extends Serializers.Base {
  private val HLIST = classOf[HList]

  override def findSerializer(config: SerializationConfig, javaType: JavaType, beanDesc: BeanDescription): JsonSerializer[_] = {
    if (!HLIST.isAssignableFrom(javaType.getRawClass)) null else {
      new HListSerializer
    }
  }
}

