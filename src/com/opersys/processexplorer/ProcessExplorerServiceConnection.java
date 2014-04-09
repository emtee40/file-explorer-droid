package com.opersys.processexplorer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.opersys.processexplorer.node.NodeThreadListener;

public class ProcessExplorerServiceConnection implements ServiceConnection {

    private static final String TAG = "ProcessExplorer-ProcessExplorerServiceConnection";

    private final NodeThreadListener serviceListener;

    public ProcessExplorerServiceConnection(NodeThreadListener serviceListener) {
        this.serviceListener = serviceListener;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        serviceListener.onProcessServiceConnected((ProcessExplorerServiceBinder) iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        serviceListener.onProcessServiceDisconnected();
    }
}