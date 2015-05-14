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

package com.opersys.fileexplorer.tasks;

import android.os.AsyncTask;
import android.util.Log;

import java.net.*;
import java.util.Enumeration;

/**
 * Author: François-Denis Gonthier (francois-denis.gonthier@opersys.com)
 */
public abstract class LocalIPAddressTask extends AsyncTask<Void, Void, InetAddress> {

    private static final String TAG = "LocalIPAddressTask";

    @Override
    protected InetAddress doInBackground(Void... params) {
        try {
            NetworkInterface intf;
            InetAddress inetAddress;

            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements() ;) {

                intf = en.nextElement();

                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                     enumIpAddr.hasMoreElements();) {

                    inetAddress = enumIpAddr.nextElement();

                    if (inetAddress.isLoopbackAddress()) {
                        Log.d(TAG, "Loopback: " + inetAddress.toString() + " --> Discarding");
                        continue;
                    }

                    if (inetAddress instanceof Inet6Address) {
                        Log.d(TAG, "IPv6: " + inetAddress.toString() + " --> Discarding");
                        continue;
                    }

                    if (inetAddress instanceof Inet4Address) {
                        Log.d(TAG, "IPv4: " + inetAddress.toString() + " --> OK!");
                        return inetAddress;
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e(TAG, ex.toString());
        }

        return null;
    }

    @Override
    public abstract void onPostExecute(InetAddress inetAddress);
}
