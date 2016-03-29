// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ItextTotalWrapper.java

package org.displaytag.sample.decorators;

import com.lowagie.text.*;
import org.displaytag.render.ItextTableWriter;

// Referenced classes of package org.displaytag.sample.decorators:
//            TotalWrapperTemplate

public class ItextTotalWrapper extends TotalWrapperTemplate
    implements ItextTableWriter.ItextDecorator
{

    public ItextTotalWrapper()
    {
    }

    public void setTable(Table table)
    {
        this.table = table;
    }

    public void setFont(Font font)
    {
        this.font = font;
    }

    public String startRow()
    {
        //table.setDefaultCellBorder(2);
        return null;
    }

    protected void writeCityTotal(String city, double total)
    {
        writeTotal(city, total);
    }

    protected void writeGrandTotal(double total)
    {
        writeTotal("Grand", total);
    }

    private void writeTotal(String value, double total)
    {
        if(assertRequiredState())
            try
            {
                //font = FontFactory.getFont(font.getFamilyname(), font.size(), 1, font.color());
                table.addCell(getCell(""));
                table.addCell(getCell(""));
                table.addCell(getCell("-------------"));
                table.addCell(getCell(""));
                table.addCell(getCell(""));
                table.addCell(getCell(value + " Total:"));
                table.addCell(getCell(total + ""));
                table.addCell(getCell(""));
            }
            catch(BadElementException e) { }
    }

    private Cell getCell(String value)
        throws BadElementException
    {
        Cell cell = new Cell(new Chunk(value, font));
        cell.setLeading(8F);
        cell.setHorizontalAlignment(0);
        return cell;
    }

    private boolean assertRequiredState()
    {
        return table != null && font != null;
    }

    private Table table;
    private Font font;
}
