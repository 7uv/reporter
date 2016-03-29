// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LongDateWrapper.java

package org.displaytag.sample;

import java.util.Date;
import javax.servlet.jsp.PageContext;
import org.apache.commons.lang.time.FastDateFormat;
import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class LongDateWrapper
  implements DisplaytagColumnDecorator
{

    public LongDateWrapper()
    {
        dateFormat = FastDateFormat.getInstance("MM/dd/yyyy HH:mm:ss");
    }

    public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media)
        throws DecoratorException
    {
        Date date = (Date)columnValue;
        return dateFormat.format(date);
    }

    private FastDateFormat dateFormat;
}
