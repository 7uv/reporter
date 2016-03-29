// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ListObject.java

package org.displaytag.sample;

import java.io.Serializable;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// Referenced classes of package org.displaytag.sample:
//            RandomSampleUtil

public class ListObject
    implements Serializable
{
    public static class SubListItem
        implements Serializable
    {

        public String getName()
        {
            return itemName;
        }

        public String getEmail()
        {
            return itemEmail;
        }

        public String toString()
        {
            return (new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)).append("name", itemName).append("email", itemEmail).toString();
        }

        private static final long serialVersionUID = 42L;
        private String itemName;
        private String itemEmail;

        public SubListItem()
        {
            itemName = RandomSampleUtil.getRandomWord();
            itemEmail = RandomSampleUtil.getRandomEmail();
        }
    }


    public ListObject()
    {
        id = -1;
        id = random.nextInt(0x1869e) + 1;
        money = (random.nextInt(0xf423e) + 1) / 100;
        String firstName = RandomSampleUtil.getRandomWord();
        String lastName = RandomSampleUtil.getRandomWord();
        name = StringUtils.capitalize(firstName) + ' ' + StringUtils.capitalize(lastName);
        email = firstName + '-' + lastName + '@' + RandomSampleUtil.getRandomWord() + ".com";
        date = RandomSampleUtil.getRandomDate();
        description = RandomSampleUtil.getRandomWord() + ' ' + RandomSampleUtil.getRandomWord() + "...";
        longDescription = RandomSampleUtil.getRandomSentence(10);
        status = RandomSampleUtil.getRandomWord().toUpperCase();
        subList = new ArrayList();
        subList.add(new SubListItem());
        subList.add(new SubListItem());
        subList.add(new SubListItem());
        url = "http://www." + lastName + ".org/";
    }

    public int getId()
    {
        return id;
    }

    public void setId(int value)
    {
        id = value;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String value)
    {
        email = value;
    }

    public Date getDate()
    {
        return (Date)date.clone();
    }

    public double getMoney()
    {
        return money;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return longDescription;
    }

    public String getStatus()
    {
        return status;
    }

    public String getUrl()
    {
        return url;
    }

    public String getNullValue()
    {
        return null;
    }

    public String toString()
    {
        return "ListObject(" + id + ")";
    }

    public String toDetailedString()
    {
        return "ID:          " + id + "\n" + "Name:        " + name + "\n" + "Email:       " + email + "\n" + "Date:        " + date + "\n" + "Money:       " + money + "\n" + "Description: " + description + "\n" + "Status:      " + status + "\n" + "URL:         " + url + "\n";
    }

    public List getSubList()
    {
        return subList;
    }

    private static final long serialVersionUID = 42L;
    private static Random random = new Random();
    private int id;
    private String name;
    private String email;
    private Date date;
    private double money;
    private String description;
    private String longDescription;
    private String status;
    private String url;
    private List subList;

}
