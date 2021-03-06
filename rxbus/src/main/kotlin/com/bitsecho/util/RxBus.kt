package com.bitsecho.util

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.processors.PublishProcessor

open class RxBus<T> {
    private val bus = PublishProcessor.create<T>().toSerialized()

    val obs: Observable<T> get() = bus.toObservable()

    fun post(t: T) {
        if (hasSubscribers()) {
            bus.onNext(t)
        }
    }

    fun hasSubscribers(): Boolean = bus.hasSubscribers()
}