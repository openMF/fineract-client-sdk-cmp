package org.mifos.ui

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.mifos.R
import org.mifos.core.apimanager.BaseApiManager
import org.mifos.core.apimanager.BaseUrl.Companion.API_ENDPOINT
import org.mifos.core.apimanager.BaseUrl.Companion.API_PATH
import org.mifos.core.apimanager.BaseUrl.Companion.PROTOCOL_HTTPS
import org.mifos.utils.toast
import org.openapitools.client.models.PostAuthenticationRequest

class HomeActivity : AppCompatActivity() {

    private val baseUrl = PROTOCOL_HTTPS + API_ENDPOINT + API_PATH
    private val tenant = "default"
    private lateinit var baseApiManager: BaseApiManager

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        baseApiManager = BaseApiManager.getInstance()
        baseApiManager.createService("mifos", "password", baseUrl, tenant, false)

        val req = PostAuthenticationRequest(username = "mifos", password = "password")

        lifecycleScope.launch {
            val response = baseApiManager.getAuthApi().authenticate(req, true)
            setText(response.toString())
            getClient()
        }
    }

    private fun getClient() {
        lifecycleScope.launch {
            val response = baseApiManager.getClientsApi().retrieveOne11(1, false)
            this@HomeActivity.toast(response.toString())
        }
    }

    private fun setText(text: String) {
        findViewById<TextView>(R.id.text).text = text
    }
}