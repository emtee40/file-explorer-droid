/*
* Copyright (C) 2014-2015, Opersys inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.opersys.fileexplorer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.opersys.fileexplorer.node.NodeThreadListener;

public class FileExplorerServiceConnection implements ServiceConnection {

    private static final String TAG = "FileExplorer-FileExplorerServiceConnection";

    private final NodeThreadListener serviceListener;

    public FileExplorerServiceConnection(NodeThreadListener serviceListener) {
        this.serviceListener = serviceListener;
    }

    public FileExplorerServiceConnection() {
        this.serviceListener = null;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (serviceListener != null)
            serviceListener.onProcessServiceConnected((FileExplorerServiceBinder) iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        if (serviceListener != null)
            serviceListener.onProcessServiceDisconnected();
    }
}