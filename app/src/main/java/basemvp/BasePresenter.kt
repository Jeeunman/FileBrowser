package basemvp

import android.content.Context

interface BasePresenter<T> {
	var view: T
	var context: Context

	fun onCreate()
	fun onResume()
	fun onPause()
}