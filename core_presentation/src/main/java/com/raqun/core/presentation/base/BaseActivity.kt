package com.raqun.core.presentation.base

import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.raqun.core.presentation.Constants
import com.raqun.core.presentation.R
import com.raqun.core.presentation.navigation.UiNavigation

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    @StringRes
    open val titleRes = R.string.app_name

    @MenuRes
    open val menuRes = Constants.NO_RES

    open val uiNavigation = UiNavigation.BACK

    @IdRes
    open val toolbarRes = Constants.NO_RES

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        if (toolbarRes != Constants.NO_RES) {
            setToolbar(findViewById(toolbarRes))
        }
        initNavigation(uiNavigation)
        setScreenTitle(getString(titleRes))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menuRes != Constants.NO_RES) {
            menuInflater.inflate(menuRes, menu)
            return true
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    fun setScreenTitle(@StringRes titleRes: Int) {
        var title: String? = null
        try {
            title = getString(titleRes)
        } catch (e: Resources.NotFoundException) {
            // ignored
        }
        setScreenTitle(title)
    }

    fun setScreenTitle(title: String?) {
        supportActionBar?.title = title ?: getString(R.string.app_name)
    }

    fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    fun initNavigation(uiNavigation: UiNavigation) {
        when (uiNavigation) {
            UiNavigation.BACK -> supportActionBar?.setDisplayHomeAsUpEnabled(true)
            UiNavigation.ROOT -> supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    fun setHomeIcon(@DrawableRes iconResId: Int) {
        supportActionBar?.setHomeAsUpIndicator(iconResId)
    }

}