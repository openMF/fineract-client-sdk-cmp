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

/**
 * Created by Aditya Gupta on 19-09-2024
 *
 * A class to provide the ktorfit service to the SDK
 */
class BaseApiManagerImpl : BaseApiManager {

    private lateinit var client: FineractClient

    override fun createService(
        username: String,
        password: String,
        baseUrl: String,
        tenant: String,
        secured: Boolean
    ) {
        val builder = FineractClient.builder()
            .baseURL(baseUrl)
            .basicAuth(username, password)
            .inSecure(!secured)
            .tenant(tenant)

        client = builder.build()
    }

    override fun getClient(): FineractClient {
        return client
    }

    override fun getAuthApi(): AuthenticationHTTPBasicApi = client.authentication

    override fun getCenterApi(): CentersApi = client.centers

    override fun getClientsApi(): ClientApi = client.clients

    override fun getDataTableApi(): DataTablesApi = client.dataTables

    override fun getLoanApi(): LoansApi = client.loans

    override fun getSavingsApi(): SavingsAccountApi = client.savingsAccounts

    override fun getSearchApi(): SearchAPIApi = client.search

    override fun getGroupApi(): GroupsApi = client.groups

    override fun getDocumentApi(): DocumentsApi = client.documents

    override fun getOfficeApi(): OfficesApi = client.offices

    override fun getStaffApi(): StaffApi = client.staff

    override fun getSurveyApi(): SpmSurveysApi = client.spmSurveys

    override fun getChargeApi(): ChargesApi = client.charges

    override fun getRunReportsService(): RunReportsApi = client.reportsRun

    override fun getNoteApi(): NotesApi = client.notes

    override fun getCollectionSheetApi(): CentersApi = client.centers

    override fun getCheckerInboxApi(): AuditsApi = client.audits

    override fun getRescheduleLoansApi(): LoanReschedulingApi = client.loanSchedules
}