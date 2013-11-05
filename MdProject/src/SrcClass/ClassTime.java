package SrcClass;

public class ClassTime {
	int ClassNumber = 0;
	int[][] ClassList = {{747,1,3,10,5,11,20},{513,1,3,9,5,10,20},{520,1,3,8,5,9,20},{522,2,4,8,5,9,20},{822,2,4,9,5,10,20},{791,1,3,10,5,11,20}};
	public ClassTime(int ClassNumber){
		this.ClassNumber = ClassNumber;
	}
	
	//Get the days of each week
	public int[] GetDay(){
		int[] days = new int[2];
		for(int i=0;i<ClassList.length;i++){
			for(int j=0;j<ClassList[i].length;j++){
				if(ClassList[i][0] == ClassNumber){
					for(int k=0;k<days.length;k++){
						days[k] = ClassList[i][k+1];
					}
				}
			}
		}
		return days;
	}
	
	//Get the time of each day
	public int[] GetTime(){
		int[] times = new int[4];
		for(int i=0;i<ClassList.length;i++){
			for(int j=0;j<ClassList[i].length;j++){
				if(ClassList[i][0] == ClassNumber){
					for(int m=0;m<times.length;m++){
						times[m] = ClassList[i][m+3];
					}
				}
			}
		}
		return times;
	}
	
	//Get the start time
	public int[] getStartTime(){
		int[] times = new int[4];
		int[] startTime = new int[2];
		for(int i=0;i<ClassList.length;i++){
			for(int j=0;j<ClassList[i].length;j++){
				if(ClassList[i][0] == ClassNumber){
					for(int m=0;m<times.length;m++){
						times[m] = ClassList[i][m+3];
					}
				}
			}
		}
		for(int i=0;i<times.length;i++){
			if(i==0||i==1){
				startTime[i] = times[i];
			}
		}
		return startTime;
	}
	
	//Get the end time
	public int[] getStopTime(){
		int[] times = new int[4];
		int[] stopTime = new int[2];
		for(int i=0;i<ClassList.length;i++){
			for(int j=0;j<ClassList[i].length;j++){
				if(ClassList[i][0] == ClassNumber){
					for(int m=0;m<times.length;m++){
						times[m] = ClassList[i][m+3];
					}
				}
			}
		}
		for(int i=0;i<times.length;i++){
			 if(i==2||i==3){
				stopTime[i-2] = times[i];
			}
		}
		return stopTime;
	}
	
	public static void NumberToString(int[] NumberDate){
		String[] StringDate = new String[2];

		for(int i=0;i<NumberDate.length;i++){
			if(NumberDate[i]==0){
				System.out.println("Invalid Input!");
				break;
			}
			else{
				StringDate[i] = NumberSwtichString(NumberDate[i]);
				System.out.print(StringDate[i]+" ");
			}
		}
		System.out.println();

	}
	
	public static String NumberSwtichString(int i){
		String date = "";
		switch(i){
		case 1: date = "Monday";
				break;
		case 2: date = "Tuesday";
				break;
		case 3: date = "Wednesday";
				break;
		case 4: date = "Thursday";
				break;
		case 5: date = "Friday";
				break;
		default: date = "Null";
				 break;
		}
		return date;
	}
	
	public static String GetTimeOfDay(int[] times){
		int key = 1;
		String outPutString = "";
		String[] timeString= new String[times.length];
		for(int i=0;i<times.length;i++){
			if((times[i]<10)&&times[i]!=0){
				timeString[i] = "0"+times[i];
			}else if(times[i]>9){
				timeString[i] = times[i]+"";
			}else{
				key = 0;
				break;
			}
		}
		if(key==1){
			outPutString = "Start Time:"+ timeString[0]+":"+timeString[1]+" ;"+"Stop Time:"+timeString[2]+":"+timeString[3];
			System.out.println(outPutString);
		}
		return outPutString;
	}
	
	// Duration 
	public static int GetDuration(int[] startTime, int[] stopTime){
		
		int duration = 0;
		int[] newST = new int[stopTime.length];
		for(int i=0;i<startTime.length;i++){
			for(int j=0;j<stopTime.length;j++){
				if((i==j)&&(i==1)){
					if(stopTime[j]<startTime[i]){
						newST[j] = stopTime[j]+60;
						newST[j-1] = stopTime[j-1]-1;
					}
				}else{
					newST[j] = stopTime[j];
				}
			}
		}
		for(int i=0;i<newST.length;i++){
			if(i==0){
				duration = (newST[i] - startTime[i])*60;
			}else{
				duration += newST[i] - startTime[i];
			}
		}
		return duration;
	}
	
	//overlap method
	public static boolean OverLap(int class1, int class2){
		boolean result = false;
		ClassTime ct1 = new ClassTime(class1);
		ClassTime ct2 = new ClassTime(class2);
		int[] class1day = ct1.GetDay();
		int[] class2day = ct2.GetDay();
		int[] class1ST = ct1.getStartTime();
		int[] class2ST = ct2.getStartTime();
		int[] class1ET = ct1.getStopTime();
		int[] class2ET = ct2.getStopTime();
		int count=0;
		for(int i=0;i<class1day.length;i++){
			for(int j=0;j<class2day.length;j++){
				if(class1day[i]==class2day[j]){
					count++;
				}
			}
		}
		
		if(count!=0){
			if(GetDuration(class1ST,class2ST)>0){
				if(GetDuration(class1ST,class2ST)<GetDuration(class1ST,class1ET)){
					result = true;
					count = 0;
					System.out.println(result);
					return result;
				}
			}else if(GetDuration(class1ST,class2ST)<0){
				if(GetDuration(class2ST,class1ST)<GetDuration(class2ST,class2ET)){
					result = true;
					count = 0;
					System.out.println(result);
					return result;
				}
			}else{
				result = true;
				count = 0;
				System.out.println(result);
				return result;
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[]args){
		/*int class1 = 520;
		int class2 = 747;
		
		if(OverLap(class1,class2)){
			System.out.println("Time conflict!");
			ClassTime ct1 = new ClassTime(class1);
			int[] st1 = ct1.getStartTime();
			int[] et1 = ct1.getStopTime();
			int[] times1 = ct1.GetTime();
			int[] days1 = ct1.GetDay();
			NumberToString(days1);
			GetTimeOfDay(times1);
			System.out.println(GetDuration(st1, et1));
			
			ClassTime ct2 = new ClassTime(class2);
			int[] st2 = ct2.getStartTime();
			int[] et2 = ct2.getStopTime();
			int[] times2 = ct2.GetTime();
			int[] days2 = ct2.GetDay();
			NumberToString(days2);
			GetTimeOfDay(times2);
			System.out.println(GetDuration(st2, et2));
		}else{
			ClassTime ct1 = new ClassTime(class1);
			int[] st1 = ct1.getStartTime();
			int[] et1 = ct1.getStopTime();
			int[] times1 = ct1.GetTime();
			int[] days1 = ct1.GetDay();
			NumberToString(days1);
			GetTimeOfDay(times1);
			System.out.println(GetDuration(st1, et1));
			
			ClassTime ct2 = new ClassTime(class2);
			int[] st2 = ct2.getStartTime();
			int[] et2 = ct2.getStopTime();
			int[] times2 = ct2.GetTime();
			int[] days2 = ct2.GetDay();
			NumberToString(days2);
			GetTimeOfDay(times2);
			System.out.println(GetDuration(st2, et2));
		}*/
	}
}