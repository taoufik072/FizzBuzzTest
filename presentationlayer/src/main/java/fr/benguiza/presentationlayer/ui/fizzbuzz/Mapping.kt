package fr.benguiza.presentationlayer.ui.fizzbuzz

import fr.benguiza.domainlayer.FizzBuzzItem


internal fun FizzBuzzItem.toUi() =
    FizzBuzzUi(
        id = id,
        title = title,
        countCalling = 1
    )

