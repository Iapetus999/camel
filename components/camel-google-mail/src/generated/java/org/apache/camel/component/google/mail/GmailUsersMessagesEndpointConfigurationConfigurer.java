/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.google.mail;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.component.google.mail.GmailUsersMessagesEndpointConfiguration;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class GmailUsersMessagesEndpointConfigurationConfigurer extends org.apache.camel.support.component.PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    private static final Map<String, Object> ALL_OPTIONS;
    static {
        Map<String, Object> map = new CaseInsensitiveMap();
        map.put("AccessToken", java.lang.String.class);
        map.put("ApiName", org.apache.camel.component.google.mail.internal.GoogleMailApiName.class);
        map.put("ApplicationName", java.lang.String.class);
        map.put("BatchDeleteMessagesRequest", com.google.api.services.gmail.model.BatchDeleteMessagesRequest.class);
        map.put("BatchModifyMessagesRequest", com.google.api.services.gmail.model.BatchModifyMessagesRequest.class);
        map.put("ClientId", java.lang.String.class);
        map.put("ClientSecret", java.lang.String.class);
        map.put("Content", com.google.api.services.gmail.model.Message.class);
        map.put("Id", java.lang.String.class);
        map.put("MediaContent", com.google.api.client.http.AbstractInputStreamContent.class);
        map.put("MethodName", java.lang.String.class);
        map.put("ModifyMessageRequest", com.google.api.services.gmail.model.ModifyMessageRequest.class);
        map.put("RefreshToken", java.lang.String.class);
        map.put("UserId", java.lang.String.class);
        ALL_OPTIONS = map;
    }

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        org.apache.camel.component.google.mail.GmailUsersMessagesEndpointConfiguration target = (org.apache.camel.component.google.mail.GmailUsersMessagesEndpointConfiguration) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesstoken":
        case "AccessToken": target.setAccessToken(property(camelContext, java.lang.String.class, value)); return true;
        case "apiname":
        case "ApiName": target.setApiName(property(camelContext, org.apache.camel.component.google.mail.internal.GoogleMailApiName.class, value)); return true;
        case "applicationname":
        case "ApplicationName": target.setApplicationName(property(camelContext, java.lang.String.class, value)); return true;
        case "batchdeletemessagesrequest":
        case "BatchDeleteMessagesRequest": target.setBatchDeleteMessagesRequest(property(camelContext, com.google.api.services.gmail.model.BatchDeleteMessagesRequest.class, value)); return true;
        case "batchmodifymessagesrequest":
        case "BatchModifyMessagesRequest": target.setBatchModifyMessagesRequest(property(camelContext, com.google.api.services.gmail.model.BatchModifyMessagesRequest.class, value)); return true;
        case "clientid":
        case "ClientId": target.setClientId(property(camelContext, java.lang.String.class, value)); return true;
        case "clientsecret":
        case "ClientSecret": target.setClientSecret(property(camelContext, java.lang.String.class, value)); return true;
        case "content":
        case "Content": target.setContent(property(camelContext, com.google.api.services.gmail.model.Message.class, value)); return true;
        case "id":
        case "Id": target.setId(property(camelContext, java.lang.String.class, value)); return true;
        case "mediacontent":
        case "MediaContent": target.setMediaContent(property(camelContext, com.google.api.client.http.AbstractInputStreamContent.class, value)); return true;
        case "methodname":
        case "MethodName": target.setMethodName(property(camelContext, java.lang.String.class, value)); return true;
        case "modifymessagerequest":
        case "ModifyMessageRequest": target.setModifyMessageRequest(property(camelContext, com.google.api.services.gmail.model.ModifyMessageRequest.class, value)); return true;
        case "refreshtoken":
        case "RefreshToken": target.setRefreshToken(property(camelContext, java.lang.String.class, value)); return true;
        case "userid":
        case "UserId": target.setUserId(property(camelContext, java.lang.String.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Map<String, Object> getAllOptions(Object target) {
        return ALL_OPTIONS;
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        org.apache.camel.component.google.mail.GmailUsersMessagesEndpointConfiguration target = (org.apache.camel.component.google.mail.GmailUsersMessagesEndpointConfiguration) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesstoken":
        case "AccessToken": return target.getAccessToken();
        case "apiname":
        case "ApiName": return target.getApiName();
        case "applicationname":
        case "ApplicationName": return target.getApplicationName();
        case "batchdeletemessagesrequest":
        case "BatchDeleteMessagesRequest": return target.getBatchDeleteMessagesRequest();
        case "batchmodifymessagesrequest":
        case "BatchModifyMessagesRequest": return target.getBatchModifyMessagesRequest();
        case "clientid":
        case "ClientId": return target.getClientId();
        case "clientsecret":
        case "ClientSecret": return target.getClientSecret();
        case "content":
        case "Content": return target.getContent();
        case "id":
        case "Id": return target.getId();
        case "mediacontent":
        case "MediaContent": return target.getMediaContent();
        case "methodname":
        case "MethodName": return target.getMethodName();
        case "modifymessagerequest":
        case "ModifyMessageRequest": return target.getModifyMessageRequest();
        case "refreshtoken":
        case "RefreshToken": return target.getRefreshToken();
        case "userid":
        case "UserId": return target.getUserId();
        default: return null;
        }
    }
}
