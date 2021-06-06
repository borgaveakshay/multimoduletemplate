package com.example.base.transformers

import io.reactivex.rxjava3.core.Observable

class TestTransformer<T> : Transformer<T>() {
    override fun apply(upstream: Observable<T>?) = upstream
}