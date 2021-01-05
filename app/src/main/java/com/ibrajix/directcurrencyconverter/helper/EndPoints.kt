package com.ibrajix.directcurrencyconverter.helper

import com.ibrajix.directcurrencyconverter.BuildConfig
import com.ibrajix.directcurrencyconverter.helper.EndPoints.Companion.API_KEY

/**
 * All URL listed in this class
 */

class EndPoints {

    companion object {

        //Base URL

        const val BASE_URL = "https://api.getgeoapi.com/api/v2/currency/"

        //API KEY
        const val API_KEY = BuildConfig.API_TOKEN

        //COVERT URL
        const val  CONVERT_URL = "convert"

    }

}