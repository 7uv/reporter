// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Wrapper.java

package org.displaytag.sample.decorators;

import java.text.DecimalFormat;
import org.apache.commons.lang.time.FastDateFormat;
import org.displaytag.decorator.TableDecorator;
import org.displaytag.sample.ListObject;

public class Wrapper extends TableDecorator
{

    public Wrapper()
    {
        dateFormat = FastDateFormat.getInstance("MM/dd/yy");
        moneyFormat = new DecimalFormat("$ #,###,###.00");
    }

    public String getNullValue()
    {
        return null;
    }

    public String getDate()
    {
        return dateFormat.format(((ListObject)getCurrentRowObject()).getDate());
    }

    public String getMoney()
    {
        return moneyFormat.format(((ListObject)getCurrentRowObject()).getMoney());
    }

    public String getLink1()
    {
        ListObject object = (ListObject)getCurrentRowObject();
        int index = getListIndex();
        return "<a href=\"details.jsp?index=" + index + "\">" + object.getId() + "</a>";
    }

    public String getLink2()
    {
        ListObject object = (ListObject)getCurrentRowObject();
        int id = object.getId();
        return "<a href=\"details.jsp?id=" + id + "&amp;action=view\">View</a> | " + "<a href=\"details.jsp?id=" + id + "&amp;action=edit\">Edit</a> | " + "<a href=\"details.jsp?id=" + id + "&amp;action=delete\">Delete</a>";
    }

    private FastDateFormat dateFormat;
    private DecimalFormat moneyFormat;
}
