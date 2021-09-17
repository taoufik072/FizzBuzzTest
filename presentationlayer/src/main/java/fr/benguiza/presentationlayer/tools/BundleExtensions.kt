package fr.benguiza.presentationlayer.tools

import android.os.Bundle

fun bundle(init: Bundle.() -> Unit) = Bundle().apply(init)