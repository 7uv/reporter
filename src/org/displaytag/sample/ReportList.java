// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReportList.java

package org.displaytag.sample;

import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package org.displaytag.sample:
//            ReportableListObject

public class ReportList extends ArrayList
{

    public ReportList()
    {
        for(int j = 0; j < 20; j++)
            add(new ReportableListObject());

        Collections.sort(this);
    }

    public ReportList(int size)
    {
        for(int j = 0; j < size; j++)
            add(new ReportableListObject());

        Collections.sort(this);
    }

    private static final long serialVersionUID = 0xd1597a17a6L;
}
