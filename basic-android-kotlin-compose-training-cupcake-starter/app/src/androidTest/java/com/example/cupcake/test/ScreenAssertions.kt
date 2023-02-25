package com.example.cupcake.test

import androidx.navigation.NavController
import org.junit.Assert.assertEquals

//extension function
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}