package org.mifos.core.apimanager

import org.openapitools.client.apis.AuditsApi
import org.openapitools.client.apis.AuthenticationHTTPBasicApi
import org.openapitools.client.apis.CentersApi
import org.openapitools.client.apis.ChargesApi
import org.openapitools.client.apis.ClientApi
import org.openapitools.client.apis.DataTablesApi
import org.openapitools.client.apis.DocumentsApi
import org.openapitools.client.apis.GroupsApi
import org.openapitools.client.apis.LoanReschedulingApi
import org.openapitools.client.apis.LoansApi
import org.openapitools.client.apis.NotesApi
import org.openapitools.client.apis.OfficesApi
import org.openapitools.client.apis.RunReportsApi
import org.openapitools.client.apis.SavingsAccountApi
import org.openapitools.client.apis.SearchAPIApi
import org.openapitools.client.apis.SpmSurveysApi
import org.openapitools.client.apis.StaffApi
import org.openapitools.client.infrastructure.FineractClient

interface BaseApiManager {

    companion object {
        fun getInstance(): BaseApiManager {
            return BaseApiManagerImpl()
        }
    }

    fun createService(
        username: String,
        password: String,
        baseUrl: String,
        tenant: String = "default",
        secured: Boolean = true
    )

    fun getClient(): FineractClient

    fun getAuthApi(): AuthenticationHTTPBasicApi

    fun getCenterApi(): CentersApi

    fun getClientsApi(): ClientApi

    fun getDataTableApi(): DataTablesApi

    fun getLoanApi(): LoansApi

    fun getSavingsApi(): SavingsAccountApi

    fun getSearchApi(): SearchAPIApi

    fun getGroupApi(): GroupsApi

    fun getDocumentApi(): DocumentsApi

    fun getOfficeApi(): OfficesApi

    fun getStaffApi(): StaffApi

    fun getSurveyApi(): SpmSurveysApi

    fun getChargeApi(): ChargesApi

    fun getRunReportsService(): RunReportsApi

    fun getNoteApi(): NotesApi

    fun getCollectionSheetApi(): CentersApi

    fun getCheckerInboxApi(): AuditsApi

    fun getRescheduleLoansApi(): LoanReschedulingApi
}