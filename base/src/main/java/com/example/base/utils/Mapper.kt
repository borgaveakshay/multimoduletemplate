package com.example.base.utils

abstract class Mapper<in T, out Z> {

    abstract fun mapFrom(from: T): Z
}