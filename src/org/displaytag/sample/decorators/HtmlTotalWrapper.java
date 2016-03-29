// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HtmlTotalWrapper.java

package org.displaytag.sample.decorators;


// Referenced classes of package org.displaytag.sample.decorators:
//            TotalWrapperTemplate

public class HtmlTotalWrapper extends TotalWrapperTemplate
{

    public HtmlTotalWrapper()
    {
    }

    protected void writeCityTotal(String city, double total)
    {
        StringBuffer buffer = getStringBuffer();
        buffer.append("\n<tr>\n<td>&nbsp;</td><td>&nbsp;</td><td><hr/></td>");
        buffer.append("\n<td>&nbsp;</td></tr>");
        buffer.append("\n<tr><td>&nbsp;</td>");
        buffer.append("\n<td align=\"right\"><strong>" + city + " Total:</strong></td>\n<td><strong>");
        buffer.append(total);
        buffer.append("</strong></td>\n<td>&nbsp;</td>\n</tr>");
        buffer.append("\n<tr>\n<td colspan=\"4\">&nbsp;\n</td>\n</tr>");
    }

    protected void writeGrandTotal(double total)
    {
        StringBuffer buffer = getStringBuffer();
        buffer.append("<tr><td colspan=\"4\"><hr/></td></tr>");
        buffer.append("<tr><td>&nbsp;</td>");
        buffer.append("<td align=\"right\"><strong>Grand Total:</strong></td><td><strong>");
        buffer.append(total);
        buffer.append("</strong></td><td>&nbsp;</td></tr>");
    }
}
