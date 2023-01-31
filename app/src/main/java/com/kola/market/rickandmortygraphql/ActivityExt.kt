package com.kola.market.rickandmortygraphql

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import timber.log.Timber

/**
 * Created by Emperor95 on 01 March,2022.
 * https://github.com/Emperor95
 */

fun Activity.toast(msg: String?) {
    Toast.makeText(this, "$msg", Toast.LENGTH_SHORT).show()
}

fun <T> AppCompatActivity.observeLiveData(
    liveData: LiveData<RichAndMortyResult<T>>,
    enableProgressBar: Boolean = true,
    onSuccess: (T) -> Unit
) {

//    val loadingDialog: LoadingDialog by lazy { LoadingDialog(this) }
//    var errorDialog: ErrorDialog? = null

    liveData.observe(this) { dataState ->
        when (dataState) {
            is RichAndMortyResult.Loading -> {
//                loadingDialog.setLoading(enableProgressBar)
            }
            is RichAndMortyResult.Success -> {
//                loadingDialog.setLoading(false)
                dataState.data?.let { onSuccess(it) }
            }
            is RichAndMortyResult.Error -> {
//                loadingDialog.setLoading(false)
                Timber.tag("LoginResponse").d("${dataState.exception}")
//                if (enableProgressBar && dataState.exception.message != DEVICE_CHANGED_STATUS_CODE) {
                    dataState.exception.message?.let { errorMsg ->
//                        errorDialog =
//                            ErrorDialog.newInstance(errorMsg) { errorDialog?.dismiss() }
//                        errorDialog?.show(supportFragmentManager, errorDialog?.tag)
//                    }
                }
            }
        }
    }

}
