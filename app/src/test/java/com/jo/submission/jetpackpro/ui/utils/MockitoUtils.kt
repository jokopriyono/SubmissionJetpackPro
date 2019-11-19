package com.jo.submission.jetpackpro.ui.utils

import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)
