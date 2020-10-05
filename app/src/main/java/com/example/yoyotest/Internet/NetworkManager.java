package com.example.yoyotest.Internet;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

public class NetworkManager {
    private static NetworkManager mInstance;
    private static Context mContext;
    private RequestQueue mQueue;
    private NetworkManager(Context context){
        mContext = context;
        Cache cache = new DiskBasedCache(context.getCacheDir(),2048*2048);
        BasicNetwork network = new BasicNetwork(new HurlStack());
        mQueue = new RequestQueue(cache,network);
        mQueue.start();
    }
    public static NetworkManager getInstance(Context context){
        if(mInstance==null)
        {
            mInstance = new NetworkManager(context);
        }
        return mInstance;
    }
    public RequestQueue getQueue(){
        return mQueue;
    }
}