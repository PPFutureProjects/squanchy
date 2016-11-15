package com.connfa.model.requests;

import android.content.Context;

import com.connfa.model.data.Track;
import com.ls.drupal.DrupalClient;
import com.ls.http.base.BaseRequest;

import java.util.Map;

public class TracksRequest extends BaseSafeConsumeContainerRequest<Track.Holder> {

    public TracksRequest(Context context, DrupalClient client) {
        super(context, client, new Track.Holder());
    }

    @Override
    protected String getPath() {
        return "getTracks";
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
