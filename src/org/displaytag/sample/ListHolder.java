// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ListHolder.java

package org.displaytag.sample;

import java.util.List;

// Referenced classes of package org.displaytag.sample:
//            TestList

public class ListHolder
{

    public ListHolder()
    {
        list = new TestList(15, false);
    }

    public final List getList()
    {
        return list;
    }

    private List list;
}
