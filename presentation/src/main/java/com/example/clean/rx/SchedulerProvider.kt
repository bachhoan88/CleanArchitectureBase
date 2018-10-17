package com.example.clean.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}