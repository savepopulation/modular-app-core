package com.raqun.core.presentation.base

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.raqun.core.presentation.Constants

abstract class BaseFragment : Fragment(), BaseView {

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    @MenuRes
    open val menuRes = Constants.NO_RES

    @StringRes
    open val titleRes = Constants.NO_RES

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(menuRes != Constants.NO_RES)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        if (menuRes != Constants.NO_RES) {
            inflater?.inflate(menuRes, menu)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (titleRes != Constants.NO_RES) {
            setActivityTitle(getString(titleRes))
        }
    }

    override fun onError(e: Error) {
        Toast.makeText(context, "Unknown error has been occurred!", Toast.LENGTH_LONG).show()
    }

    protected fun setActivityTitle(title: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).setScreenTitle(title)
        }
    }

    fun getApplication() = activity?.application

    fun getApplicationContext() = getApplication()?.applicationContext

    open fun initView() {
        // can be overridden
    }

}