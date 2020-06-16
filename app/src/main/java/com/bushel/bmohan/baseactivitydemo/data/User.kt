package com.bushel.bmohan.baseactivitydemo.data

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
        @JsonProperty("Username")
        val username: String? = null,
        @JsonProperty("Password")
        val password: String? = null)