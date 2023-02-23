package com.example.superheroesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.intellij.lang.annotations.JdkConstants.InputEventMask

data class Hero(@StringRes val nameRes: Int, @StringRes val descriptionRes: Int, @DrawableRes val imageRes: Int)
