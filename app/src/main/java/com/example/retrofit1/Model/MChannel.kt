package com.example.retrofit1.Model

data class MChannel(
    var channelId: Int? = null,
    var title: String? = null,
    var logoURL: String? = null,
    var alias: String? = null,
    var ageRestriction: Int? = null,
    var hasSchedule: Int? = null
)