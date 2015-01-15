package kr.co.heylark.LunarCalendar;
import gz.aas.calc8words.com.InParm8Words;
import gz.aas.calc8words.com.LunarCalendar200;
import gz.aas.calc8words.com.OutParm8Words;
import gz.aas.calc8words.com.ParmCalendar;
import gz.aas.calc8words.com.Tips4GanNZhi;
import gz.aas.calc8words.com.Util8Words;
import gz.aas.calc8words.com.WuXingScore;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;

public class TestUtil8Words {

	  public static void main(String[] paramArrayOfString)
	  {
	    //testMatchLunar();
		  //testLunar();
		  testLoopCalc8Words();
		  //testOneCalc8Words();
//	    new InParm8Words(1981, 4, 5, 21, false);
	  }

	private static String array2String(int[] paramArrayOfInt)
	  {
	    StringBuffer localStringBuffer = new StringBuffer();
	    for (int i = 0; ; i++)
	    {
	      if (i >= paramArrayOfInt.length)
	        return localStringBuffer.toString();
	      localStringBuffer.append(paramArrayOfInt[i] + ";");
	    }
	  }

	  static String get2ndPart(String paramString1, String paramString2)
	  {
	    int i = paramString1.indexOf(paramString2);
	    if (i < 0)
	      return "";
	    return paramString1.substring(i + paramString2.length());
	  }

	  static void printNewDate(InParm8Words paramInParm8Words)
	  {
	    InParm8Words localInParm8Words = Util8Words.getNewInParm8Words(paramInParm8Words);
	    if (localInParm8Words.isGoodChineseInputDate())
	    {
	      System.out.println(" New Date:" + localInParm8Words.getYear() + "-" + localInParm8Words.getMonth() + "-" + localInParm8Words.getDay() + " " + localInParm8Words.getHour() + "hrs");
	      System.out.println("LM:" + paramInParm8Words.isChinese2Month() + " Old Date:" + paramInParm8Words.getLunar_year() + "-" + paramInParm8Words.getLunar_month() + "-" + paramInParm8Words.getLunar_day() + " " + paramInParm8Words.getLunar_hour() + "hrs");
	      return;
	    }
	    System.out.println(" --- New Date to Old Date ---");
	    System.out.println(" Can not find the new date...");
	    System.out.println("LM:" + paramInParm8Words.isChinese2Month() + " Old Date:" + paramInParm8Words.getLunar_year() + "-" + paramInParm8Words.getLunar_month() + "-" + paramInParm8Words.getLunar_day() + " " + paramInParm8Words.getLunar_hour() + "hrs");
	  }

	  /**
	   * test eight word with both gender
	   */
	  private static void testLoopCalc8Words()
	  {
		  /*
	    int i = 2101;//year
	    int j = 0;
	    int k = 1;
	    int m = 0;
	    int n = 0;
	    */
		    int i = 1983;//year
		    int j = 0;//month
		    int k = 21;//day
		    int m = 16;//hour?
		    int n = 11;//minutes?
	    Calendar localCalendar = Calendar.getInstance();
	    int i2;
	    for (int i1 = 0; ; i1++)
	    {
	      if (i1 >= 10)
	        return;
	      localCalendar.set(i, j, k, m, 0);
	      i2 = localCalendar.get(1);
	      j = localCalendar.get(2);
	      k = localCalendar.get(5);
	      m = localCalendar.get(11);
	      if (i2 < i + 1)
	        break;
	      i++;
	    }
	    n++;
	    int i3 = 0;
	    while (true)
	    {
	      if (i3 >= 2)
	      {
	        localCalendar.add(11, 1);
	        i2 = localCalendar.get(1);
	        j = localCalendar.get(2);
	        k = localCalendar.get(5);
	        m = localCalendar.get(11);
	        break;
	      }
	      int i4 = i3;
	      System.out.println("[testLoopCalc8Words] " + n + ":" + i + "-" + (j + 1) + "-" + k + " " + m + "hrs -> i_gender:" + i4);
	      int i5 = j + 1;
	      InParm8Words localInParm8Words = new InParm8Words(i, i5, k, m, false);
	      localInParm8Words.setIGender(i4);//0 ~ male , 1 ~ female
	        
	      try
	      {
	        OutParm8Words localOutParm8Words = Util8Words.calc8Words(localInParm8Words);
	        WuXingScore localWuXingScore = new WuXingScore();
	        int i6 = localOutParm8Words.getIDayColUp();
	        Util8Words.calcShenQiang(Util8Words.addWuXingScore(Util8Words.addWuXingScore(Util8Words.addWuXingScore(Util8Words.addWuXingScore(Util8Words.addWuXingScore(Util8Words.addWuXingScore(Util8Words.addWuXingScore(Util8Words.addWuXingScore(localWuXingScore, 0, localOutParm8Words.getIYearColUp(), i6), 0, localOutParm8Words.getIMonthColUp(), i6), 0, localOutParm8Words.getIDayColUp(), -1), 0, localOutParm8Words.getIHourColUp(), i6), 1, localOutParm8Words.getIYearColDown(), i6), 2, localOutParm8Words.getIMonthColDown(), i6), 1, localOutParm8Words.getIDayColDown(), i6), 1, localOutParm8Words.getIHourColDown(), i6), i6);
	        System.out.println("[testLoopCalc8Words]OK:" + localOutParm8Words.getYearColUp() + localOutParm8Words.getYearColDown() + "<<" + localOutParm8Words.getMonthColUp() + localOutParm8Words.getMonthColDown() + "<<" + localOutParm8Words.getDayColUp() + localOutParm8Words.getDayColDown() + "<<" + localOutParm8Words.getHourColUp() + localOutParm8Words.getHourColDown());
	        i3++;

	        System.out.println("localOutParm8Words = "+localOutParm8Words.toString());

	        System.out.println("localInParm8Words = "+localInParm8Words);
	        System.out.println("localInParm8Words = "+
	        ", getYear = "+localInParm8Words.getYear()+
	        ", getMonth = "+localInParm8Words.getMonth()+
	        ", getDay = "+localInParm8Words.getDay()+
	        ", getHour = "+localInParm8Words.getHour());
	        System.out.println("localInParm8Words = "+
	        ", getLunar_year = "+localInParm8Words.getLunar_year()+
	        ", getLunar_month = "+localInParm8Words.getLunar_month()+
	        ", getLunar_day = "+localInParm8Words.getLunar_day()+
	        ", getLunar_hour = "+localInParm8Words.getLunar_hour());
	      }
	      catch (Exception localException)
	      {
	        while (true)
	          System.out.println("[testLoopCalc8Words] Error: " + localException.getMessage() + " when calc (" + i + "-" + (j + 1) + "-" + k + " " + m + "hrs,i_gender:" + i4 + ").");
	      }
	    }
	  }

	  static void testLunar()
	  {
	    LunarCalendar200 localLunarCalendar200 = new LunarCalendar200();
	    localLunarCalendar200.setGregorian(1902, 10, 1);
	    localLunarCalendar200.computeChineseFields();
	    localLunarCalendar200.computeSolarTerms();
	    System.out.println("New Date: 1902-10-1 to Lunar Date:" + localLunarCalendar200.getChineseYear() + "-" + localLunarCalendar200.getChineseMonth() + "-" + localLunarCalendar200.getChineseDate());
	  }

	  static void testMatchLunar()
	  {
	    System.out.println("庚申FirstYear:" + Util8Words.getFirstYear(6, 8, 1911));
	    ArrayList localArrayList = Util8Words.getMatchDate(6, 8, 4, 0, 0, 2, 1, 11, true);
	    if (localArrayList.size() <= 0){
	      System.out.println("Cann't find result!");
	      return;
	    } else{
		      System.out.println("localArrayList.size()="+localArrayList.size());
	    }
	    /*
	    while (true)
	    {
	      return;
	    */
	      System.out.println("--- All Results ---");
	      for (int i = 0; i < localArrayList.size(); i++)
	      {
	        ParmCalendar localParmCalendar = (ParmCalendar)localArrayList.get(i);
	        System.out.println("--- Result " + (i + 1));
	        System.out.println(localParmCalendar.toString());
	      }
	      /*
	    }
	    */
	  }

	  private static void testOneCalc8Words()
	  {
	    InParm8Words localInParm8Words = new InParm8Words(1983, 2, 5, 22, false);
	    localInParm8Words.setIGender(0);
	    localInParm8Words.setCalZiHourAddOrNot(true);
	    OutParm8Words localOutParm8Words = Util8Words.calc8Words(localInParm8Words);
	    System.out.println(localOutParm8Words.toString());
	  }

	  private static void testSortNSkip_Tips4GanNZhi(int[] paramArrayOfInt)
	  {
	    System.out.println("[testSortNSkip_Tips4GanNZhi] source:" + array2String(paramArrayOfInt));
	    int[] arrayOfInt = Tips4GanNZhi.testNSkip(paramArrayOfInt);
	    System.out.println("[testSortNSkip_Tips4GanNZhi] source2:" + array2String(paramArrayOfInt));
	    System.out.println("[testSortNSkip_Tips4GanNZhi] return:" + array2String(arrayOfInt));
	  }
}
