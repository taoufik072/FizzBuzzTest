package fr.benguiza.presentationlayer.tools

fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

