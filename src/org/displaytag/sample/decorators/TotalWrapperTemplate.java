// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TotalWrapperTemplate.java

package org.displaytag.sample.decorators;

import java.util.List;
import org.apache.commons.lang.ObjectUtils;
import org.displaytag.decorator.TableDecorator;
import org.displaytag.sample.ReportableListObject;

public abstract class TotalWrapperTemplate extends TableDecorator
{

    public TotalWrapperTemplate()
    {
    }

    public final String finishRow()
    {
        int listindex = ((List)getDecoratedObject()).indexOf(getCurrentRowObject());
        ReportableListObject reportableObject = (ReportableListObject)getCurrentRowObject();
        String nextCity = null;
        cityTotal += reportableObject.getAmount();
        grandTotal += reportableObject.getAmount();
        if(listindex != ((List)getDecoratedObject()).size() - 1)
            nextCity = ((ReportableListObject)((List)getDecoratedObject()).get(listindex + 1)).getCity();
        buffer = new StringBuffer(1000);
        if(!ObjectUtils.equals(nextCity, reportableObject.getCity()))
        {
            writeCityTotal(reportableObject.getCity(), cityTotal);
            cityTotal = 0.0D;
        }
        if(getViewIndex() == ((List)getDecoratedObject()).size() - 1)
            writeGrandTotal(grandTotal);
        return buffer.toString();
    }

    protected abstract void writeCityTotal(String s, double d);

    protected abstract void writeGrandTotal(double d);

    protected StringBuffer getStringBuffer()
    {
        return buffer;
    }

    private double grandTotal;
    private double cityTotal;
    private StringBuffer buffer;
}
