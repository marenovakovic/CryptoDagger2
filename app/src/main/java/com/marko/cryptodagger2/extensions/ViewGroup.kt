package com.marko.cryptodagger2.extensions

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(resource: Int) =
		LayoutInflater.from(context)
				.inflate(resource, this, false)