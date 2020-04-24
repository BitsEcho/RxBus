# RxBus

A Kotlin ReactiveX event trigger with RxJava3

## Usage

Providing an Observable when some events happening: 

```kotlin
class Foo {
    private val bus = RxBus<String>()
    val text get() = bus.obs
    fun bar() {
        // ...some actions before
        bus.post("Alice")   // Trigger the event 1
        bus.post("Bob")     // Trigger the event 2
        // some action after...
    }
}
```

Subsribe the Observable, and use some Rx Operations: 

```kotlin
fun main() {
    val foo = Foo()
    val disposable = foo.text //.map { it + "123" }.filter { it == "Alice123" } // Using Rx Operations easily
        .subscribe {
            println(it)
        }
    foo.bar()
    Thread.sleep(1000)	// just keep the thread in this sample
    disposable.dispose()    //Dispose the subscribe when do not use the Observable is a good hobby
}

//print:
//Alice
//Bob
```

## License

**RxBus** is under MIT license. See the [LICENSE](LICENSE) file for more info.