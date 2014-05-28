package kr.co.heylark.LunarCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.ibm.icu.util.ChineseCalendar;

public class LunarCalendar {

	final private String YEAR_FORMAT = "yyyy";
	final private String MONTH_FORMAT = "MM";
	final private String DAY_FORMAT = "dd";
	final private int CALENDAR_YEAR_GAP = 2637;
	final private int CALENDAR_MONTH_GAP = 1;
	
	
	private Calendar cal;
	private ChineseCalendar ccal;
	
	protected SimpleDateFormat year_sdf = new SimpleDateFormat(YEAR_FORMAT);
	protected SimpleDateFormat month_sdf = new SimpleDateFormat(MONTH_FORMAT);
	protected SimpleDateFormat day_sdf = new SimpleDateFormat(DAY_FORMAT);
	protected SimpleDateFormat default_sdf = new SimpleDateFormat(YEAR_FORMAT+MONTH_FORMAT+DAY_FORMAT);
	
	private TimeZone timezone=null;
	private Locale locale=null;
	private com.ibm.icu.util.TimeZone icu_timezone=null;
	
	public LunarCalendar() {
		this(null, null);
	}
	
	public LunarCalendar(Locale plocale) {
		this(null, plocale);
	}
	
	public LunarCalendar(TimeZone ptimezone) {
		this(ptimezone, null);
	}
	
	public LunarCalendar(TimeZone ptimezone, Locale plocale) {
		if(ptimezone==null){
			timezone=TimeZone.getDefault();
		}else{
			timezone=ptimezone;
		}
		if(plocale==null){
			locale=Locale.getDefault();
		}else{
			locale=plocale;
		}
		icu_timezone = com.ibm.icu.util.TimeZone.getTimeZone(timezone.getID());
		
		cal=Calendar.getInstance(timezone, locale);
		ccal=new ChineseCalendar(icu_timezone, locale);
	}
	
	public Date LunarToGregorian(Date date){
		cal = Calendar.getInstance(timezone, locale);
		ccal = new ChineseCalendar(icu_timezone, locale);
		
		ccal.set(ChineseCalendar.EXTENDED_YEAR, Integer.parseInt(year_sdf.format(date))+CALENDAR_YEAR_GAP);
		ccal.set(ChineseCalendar.MONTH, Integer.parseInt(month_sdf.format(date))-CALENDAR_MONTH_GAP);
		ccal.set(ChineseCalendar.DAY_OF_MONTH, Integer.parseInt(day_sdf.format(date)));
		
		cal.setTimeInMillis(ccal.getTimeInMillis());
		return cal.getTime();
	}
	
	public Date GregorianToLunar(Date date){
		cal = Calendar.getInstance(timezone, locale);
		ccal = new ChineseCalendar(icu_timezone, locale);
		
		cal.set(Calendar.YEAR, Integer.parseInt(year_sdf.format(date)));
		cal.set(Calendar.MONTH, Integer.parseInt(month_sdf.format(date))-CALENDAR_MONTH_GAP);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day_sdf.format(date)));
		
		ccal.setTimeInMillis(cal.getTimeInMillis());
		
		cal.set(Calendar.YEAR, ccal.get(ChineseCalendar.EXTENDED_YEAR)-CALENDAR_YEAR_GAP);
		cal.set(Calendar.MONTH, ccal.get(ChineseCalendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH, ccal.get(ChineseCalendar.DAY_OF_MONTH));
		
		return cal.getTime();
	}

	public SimpleDateFormat getDefault_sdf() {
		return default_sdf;
	}

	public void setDefault_sdf(SimpleDateFormat default_sdf) {
		this.default_sdf = default_sdf;
	}
	
}
