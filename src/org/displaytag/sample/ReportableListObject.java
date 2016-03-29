// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReportableListObject.java

package org.displaytag.sample;

import java.io.Serializable;
import java.util.Random;
import org.apache.commons.lang.builder.*;

// Referenced classes of package org.displaytag.sample:
//            RandomSampleUtil

public class ReportableListObject
    implements Comparable, Serializable
{

    public ReportableListObject()
    {
        amount = (random.nextInt(0x1869f) + 1) / 100;
        city = cities[random.nextInt(cities.length)];
        project = projects[random.nextInt(projects.length)];
        task = RandomSampleUtil.getRandomSentence(4);
        count = random.nextInt(10);
    }

    public String getCity()
    {
        return city;
    }

    public int getCount()
    {
        return count;
    }

    public String getProject()
    {
        return project;
    }

    public String getTask()
    {
        return task;
    }

    public double getAmount()
    {
        return amount;
    }

    public int compareTo(Object object)
    {
        ReportableListObject myClass = (ReportableListObject)object;
        return (new CompareToBuilder()).append(project, myClass.project).append(amount, myClass.amount).append(city, myClass.city).append(task, myClass.task).toComparison();
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)).append("project", project).append("amount", amount).append("city", city).append("task", task).toString();
    }

    private static final long serialVersionUID = 0xd1597a17a6L;
    private static Random random = new Random();
    private static String cities[] = {
        "Roma", "Olympia", "Neapolis", "Carthago"
    };
    private static String projects[] = {
        "Taxes", "Arts", "Army", "Gladiators"
    };
    private String city;
    private String project;
    private String task;
    private double amount;
    private int count;

}
