package com.example.androidbasics

import java.io.Serializable

data class Person(
    var name: String,
    var lastName: String,
    var age: Int,
    var country: String
) : Serializable