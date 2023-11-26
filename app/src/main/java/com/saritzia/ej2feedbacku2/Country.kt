package com.saritzia.ej2feedbacku2

import java.io.Serializable

class Country (var countryName: String, var population: Long) : Serializable {
    override fun toString(): String {
        return countryName
    }
}