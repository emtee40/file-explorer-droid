/*
* Copyright (C) 2014 Opersys inc.
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

package com.opersys.fileexplorer.node;

/**
 * Author: François-Denis Gonthier (francois-denis.gonthier@opersys.com)
 */
public class NodeThreadEventData {

    private String stdout;
    private String stderr;

    private Exception ex;

    public String getStdout() {
        return this.stdout;
    }

    public String getStderr() {
        return this.stderr;
    }

    public Exception getException() {
        return this.ex;
    }

    public NodeThreadEventData(String stdout, String stderr) {
        this.stdout = stdout;
        this.stderr = stderr;
    }

    public NodeThreadEventData(Exception ex) {
        this.ex = ex;
    }

    public NodeThreadEventData() {}
}
