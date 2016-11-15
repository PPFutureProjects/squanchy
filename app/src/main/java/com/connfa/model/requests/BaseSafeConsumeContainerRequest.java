package com.connfa.model.requests;

import android.content.Context;

import com.connfa.model.PreferencesManager;
import com.connfa.model.UpdatesManager;
import com.ls.drupal.AbstractDrupalEntityContainer;
import com.ls.drupal.DrupalClient;
import com.ls.http.base.BaseRequest;
import com.ls.http.base.ResponseData;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSafeConsumeContainerRequest<T> extends AbstractDrupalEntityContainer<T> {

    private final PreferencesManager preferencesManager;

    public BaseSafeConsumeContainerRequest(Context context, DrupalClient client, T theData) {
        super(client, theData);
        preferencesManager = PreferencesManager.create(context);
    }

    @Override
    protected void consumeObject(ResponseData entity) {
        if (entity.getData() != null) {
            super.consumeObject(entity);
        }
    }

    @Override
    protected Map<String, String> getItemRequestHeaders(BaseRequest.RequestMethod method) {
        if (method != BaseRequest.RequestMethod.GET) {
            return super.getItemRequestHeaders(method);
        }

        String lastDate = preferencesManager.getLastUpdateDate();
        Map<String, String> result = new HashMap<>();
        result.put(UpdatesManager.IF_MODIFIED_SINCE_HEADER, lastDate);
        return result;
    }
}
