package com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
