package com.filip.sample.dataModels

data class ComplicatedData(
        val name: String,
        val title: String,
        val age: Int,
        val image: String,
        val lessComplicatedData: LessComplicatedData
)

data class LessComplicatedData (
        val subtile: String,
        val address: String
        )