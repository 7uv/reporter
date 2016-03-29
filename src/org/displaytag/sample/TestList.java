// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TestList.java

package org.displaytag.sample;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package org.displaytag.sample:
//            ListObject

public class TestList extends ArrayList
{

    public TestList()
    {
        for(int j = 0; j < 60; j++)
            add(new ListObject());

    }

    public TestList(int size, boolean duplicates)
    {
        if(duplicates)
        {
            for(int j = 0; j < size; j++)
            {
                ListObject object1 = new ListObject();
                ListObject object2 = new ListObject();
                ListObject object3 = new ListObject();
                int random = (new Random()).nextInt(3);
                for(int k = 0; k <= random; k++)
                    add(object1);

                object1.setId(object2.getId());
                random = (new Random()).nextInt(3);
                for(int k = 0; k <= random; k++)
                {
                    add(object1);
                    add(object2);
                }

                object1.setEmail(object3.getEmail());
                random = (new Random()).nextInt(3);
                for(int k = 0; k <= random; k++)
                    add(object1);

            }

        } else
        {
            for(int j = 0; j < size; j++)
                add(new ListObject());

        }
    }

    public ListObject getItem(int index)
    {
        return (ListObject)super.get(index);
    }

    private static final long serialVersionUID = 0xd1597a17a6L;
}
