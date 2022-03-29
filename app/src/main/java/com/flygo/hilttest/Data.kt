package com.flygo.hilttest

import javax.inject.Inject
import javax.inject.Named


data class Data @Inject constructor(/*@Named("value")*/var value: String)
//                                    var mobileData: String) {
//    @Inject constructor() : this("", "", "") {}
//    constructor(username: String, password: String) : this(username, password, "") {}
//}