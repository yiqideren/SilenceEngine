/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 Sri Harsha Chilakapati
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.shc.silenceengine.backend.gwt;

import com.shc.silenceengine.logging.Logger;

/**
 * @author Sri Harsha Chilakapati
 */
public class GwtLogger extends Logger
{
    public GwtLogger(String name)
    {
        super(name);
    }

    private static native void nInfo(String name, String message) /*-{
        $wnd.console.log("[" + name + "] INFO: " + message);
    }-*/;

    private static native void nWarn(String name, String message) /*-{
        $wnd.console.warn("[" + name + "] WARN: " + message);
    }-*/;

    private static native void nError(String name, String message) /*-{
        $wnd.console.error("[" + name + "] ERROR: " + message);
    }-*/;

    @Override
    public void info(Object... messages)
    {
        for (Object message : messages)
            nInfo(name, message.toString());
    }

    @Override
    public void warn(Object... messages)
    {
        for (Object message : messages)
            nWarn(name, message.toString());
    }

    @Override
    public void error(Object... messages)
    {
        for (Object message : messages)
            nError(name, message.toString());
    }
}