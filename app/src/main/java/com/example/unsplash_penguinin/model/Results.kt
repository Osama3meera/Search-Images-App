package com.example.unsplash_penguinin.model

data class Results(
    var id: String,
    var description: String,
    var alt_description: String,
    var urls: Urls,
    var user: User
)