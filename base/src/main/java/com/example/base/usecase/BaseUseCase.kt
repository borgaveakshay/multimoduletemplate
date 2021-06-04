package com.example.base.usecase

import com.example.base.utils.Transformer
import io.reactivex.rxjava3.core.Observable


abstract class BaseUseCase<RES,  in REQ>(private val transformer: Transformer<RES>) {

    abstract fun createObservable(request: REQ? = null): Observable<RES>

    operator fun invoke(request: REQ? = null): Observable<RES> = createObservable(request).compose(transformer)

}