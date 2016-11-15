package com.connfa.model.requests;

import android.content.Context;

import com.connfa.model.data.Event;
import com.ls.drupal.DrupalClient;
import com.ls.http.base.BaseRequest;

import java.util.Map;

public class SessionsRequest extends BaseSafeConsumeContainerRequest<Event.Holder> {

    public SessionsRequest(Context context, DrupalClient client) {
        super(context, client, new Event.Holder());
    }

    @Override
    protected String getPath() {
        return "getSessions";
    }

    @Override
    protected Map<String, String> getItemRequestPostParameters() {
        return null;
    }

    @Override
    protected Map<String, Object> getItemRequestGetParameters(BaseRequest.RequestMethod method) {
        return null;
    }

}

