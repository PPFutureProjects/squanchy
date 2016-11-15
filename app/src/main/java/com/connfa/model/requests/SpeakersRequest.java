package com.connfa.model.requests;

import android.content.Context;

import com.connfa.model.data.Speaker;
import com.ls.drupal.DrupalClient;
import com.ls.http.base.BaseRequest;

import java.util.Map;

public class SpeakersRequest extends BaseSafeConsumeContainerRequest<Speaker.Holder> {

    public SpeakersRequest(Context context, DrupalClient client) {
        super(context, client, new Speaker.Holder());
    }

    @Override
    protected String getPath() {
        return "getSpeakers";
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
