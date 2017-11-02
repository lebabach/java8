package baby;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import utils.LunarCalendarUtils;
import utils.MoonCalculation;

public class LunarDateTest {
	LocalDate dateInitBaby = null;
	public LocalDate getDateInitBaby() {
		return dateInitBaby;
	}

	public void setDateInitBaby(LocalDate dateInitBaby) {
		this.dateInitBaby = dateInitBaby;
	}

	public static void main(String[] a) {
		/*LocalDate now =  LocalDate.now();
		int [] dateBirthdayLunar=LunarCalendarUtils.convertSolar2Lunar(23, 02, 1988, 7);
		int [] dateNowLunar=LunarCalendarUtils.convertSolar2Lunar(07, 02, 2015, 7);
		
		int age = dateNowLunar[2]-dateBirthdayLunar[2];  
		if((dateNowLunar[1]<dateBirthdayLunar[1]) || (dateNowLunar[1]==dateBirthdayLunar[1]) && (dateNowLunar[0]<dateBirthdayLunar[0])){
			age--;
		}
		
		System.out.println(age);
		//Years age = Years.yearsBetween(birthdate, now);
		System.out.println("NOW: year: "+dateNowLunar[2]+" month: "+dateNowLunar[1]+" day: "+dateNowLunar[0]);
		System.out.println("BIRTHDAY: year: "+dateBirthdayLunar[2]+" month: "+dateBirthdayLunar[1]+" day: "+dateBirthdayLunar[0]);*/
		
		
		 (new LunarDateTest()).process();
	}
	
	private void process(){
		 /*LocalDate preparedBirthday = LocalDate.of(2015, Month.NOVEMBER, 12);
		 LocalDate bithdayMom = LocalDate.of(1989, Month.AUGUST, 1);*/
		 LocalDate preparedBirthday = LocalDate.of(2015, Month.NOVEMBER, 13);
		 LocalDate bithdayMom = LocalDate.of(1989, Month.AUGUST, 23);
		 InitBabyInAgeOfMom initBabyInAgeOfMom=getLunarAge(preparedBirthday, bithdayMom);
		 List<PreparationBirthday> data=initData();
		 Boolean isBoy= data.stream().filter(d->d.getAgeOfMom()==initBabyInAgeOfMom.getAgeOfMom()).collect(Collectors.toList())
		 .stream().flatMap(x->x.getPreparationMonths().stream()).filter(x->x.getMonth()==initBabyInAgeOfMom.getInitMonthBaby()).map(x->x.isBoy()).findFirst().get();
		 if(isBoy){
			 System.out.println("is boy");
		 }else{
			 System.out.println("is girl");
		 }
	}
	
	
	private static List<PreparationBirthday> initData(){
		List<PreparationBirthday> data=null;
		//init mom 18 age;
		PreparationBirthday mon18=new PreparationBirthday();
		//Preparation Month for mom 18 age
		List<PreparationMonth> PreparationMonth18s=new ArrayList<PreparationMonth>();
		PreparationMonth18s.add(new PreparationMonth(1,false));
		PreparationMonth18s.add(new PreparationMonth(2,true));
		PreparationMonth18s.add(new PreparationMonth(3,false));
		PreparationMonth18s.add(new PreparationMonth(4,true));
		PreparationMonth18s.add(new PreparationMonth(5,false));
		PreparationMonth18s.add(new PreparationMonth(6,false));
		PreparationMonth18s.add(new PreparationMonth(7,false));
		PreparationMonth18s.add(new PreparationMonth(8,false));
		PreparationMonth18s.add(new PreparationMonth(9,false));
		PreparationMonth18s.add(new PreparationMonth(10,false));
		PreparationMonth18s.add(new PreparationMonth(11,false));
		PreparationMonth18s.add(new PreparationMonth(12,false));
		//set age of mom
		mon18.setAgeOfMom(18);
		mon18.setPreparationMonths(PreparationMonth18s);
		
		//init mon 19 age;
		PreparationBirthday mon19=new PreparationBirthday();
		//Preparation Month for mom 19 age
		List<PreparationMonth> PreparationMonth19s=new ArrayList<PreparationMonth>();
		PreparationMonth19s.add(new PreparationMonth(1,true));
		PreparationMonth19s.add(new PreparationMonth(2,false));
		PreparationMonth19s.add(new PreparationMonth(3,true));
		PreparationMonth19s.add(new PreparationMonth(4,false));
		PreparationMonth19s.add(new PreparationMonth(5,false));
		PreparationMonth19s.add(new PreparationMonth(6,true));
		PreparationMonth19s.add(new PreparationMonth(7,false));
		PreparationMonth19s.add(new PreparationMonth(8,false));
		PreparationMonth19s.add(new PreparationMonth(9,false));
		PreparationMonth19s.add(new PreparationMonth(10,false));
		PreparationMonth19s.add(new PreparationMonth(11,false));
		PreparationMonth19s.add(new PreparationMonth(12,false));
		//set age of mom
		mon19.setAgeOfMom(19);
		mon19.setPreparationMonths(PreparationMonth19s);
		
		
		//init mon 20 age;
		PreparationBirthday mon20=new PreparationBirthday();
		//Preparation Month for mom 20 age
		List<PreparationMonth> PreparationMonth20s=new ArrayList<PreparationMonth>();
		PreparationMonth20s.add(new PreparationMonth(1,false));
		PreparationMonth20s.add(new PreparationMonth(2,true));
		PreparationMonth20s.add(new PreparationMonth(3,false));
		PreparationMonth20s.add(new PreparationMonth(4,true));
		PreparationMonth20s.add(new PreparationMonth(5,true));
		PreparationMonth20s.add(new PreparationMonth(6,true));
		PreparationMonth20s.add(new PreparationMonth(7,true));
		PreparationMonth20s.add(new PreparationMonth(8,true));
		PreparationMonth20s.add(new PreparationMonth(9,true));
		PreparationMonth20s.add(new PreparationMonth(10,true));
		PreparationMonth20s.add(new PreparationMonth(11,true));
		PreparationMonth20s.add(new PreparationMonth(12,true));
		//set age of mom
		mon20.setAgeOfMom(20);
		mon20.setPreparationMonths(PreparationMonth20s);
		
		//init mon 21 age;
		PreparationBirthday mon21=new PreparationBirthday();
		//Preparation Month for mom 21 age
		List<PreparationMonth> PreparationMonth21s=new ArrayList<PreparationMonth>();
		PreparationMonth21s.add(new PreparationMonth(1,true));
		PreparationMonth21s.add(new PreparationMonth(2,false));
		PreparationMonth21s.add(new PreparationMonth(3,false));
		PreparationMonth21s.add(new PreparationMonth(4,false));
		PreparationMonth21s.add(new PreparationMonth(5,false));
		PreparationMonth21s.add(new PreparationMonth(6,false));
		PreparationMonth21s.add(new PreparationMonth(7,false));
		PreparationMonth21s.add(new PreparationMonth(8,false));
		PreparationMonth21s.add(new PreparationMonth(9,false));
		PreparationMonth21s.add(new PreparationMonth(10,false));
		PreparationMonth21s.add(new PreparationMonth(11,false));
		PreparationMonth21s.add(new PreparationMonth(12,false));
		
		//set age of mom
		mon21.setAgeOfMom(21);
		mon21.setPreparationMonths(PreparationMonth21s);
		
		//init mon 22 age;
		PreparationBirthday mon22=new PreparationBirthday();
		//Preparation Month for mom 22 age
		List<PreparationMonth> PreparationMonth22s=new ArrayList<PreparationMonth>();
		PreparationMonth22s.add(new PreparationMonth(1,false));
		PreparationMonth22s.add(new PreparationMonth(2,true));
		PreparationMonth22s.add(new PreparationMonth(3,true));
		PreparationMonth22s.add(new PreparationMonth(4,false));
		PreparationMonth22s.add(new PreparationMonth(5,true));
		PreparationMonth22s.add(new PreparationMonth(6,true));
		PreparationMonth22s.add(new PreparationMonth(7,true));
		PreparationMonth22s.add(new PreparationMonth(8,false));
		PreparationMonth22s.add(new PreparationMonth(9,false));
		PreparationMonth22s.add(new PreparationMonth(10,false));
		PreparationMonth22s.add(new PreparationMonth(11,false));
		PreparationMonth22s.add(new PreparationMonth(12,false));
		
		//set age of mom
		mon22.setAgeOfMom(22);
		mon22.setPreparationMonths(PreparationMonth22s);
		
		//init mon 23 age;
		PreparationBirthday mon23=new PreparationBirthday();
		//Preparation Month for mom 23 age
		List<PreparationMonth> PreparationMonth23s=new ArrayList<PreparationMonth>();
		PreparationMonth23s.add(new PreparationMonth(1,true));
		PreparationMonth23s.add(new PreparationMonth(2,true));
		PreparationMonth23s.add(new PreparationMonth(3,false));
		PreparationMonth23s.add(new PreparationMonth(4,true));
		PreparationMonth23s.add(new PreparationMonth(5,true));
		PreparationMonth23s.add(new PreparationMonth(6,false));
		PreparationMonth23s.add(new PreparationMonth(7,true));
		PreparationMonth23s.add(new PreparationMonth(8,false));
		PreparationMonth23s.add(new PreparationMonth(9,true));
		PreparationMonth23s.add(new PreparationMonth(10,true));
		PreparationMonth23s.add(new PreparationMonth(11,true));
		PreparationMonth23s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon23.setAgeOfMom(23);
		mon23.setPreparationMonths(PreparationMonth23s);
		
		//init mon 24 age;
		PreparationBirthday mon24=new PreparationBirthday();
		//Preparation Month for mom 24 age
		List<PreparationMonth> PreparationMonth24s=new ArrayList<PreparationMonth>();
		PreparationMonth24s.add(new PreparationMonth(1,true));
		PreparationMonth24s.add(new PreparationMonth(2,false));
		PreparationMonth24s.add(new PreparationMonth(3,true));
		PreparationMonth24s.add(new PreparationMonth(4,true));
		PreparationMonth24s.add(new PreparationMonth(5,false));
		PreparationMonth24s.add(new PreparationMonth(6,true));
		PreparationMonth24s.add(new PreparationMonth(7,true));
		PreparationMonth24s.add(new PreparationMonth(8,false));
		PreparationMonth24s.add(new PreparationMonth(9,false));
		PreparationMonth24s.add(new PreparationMonth(10,false));
		PreparationMonth24s.add(new PreparationMonth(11,false));
		PreparationMonth24s.add(new PreparationMonth(12,false));
		
		//set age of mom
		mon24.setAgeOfMom(24);
		mon24.setPreparationMonths(PreparationMonth24s);
		
		//init mon 25 age;
		PreparationBirthday mon25=new PreparationBirthday();
		//Preparation Month for mom 25 age
		List<PreparationMonth> PreparationMonth25s=new ArrayList<PreparationMonth>();
		PreparationMonth25s.add(new PreparationMonth(1,false));
		PreparationMonth25s.add(new PreparationMonth(2,true));
		PreparationMonth25s.add(new PreparationMonth(3,true));
		PreparationMonth25s.add(new PreparationMonth(4,false));
		PreparationMonth25s.add(new PreparationMonth(5,true));
		PreparationMonth25s.add(new PreparationMonth(6,false));
		PreparationMonth25s.add(new PreparationMonth(7,true));
		PreparationMonth25s.add(new PreparationMonth(8,true));
		PreparationMonth25s.add(new PreparationMonth(9,true));
		PreparationMonth25s.add(new PreparationMonth(10,true));
		PreparationMonth25s.add(new PreparationMonth(11,true));
		PreparationMonth25s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon25.setAgeOfMom(25);
		mon25.setPreparationMonths(PreparationMonth25s);
		
		//init mon 26 age;
		PreparationBirthday mon26=new PreparationBirthday();
		//Preparation Month for mom 26 age
		List<PreparationMonth> PreparationMonth26s=new ArrayList<PreparationMonth>();
		PreparationMonth26s.add(new PreparationMonth(1,true));
		PreparationMonth26s.add(new PreparationMonth(2,false));
		PreparationMonth26s.add(new PreparationMonth(3,true));
		PreparationMonth26s.add(new PreparationMonth(4,false));
		PreparationMonth26s.add(new PreparationMonth(5,false));
		PreparationMonth26s.add(new PreparationMonth(6,true));
		PreparationMonth26s.add(new PreparationMonth(7,false));
		PreparationMonth26s.add(new PreparationMonth(8,true));
		PreparationMonth26s.add(new PreparationMonth(9,false));
		PreparationMonth26s.add(new PreparationMonth(10,false));
		PreparationMonth26s.add(new PreparationMonth(11,false));
		PreparationMonth26s.add(new PreparationMonth(12,false));
		
		//set age of mom
		mon26.setAgeOfMom(26);
		mon26.setPreparationMonths(PreparationMonth26s);
		
		//init mon 27 age;
		PreparationBirthday mon27=new PreparationBirthday();
		//Preparation Month for mom 27 age
		List<PreparationMonth> PreparationMonth27s=new ArrayList<PreparationMonth>();
		PreparationMonth27s.add(new PreparationMonth(1,false));
		PreparationMonth27s.add(new PreparationMonth(2,true));
		PreparationMonth27s.add(new PreparationMonth(3,false));
		PreparationMonth27s.add(new PreparationMonth(4,true));
		PreparationMonth27s.add(new PreparationMonth(5,true));
		PreparationMonth27s.add(new PreparationMonth(6,false));
		PreparationMonth27s.add(new PreparationMonth(7,true));
		PreparationMonth27s.add(new PreparationMonth(8,true));
		PreparationMonth27s.add(new PreparationMonth(9,true));
		PreparationMonth27s.add(new PreparationMonth(10,false));
		PreparationMonth27s.add(new PreparationMonth(11,true));
		PreparationMonth27s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon27.setAgeOfMom(27);
		mon27.setPreparationMonths(PreparationMonth27s);
		
		//init mon 28 age;
		PreparationBirthday mon28=new PreparationBirthday();
		//Preparation Month for mom 28 age
		List<PreparationMonth> PreparationMonth28s=new ArrayList<PreparationMonth>();
		PreparationMonth28s.add(new PreparationMonth(1,true));
		PreparationMonth28s.add(new PreparationMonth(2,false));
		PreparationMonth28s.add(new PreparationMonth(3,true));
		PreparationMonth28s.add(new PreparationMonth(4,false));
		PreparationMonth28s.add(new PreparationMonth(5,false));
		PreparationMonth28s.add(new PreparationMonth(6,false));
		PreparationMonth28s.add(new PreparationMonth(7,true));
		PreparationMonth28s.add(new PreparationMonth(8,true));
		PreparationMonth28s.add(new PreparationMonth(9,true));
		PreparationMonth28s.add(new PreparationMonth(10,true));
		PreparationMonth28s.add(new PreparationMonth(11,false));
		PreparationMonth28s.add(new PreparationMonth(12,false));
		
		//set age of mom
		mon28.setAgeOfMom(28);
		mon28.setPreparationMonths(PreparationMonth28s);
		
		//init mon 29 age;
		PreparationBirthday mon29=new PreparationBirthday();
		//Preparation Month for mom 29 age
		List<PreparationMonth> PreparationMonth29s=new ArrayList<PreparationMonth>();
		PreparationMonth29s.add(new PreparationMonth(1,false));
		PreparationMonth29s.add(new PreparationMonth(2,true));
		PreparationMonth29s.add(new PreparationMonth(3,false));
		PreparationMonth29s.add(new PreparationMonth(4,true));
		PreparationMonth29s.add(new PreparationMonth(5,true));
		PreparationMonth29s.add(new PreparationMonth(6,true));
		PreparationMonth29s.add(new PreparationMonth(7,true));
		PreparationMonth29s.add(new PreparationMonth(8,true));
		PreparationMonth29s.add(new PreparationMonth(9,true));
		PreparationMonth29s.add(new PreparationMonth(10,false));
		PreparationMonth29s.add(new PreparationMonth(11,false));
		PreparationMonth29s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon29.setAgeOfMom(29);
		mon29.setPreparationMonths(PreparationMonth29s);
		
		//init mon 30 age;
		PreparationBirthday mon30=new PreparationBirthday();
		//Preparation Month for mom 30 age
		List<PreparationMonth> PreparationMonth30s=new ArrayList<PreparationMonth>();
		PreparationMonth30s.add(new PreparationMonth(1,false));
		PreparationMonth30s.add(new PreparationMonth(2,true));
		PreparationMonth30s.add(new PreparationMonth(3,false));
		PreparationMonth30s.add(new PreparationMonth(4,true));
		PreparationMonth30s.add(new PreparationMonth(5,true));
		PreparationMonth30s.add(new PreparationMonth(6,true));
		PreparationMonth30s.add(new PreparationMonth(7,true));
		PreparationMonth30s.add(new PreparationMonth(8,true));
		PreparationMonth30s.add(new PreparationMonth(9,true));
		PreparationMonth30s.add(new PreparationMonth(10,false));
		PreparationMonth30s.add(new PreparationMonth(11,false));
		PreparationMonth30s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon30.setAgeOfMom(30);
		mon30.setPreparationMonths(PreparationMonth30s);
		
		//init mon 31 age;
		PreparationBirthday mon31=new PreparationBirthday();
		//Preparation Month for mom 31 age
		List<PreparationMonth> PreparationMonth31s=new ArrayList<PreparationMonth>();
		PreparationMonth31s.add(new PreparationMonth(1,true));
		PreparationMonth31s.add(new PreparationMonth(2,false));
		PreparationMonth31s.add(new PreparationMonth(3,true));
		PreparationMonth31s.add(new PreparationMonth(4,false));
		PreparationMonth31s.add(new PreparationMonth(5,false));
		PreparationMonth31s.add(new PreparationMonth(6,false));
		PreparationMonth31s.add(new PreparationMonth(7,false));
		PreparationMonth31s.add(new PreparationMonth(8,false));
		PreparationMonth31s.add(new PreparationMonth(9,false));
		PreparationMonth31s.add(new PreparationMonth(10,false));
		PreparationMonth31s.add(new PreparationMonth(11,true));
		PreparationMonth31s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon31.setAgeOfMom(31);
		mon31.setPreparationMonths(PreparationMonth31s);
		
		//init mon 32 age;
		PreparationBirthday mon32=new PreparationBirthday();
		//Preparation Month for mom 32 age
		List<PreparationMonth> PreparationMonth32s=new ArrayList<PreparationMonth>();
		PreparationMonth32s.add(new PreparationMonth(1,true));
		PreparationMonth32s.add(new PreparationMonth(2,false));
		PreparationMonth32s.add(new PreparationMonth(3,true));
		PreparationMonth32s.add(new PreparationMonth(4,false));
		PreparationMonth32s.add(new PreparationMonth(5,false));
		PreparationMonth32s.add(new PreparationMonth(6,false));
		PreparationMonth32s.add(new PreparationMonth(7,false));
		PreparationMonth32s.add(new PreparationMonth(8,false));
		PreparationMonth32s.add(new PreparationMonth(9,false));
		PreparationMonth32s.add(new PreparationMonth(10,false));
		PreparationMonth32s.add(new PreparationMonth(11,true));
		PreparationMonth32s.add(new PreparationMonth(12,true));
		
		//init mon 33 age;
		PreparationBirthday mon33=new PreparationBirthday();
		//Preparation Month for mom 33 age
		List<PreparationMonth> PreparationMonth33s=new ArrayList<PreparationMonth>();
		PreparationMonth33s.add(new PreparationMonth(1,false));
		PreparationMonth33s.add(new PreparationMonth(2,true));
		PreparationMonth33s.add(new PreparationMonth(3,false));
		PreparationMonth33s.add(new PreparationMonth(4,true));
		PreparationMonth33s.add(new PreparationMonth(5,true));
		PreparationMonth33s.add(new PreparationMonth(6,false));
		PreparationMonth33s.add(new PreparationMonth(7,false));
		PreparationMonth33s.add(new PreparationMonth(8,true));
		PreparationMonth33s.add(new PreparationMonth(9,false));
		PreparationMonth33s.add(new PreparationMonth(10,false));
		PreparationMonth33s.add(new PreparationMonth(11,true));
		PreparationMonth33s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon33.setAgeOfMom(33);
		mon33.setPreparationMonths(PreparationMonth33s);
		
		//init mon 34 age;
		PreparationBirthday mon34=new PreparationBirthday();
		//Preparation Month for mom 34 age
		List<PreparationMonth> PreparationMonth34s=new ArrayList<PreparationMonth>();
		PreparationMonth34s.add(new PreparationMonth(1,true));
		PreparationMonth34s.add(new PreparationMonth(2,false));
		PreparationMonth34s.add(new PreparationMonth(3,true));
		PreparationMonth34s.add(new PreparationMonth(4,false));
		PreparationMonth34s.add(new PreparationMonth(5,false));
		PreparationMonth34s.add(new PreparationMonth(6,false));
		PreparationMonth34s.add(new PreparationMonth(7,false));
		PreparationMonth34s.add(new PreparationMonth(8,false));
		PreparationMonth34s.add(new PreparationMonth(9,false));
		PreparationMonth34s.add(new PreparationMonth(10,false));
		PreparationMonth34s.add(new PreparationMonth(11,true));
		PreparationMonth34s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon34.setAgeOfMom(34);
		mon34.setPreparationMonths(PreparationMonth34s);
		
		//init mon 35 age;
		PreparationBirthday mon35=new PreparationBirthday();
		//Preparation Month for mom 35 age
		List<PreparationMonth> PreparationMonth35s=new ArrayList<PreparationMonth>();
		PreparationMonth35s.add(new PreparationMonth(1,true));
		PreparationMonth35s.add(new PreparationMonth(2,false));
		PreparationMonth35s.add(new PreparationMonth(3,true));
		PreparationMonth35s.add(new PreparationMonth(4,false));
		PreparationMonth35s.add(new PreparationMonth(5,false));
		PreparationMonth35s.add(new PreparationMonth(6,false));
		PreparationMonth35s.add(new PreparationMonth(7,false));
		PreparationMonth35s.add(new PreparationMonth(8,false));
		PreparationMonth35s.add(new PreparationMonth(9,false));
		PreparationMonth35s.add(new PreparationMonth(10,false));
		PreparationMonth35s.add(new PreparationMonth(11,true));
		PreparationMonth35s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon35.setAgeOfMom(35);
		mon35.setPreparationMonths(PreparationMonth35s);
		
		//init mon 36 age;
		PreparationBirthday mon36=new PreparationBirthday();
		//Preparation Month for mom 36 age
		List<PreparationMonth> PreparationMonth36s=new ArrayList<PreparationMonth>();
		PreparationMonth36s.add(new PreparationMonth(1,false));
		PreparationMonth36s.add(new PreparationMonth(2,true));
		PreparationMonth36s.add(new PreparationMonth(3,true));
		PreparationMonth36s.add(new PreparationMonth(4,false));
		PreparationMonth36s.add(new PreparationMonth(5,true));
		PreparationMonth36s.add(new PreparationMonth(6,false));
		PreparationMonth36s.add(new PreparationMonth(7,false));
		PreparationMonth36s.add(new PreparationMonth(8,true));
		PreparationMonth36s.add(new PreparationMonth(9,false));
		PreparationMonth36s.add(new PreparationMonth(10,false));
		PreparationMonth36s.add(new PreparationMonth(11,true));
		PreparationMonth36s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon36.setAgeOfMom(36);
		mon36.setPreparationMonths(PreparationMonth36s);
		
		//init mon 37 age;
		PreparationBirthday mon37=new PreparationBirthday();
		//Preparation Month for mom 37 age
		List<PreparationMonth> PreparationMonth37s=new ArrayList<PreparationMonth>();
		PreparationMonth37s.add(new PreparationMonth(1,false));
		PreparationMonth37s.add(new PreparationMonth(2,true));
		PreparationMonth37s.add(new PreparationMonth(3,true));
		PreparationMonth37s.add(new PreparationMonth(4,false));
		PreparationMonth37s.add(new PreparationMonth(5,true));
		PreparationMonth37s.add(new PreparationMonth(6,false));
		PreparationMonth37s.add(new PreparationMonth(7,false));
		PreparationMonth37s.add(new PreparationMonth(8,true));
		PreparationMonth37s.add(new PreparationMonth(9,false));
		PreparationMonth37s.add(new PreparationMonth(10,false));
		PreparationMonth37s.add(new PreparationMonth(11,true));
		PreparationMonth37s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon37.setAgeOfMom(37);
		mon37.setPreparationMonths(PreparationMonth37s);
		
		//init mon 38 age;
		PreparationBirthday mon38=new PreparationBirthday();
		//Preparation Month for mom 38 age
		List<PreparationMonth> PreparationMonth38s=new ArrayList<PreparationMonth>();
		PreparationMonth38s.add(new PreparationMonth(1,false));
		PreparationMonth38s.add(new PreparationMonth(2,true));
		PreparationMonth38s.add(new PreparationMonth(3,false));
		PreparationMonth38s.add(new PreparationMonth(4,true));
		PreparationMonth38s.add(new PreparationMonth(5,true));
		PreparationMonth38s.add(new PreparationMonth(6,true));
		PreparationMonth38s.add(new PreparationMonth(7,true));
		PreparationMonth38s.add(new PreparationMonth(8,false));
		PreparationMonth38s.add(new PreparationMonth(9,true));
		PreparationMonth38s.add(new PreparationMonth(10,true));
		PreparationMonth38s.add(new PreparationMonth(11,true));
		PreparationMonth38s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon38.setAgeOfMom(38);
		mon38.setPreparationMonths(PreparationMonth38s);
		
		//init mon 39 age;
		PreparationBirthday mon39=new PreparationBirthday();
		//Preparation Month for mom 39 age
		List<PreparationMonth> PreparationMonth39s=new ArrayList<PreparationMonth>();
		PreparationMonth39s.add(new PreparationMonth(1,false));
		PreparationMonth39s.add(new PreparationMonth(2,true));
		PreparationMonth39s.add(new PreparationMonth(3,false));
		PreparationMonth39s.add(new PreparationMonth(4,true));
		PreparationMonth39s.add(new PreparationMonth(5,false));
		PreparationMonth39s.add(new PreparationMonth(6,true));
		PreparationMonth39s.add(new PreparationMonth(7,true));
		PreparationMonth39s.add(new PreparationMonth(8,false));
		PreparationMonth39s.add(new PreparationMonth(9,true));
		PreparationMonth39s.add(new PreparationMonth(10,true));
		PreparationMonth39s.add(new PreparationMonth(11,true));
		PreparationMonth39s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon39.setAgeOfMom(39);
		mon39.setPreparationMonths(PreparationMonth39s);
		
		//init mon 40 age;
		PreparationBirthday mon40=new PreparationBirthday();
		//Preparation Month for mom 40 age
		List<PreparationMonth> PreparationMonth40s=new ArrayList<PreparationMonth>();
		PreparationMonth40s.add(new PreparationMonth(1,false));
		PreparationMonth40s.add(new PreparationMonth(2,true));
		PreparationMonth40s.add(new PreparationMonth(3,false));
		PreparationMonth40s.add(new PreparationMonth(4,true));
		PreparationMonth40s.add(new PreparationMonth(5,false));
		PreparationMonth40s.add(new PreparationMonth(6,true));
		PreparationMonth40s.add(new PreparationMonth(7,true));
		PreparationMonth40s.add(new PreparationMonth(8,false));
		PreparationMonth40s.add(new PreparationMonth(9,true));
		PreparationMonth40s.add(new PreparationMonth(10,true));
		PreparationMonth40s.add(new PreparationMonth(11,true));
		PreparationMonth40s.add(new PreparationMonth(12,true));
		
		//set age of mom
		mon40.setAgeOfMom(40);
		mon40.setPreparationMonths(PreparationMonth40s);
		
		data =new ArrayList<PreparationBirthday>();
		data.add(mon18);
		data.add(mon19);
		data.add(mon20);
		data.add(mon21);
		data.add(mon22);
		data.add(mon23);
		data.add(mon24);
		data.add(mon25);
		data.add(mon26);
		data.add(mon27);
		data.add(mon28);
		data.add(mon29);
		data.add(mon30);
		data.add(mon31);
		data.add(mon32);
		data.add(mon33);
		data.add(mon34);
		data.add(mon35);
		data.add(mon36);
		data.add(mon37);
		data.add(mon38);
		data.add(mon39);
		data.add(mon40);
		data.add(mon30);
		
		
		return data;
	}
	
	private InitBabyInAgeOfMom getLunarAge(LocalDate preparedBirthday,LocalDate bithdayMom){
		preparedBirthday=subDateBy(preparedBirthday,0,9,15);
		int [] arrLunarDateInitBaby=LunarCalendarUtils.convertSolar2Lunar(preparedBirthday.getDayOfMonth(), preparedBirthday.getMonthValue(), preparedBirthday.getYear(), 7);
		LocalDate lunarDateInit = LocalDate.of(arrLunarDateInitBaby[2], arrLunarDateInitBaby[1], arrLunarDateInitBaby[0]);
		System.out.println("lunar year init baby: "+lunarDateInit.getYear()+" month: "+lunarDateInit.getMonthValue());
		
		//lunar age of mom
		int [] arrLunarDateOfMom=LunarCalendarUtils.convertSolar2Lunar(bithdayMom.getDayOfMonth(), bithdayMom.getMonthValue(), bithdayMom.getYear(), 7);
		LocalDate ageOfMom =  subDateBy(lunarDateInit,arrLunarDateOfMom[2],arrLunarDateOfMom[1],arrLunarDateOfMom[0]);
		System.out.println("lunar age of mom: "+ageOfMom.getYear());
		InitBabyInAgeOfMom entity=new InitBabyInAgeOfMom();
		entity.setAgeOfMom(ageOfMom.getYear());
		entity.setInitMonthBaby(lunarDateInit.getMonthValue());
		return entity;
	}
	
	
	private static LocalDate subDateBy(LocalDate date,int years,int months,int days){
		date=date.minusYears(years);
		date=date.minusMonths(months);
		date=date.minusDays(days);
		return date;
	}
	
	private int getAge(String year, String month, String day)
	{
		//set up date of birth
		Calendar calDOB = Calendar.getInstance();
		calDOB.set( Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day) );
		//setup calNow as today.
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(new java.util.Date());
		//calculate age in years.
		int ageYr = (calNow.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR));
		// calculate additional age in months, possibly adjust years.
		int ageMo = (calNow.get(Calendar.MONTH) - calDOB.get(Calendar.MONTH));
		if (ageMo < 0)
		{
		//adjust years by subtracting one
		ageYr--;
		}
		return ageYr;
	}
}
