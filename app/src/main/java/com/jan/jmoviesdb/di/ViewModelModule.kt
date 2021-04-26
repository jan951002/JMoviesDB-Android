package com.servinf.androidstack.di

import com.servinf.androidstack.ui.dashboard.DashboardViewModel
import com.servinf.androidstack.ui.home.HomeViewModel
import com.servinf.androidstack.ui.notifications.NotificationsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module to configure view models dependency injection
 * @author Jaime Trujillo
 */

val viewModelModule = module {
    viewModel { HomeViewModel(application = androidApplication(), dogRepository = get()) }
    viewModel { DashboardViewModel(application = androidApplication()) }
    viewModel { NotificationsViewModel(application = androidApplication()) }
}