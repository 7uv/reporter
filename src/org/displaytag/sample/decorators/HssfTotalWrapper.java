// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HssfTotalWrapper.java

package org.displaytag.sample.decorators;

import org.apache.poi.hssf.usermodel.*;
import org.displaytag.decorator.hssf.DecoratesHssf;

// Referenced classes of package org.displaytag.sample.decorators:
//            TotalWrapperTemplate

public class HssfTotalWrapper extends TotalWrapperTemplate
    implements DecoratesHssf
{

    public HssfTotalWrapper()
    {
    }

    protected void writeCityTotal(String city, double total)
    {
        writeTotal(city, total);
    }

    private void writeTotal(String value, double total)
    {
        if(assertRequiredState())
        {
            int rowNum = sheet.getLastRowNum();
            currentRow = sheet.createRow(++rowNum);
            colNum = 0;
            prepareCell();
            prepareCell();
            prepareCell();
            currentCell.setCellValue(new HSSFRichTextString("------------"));
            currentRow = sheet.createRow(++rowNum);
            colNum = 0;
            prepareCell();
            prepareCell();
            currentCell.setCellValue(new HSSFRichTextString(value + " Total:"));
            prepareCell();
            currentCell.setCellValue(total);
        }
    }

    private void prepareCell()
    {
        currentCell = currentRow.createCell(colNum++);
    }

    protected void writeGrandTotal(double total)
    {
        writeTotal("Grand", total);
    }

    public void setSheet(HSSFSheet sheet)
    {
        this.sheet = sheet;
    }

    private boolean assertRequiredState()
    {
        return sheet != null;
    }

    private HSSFSheet sheet;
    private HSSFCell currentCell;
    private HSSFRow currentRow;
    private int colNum;
}
