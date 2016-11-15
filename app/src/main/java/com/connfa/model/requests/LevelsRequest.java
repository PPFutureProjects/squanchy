package com.connfa.model.requests;

import android.content.Context;

import com.connfa.model.data.Level;
import com.ls.drupal.DrupalClient;
import com.ls.http.base.BaseRequest;

import java.util.Map;

public class LevelsRequest extends BaseSafeConsumeContainerRequest<Level.Holder> {

    public LevelsRequest(Context context, DrupalClient client) {
        super(context, client, new Level.Holder());
    }

    @Override
    protected String getPath() {
        return "getLevels";
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
