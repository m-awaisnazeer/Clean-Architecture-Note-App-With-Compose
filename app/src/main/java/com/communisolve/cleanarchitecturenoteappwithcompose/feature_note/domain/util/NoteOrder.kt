package com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)

    fun copy(orderType: OrderType): NoteOrder {
        return when (this){
            is Title -> Title(orderType)
            is Color -> Color(orderType)
            is Date -> Date(orderType)
        }
    }
}
