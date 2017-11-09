Android-Kotlin-Dagger2-Conductor-Example
=====================
This project demonstrate how to setup an Android Project with Kotlin, Dagger 2 and Conductor.

[Dagger2](https://github.com/google/dagger)

[Conductor](https://github.com/bluelinelabs/Conductor)

##Limitations

When `lateinit` modifier is used, your variable cannot be used in `init{}` block. It will not compile. So in that case I suggest to move code from that block into a separate function and then call that function from `init{}` block.
