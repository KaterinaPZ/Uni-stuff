# Alert Webhook
You can use SAP BTP  cockpit or Alerting Channels REST API to configure channels to receive alert notifications. One channel for alert notifications is the alert webhook, which requires you to configure an application URL that receives the alerts from the SAP Monitoring service of SAP BTP, Neo environment.
## Overview
The  SAP Monitoring service  uses webhooks to send alerts to a configured URL. Accordingly, you must set up your own custom application and provide a protected URL for such alerts. Your application must also store a verification token that the  SAP Monitoring service  requests.

The following process describes how you as a customer and your custom application have to communicate with the  SAP Monitoring service.
## Process Flow
![This is a diagram showing the process flow for the alert webhook functionality.](https://help.sap.com/doc/64f7d2b06c6b40a9b3097860c5930641/Cloud/en-US/loio780b39b5c5344724accf2e497c10e49a_LowRes.png
"This is a diagram showing the process flow for the alert webhook functionality")

1.  You set the application URL for the alerts when creating a  Webhook  alert channel via the  SAP BTP  cockpit  or with a POST REST call to the  SAP Monitoring service.
    
2.  You retrieve the verification token either from the  Details  column in the  SAP BTP  cockpit  or from the REST call response.
    
3.  You store the verification token in your custom application.
    
4.  When the  SAP Monitoring service  receives an alert, it sends a GET request to the custom application URL for the verification token.
    
5.  The custom application responds to the GET request.
    
    The custom application responds with a status code  200 OK  by sending the verification token as plain text.
    
6.  The  SAP Monitoring service  verifies the token, and then sends the alert to the custom application URL using a POST REST call.
    
    The alert is sent in the following JSON format.

>  <> **Sample Code**
> 
> ```
> {
>  "type": "PROBLEM",
>  "metric": "My metric name",
>  "state": "WARNING",
>  "date": "Fri April 03 12:23:05 UTC 2020",
>  "output": "JMX WARNING - Value = 2",
>  "resourceType": "APPLICATION",
>  "resource": {
>    "application": "myapp",
>    "processId": "9b255a3770c332615f911c09b503eceaf9c1d0b8",
>    "account": "mysubaccount"
>  }
> }
> ```    
>
>The  resourceType  value  APPLICATION,  DATABASE,  XS_APPLICATION, or  HTML5_APPLICATION  defines if the alert is respectively for a Java application, database, SAP HANA XS application, or HTML5 application.
>
>When the alert is for a default or custom metric of a Java application ("resourceType": "APPLICATION"), the JSON also includes the process ID. The alerts for the other resource types don’t include the process ID.

>**Sample Code**
>
>```
>{
> "type": "PROBLEM",
>  "metric": "Availability Check",
>  "state": "CRITICAL",
>  "date": "Thu Sep 20 12:08:20 UTC 2018",
>  "output": "CRITICAL: HTTP Status Code: 503 Response size: 222B Response time: 0.019s",
>  "resourceType": "APPLICATION",
>  "resource": {
>    "application": "myapp",
>    "account": "mysubaccount"
>  }
> }
>```

>**Caution**
>
>The alert for an availability check doesn’t include the process ID because of the specifics of this metric.

7.  The custom application responds with a status code  201 Created  when the operation is successful.

## Configuring via  SAP BTP  Cockpit

### Prerequisites

The manageMonitoringConfiguration scope is assigned to the used platform role for the subaccount. For more information, see [Platform Scopes](https://help.sap.com/docs/monitoring-service/sap-monitoring-service-for-sap-btp/f2260746ed8e446fafdeaaa8ab43e307.html).

### Context
You can use SAP BTP  cockpit to configure an alert webhook on a subaccount level.

### Procedure
1.  Open the subaccount in the  SAP BTP  cockpit.
2.  Choose    **Monitoring >  Alert Channels** in the navigation area for the subaccount.
4.  Choose  **Create Alert Channel**.
5.  Select the  **Webhook**  type, specify the URL you've configured for the alerts, select the authentication type used for the URL, and fill in its values:
    -   **OAuth2**  - provide server URL, client, and secret for the OAuth 2.0 authentication.
    -   **Basic**  - provide the credentials for the basic authentication.

## Configuring with Alerting Channels REST API

### Prerequisites

The REST API is protected with OAuth 2.0 client credentials.

Create an OAuth client and obtain an access token to call the API methods. See  [Using Platform APIs](https://help.sap.com/docs/monitoring-service/sap-monitoring-service-for-sap-btp/392af9d162694d6595499f1549978aa6.html "Platform APIs are protected with OAuth 2.0 client credentials. Create an OAuth client and obtain an access token to call the platform API methods."). For more information about the format of the REST APIs, see  [Alerting Channels REST API![Information published on SAP site](https://help.sap.com/doc/64f7d2b06c6b40a9b3097860c5930641/Cloud/en-US/themes/sap-light/img/sap_link.png "Information published on SAP site")](https://help.sap.com/docs/link-disclaimer?site=https%3A%2F%2Fapi.sap.com%2Fapi%2FHCP_Alerting_v2%2Foverview "https://api.sap.com/api/HCP_Alerting_v2/overview").

>**Note**
>
>When you create the API client from the  Platform API  tab in the  SAP BTP  cockpit, select the  Monitoring Service  API with the  Manage Alerting Channels  scope.

### Context

You can use the Alerting Channels REST API at the subaccount or application level. In such a case, the POST requests are the following:

-   On subaccount level:  https://api.{host}/alerting/v2/channels/accounts/{subaccountName}/types/webhook
    
-   On application level:  https://api.{host}/alerting/v2/channels/accounts/{subaccountName}/apps/{appName}/types/webhook
    

### Procedure

Set the application URL for the alerts by using a POST REST call to the  SAP Monitoring service.

-   If the custom application URL is protected with OAuth 2.0, include the following in the body of the POST request.
    
> **Sample Code**
>
> ```
> {
>  "url": "https://customURL.com/alias",
>  "authentication": {
>                      "authenticationType": "oauth2",
>                      "client": "asdfjasdljfasdkjf",
>                      "secret": "w7d65as4d1as0das7",
>                      "oAuthServerUrl": "https://customServerURL.com/o/oauth2/auth"
>                    }
> }
> ```

    
-   If the custom application URL is protected with credentials, include the following in the body of the POST request.
    
>   **Sample Code**
>
> ```   
> "authentication": {
>                     "authenticationType": "basic",
>                     "user": "yourUser",
>                     "password": "123456"
>                  }
> ```

### Related Information

[Receiving Alerts in the Corporate On-Premise System![Information published on SAP site](https://help.sap.com/doc/64f7d2b06c6b40a9b3097860c5930641/Cloud/en-US/themes/sap-light/img/sap_link.png "Information published on SAP site")](https://help.sap.com/docs/link-disclaimer?site=https%3A%2F%2Fblogs.sap.com%2F2018%2F09%2F17%2Freceiving-alerts-in-the-corporate-on-premise-system%2F "Learn how to receive alerts locally in your on-premise system.")

[Availability Checks](https://help.sap.com/docs/monitoring-service/sap-monitoring-service-for-sap-btp/availability-checks "Create an availability check for a Java or an SAP HANA XS application to track if the application is available and to receive alerts for it.")

Written with [StackEdit](https://stackedit.io/).
