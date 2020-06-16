package com.bushel.bmohan.baseactivitydemo.data


enum class ApiEndpoint(val desc: String, val url: String) {
    PROD("Production", "http://localhost/mock/"),
    DEV("Dev", "http://localhost/mock/"),
    MOCK("Mock Mode", "http://localhost/mock/");

    companion object {
        fun fromUrl(url: String): ApiEndpoint {
            values().forEach {
                if (it.url == url) {
                    return it
                }
            }
            return ApiEndpoint.PROD
        }

        fun fromDesc(desc: String): ApiEndpoint {
            values().forEach {
                if (it.desc == desc) {
                    return it
                }
            }
            return PROD
        }
    }

    override fun toString(): String {
        return desc
    }
}


