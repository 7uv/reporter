// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RandomSampleUtil.java

package org.displaytag.sample;

import java.util.*;

public final class RandomSampleUtil
{

    private RandomSampleUtil()
    {
    }

    public static String getRandomWord()
    {
        return words[random.nextInt(words.length)];
    }

    public static String getRandomSentence(int wordNumber)
    {
        StringBuffer buffer = new StringBuffer(wordNumber * 12);
        for(int j = 0; j < wordNumber; j++)
        {
            buffer.append(getRandomWord());
            buffer.append(" ");
        }

        return buffer.toString();
    }

    public static String getRandomEmail()
    {
        return getRandomWord() + "@" + getRandomWord() + ".com";
    }

    public static Date getRandomDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 365 - random.nextInt(730));
        return calendar.getTime();
    }

    private static String words[] = {
        "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", 
        "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", 
        "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", 
        "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", 
        "no", "sea", "takimata", "sanctus", "est"
    };
    private static Random random = new Random();

}
