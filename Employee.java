   public class Employee{
       //--------------------------------attributes:--------------------------------
      private String id ; // represents the Residence Permit Identification number of the employee.
      private String jobTitle ; // represents the job title: (cleaning worker, or driver).
      private String contractDate ; // represents the contract�s date (Format dd/mm/yyyy)
      private String startTime ; // represents the contract�s start time (Format HH:00) using 24-hours notation.
      private String endTime ; // represents the contract�s end time (Format HH:00) using 24-hours notation.
      private boolean hired ; //  true if the employee is currently hired, or false otherwise
      private int frequency ; // represents the number of times the employee was hired (number of completed contracts).
      
   public Employee(String id , String jobTitle , String contractDate , String startTime , String endTime , boolean hired , int frequency)
     {
         this.id = id;
         this.jobTitle = jobTitle ;  
         this.contractDate = contractDate ; 
         this.startTime = startTime; 
         this.endTime = endTime ; 
         this.hired = hired ; 
         this.frequency = frequency ; 
      }  
      //--------------------------------Methods:--------------------------------
      
      
      // The following meethod will computes and returns the total duration (in hours) of the current hiring contract.
      public int calculateDuration(){
      // Rememper that the start and end time in this format >> (HH:00).
         int locSH = startTime.indexOf(':');
         int locEH = endTime.indexOf(':');
         
         int startHour = Integer.parseInt(startTime.substring(0,locSH));
         int endHour = Integer.parseInt(endTime.substring(0,locEH));
         
         int totalDuration = endHour - startHour; 
         
         // the duration in hours, so If the period is less than an hour We will calculate it as one hour only. as showing below:
         if(totalDuration == 0) 
            totalDuration = 1; 
         
         return totalDuration ;  
      }
    
      //  the following method will increment the current hiring frequency by one.
      public void updateFrequency(){
         frequency++ ;
      }
      
      //  the following method wil displays the employee info on one line with the a specific format.
      public void displayInfo(){
      /* o id: left aligned, with width: 12
         o jobTitle: right aligned, with width: 15
         o contractDate: right aligned, with width: 10
         o startTime: right aligned, with width: 6
         o endTime: right aligned, with width: 6
         o hired: left aligned, with width: 4 #REMEMPER that hired is a boolean so it will return true if the employee is currently hired, or false otherwise.
         o frequency: left aligned, with width: 4
         o the line starts and ends with �|� and each item is separated by �|�
     */
         System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4d|%n",id ,jobTitle ,contractDate ,startTime ,endTime ,(hired ?"yes" : "no")  ,frequency); 
      }
      
      //--------------------------------Add setters and getters as needed--------------------------------
      
      public String getId(){
         return id ; 
      }
      
      public String getJobTitle(){
         return jobTitle;
      }
      
      public String getContractDate(){
         return contractDate;
      }
      
      public String getStartTime(){
         return startTime;
      }
      
      public String getEndTime(){
         return endTime;
      }
      
      public boolean getHired(){
         return hired;
      }
      
      public int getFrequency(){
         return frequency;
      }
      
      public void setId(String id){
         this.id = id;
      }
      
      public void setJobTitle(String jobTitle){
         this.jobTitle = jobTitle;
      }
      
      public void setContractDate(String contractDate){
         this.contractDate = contractDate;
      }
      
      public void setStartTime(String startTime){
         this.startTime = startTime;
      }
      
      public void setEndTime(String endTime){
         this.endTime = endTime;
      }
      
      public void setHired(boolean hired){
         this.hired = hired;
      }
      
      public void setFrequency(int frequency){
         this.frequency = frequency;
      }
   } 