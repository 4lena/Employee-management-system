import java.util.*;
public class TestEmployee{
   static Scanner input=new Scanner(System.in);
   static Employee[] hiringEmployees =new Employee[100]; // global to be accessible to all parts of the progeam
   static int counter; // to count hiringEmployees
     
   public static void main(String[]args){
   
      counter=10;
      //Fill-in the array with the 10 employees
      hiringEmployees[0] =new Employee( "9876543222" , "Driver" , "15/12/2020" , "16:00" ,"22:00" ,true, 1) ;
      hiringEmployees[1] =new Employee( "9876543211" , "Cleaning Worker" , "15/12/2020" , "08:00" ,"22:00" ,true, 4) ;
      hiringEmployees[2] =new Employee( "1234567899" , "Cleaning Worker" , "N/A" , "N/A" ,"N/A" ,false, 0) ;
      hiringEmployees[3] =new Employee( "2234567891" , "Cleaning Worker" , "17/12/2020" , "08:00" ,"13:00" ,true, 2) ;
      hiringEmployees[4] =new Employee( "1334567892" , "Driver" , "11/12/2020" , "10:00" ,"15:00" ,true, 1) ;
      hiringEmployees[5] =new Employee("4412356789" , "Cleaning Worker" ,"05/12/2020" ,"12:00" ,"16:00" ,true, 10) ;
      hiringEmployees[6] =new Employee("3114567894" , "Driver", "N/A", "N/A", "N/A", false, 2) ;
      hiringEmployees[7] =new Employee("8876543221" , "Driver", "19/12/2020" , "08:00", "14:00", true, 1) ;
      hiringEmployees[8] =new Employee("7776543267" , "Cleaning Worker" , "N/A" , "N/A", "N/A", false, 3) ;
      hiringEmployees[9] =new Employee("1176543266" , "Cleaning Worker", "02/12/2020","17:00", "21:00", true, 12) ;
      
       //3.maximumFrequency
      System.out.println("the employee who has the maximum frequency (9876543211 or 1234567899) is:");      
      String idOfHigherFrequency=maximumFrequency( hiringEmployees[1],hiringEmployees[2]);//callmethod
      if(idOfHigherFrequency.equals("9876543211") || idOfHigherFrequency.equals("1234567899"))
         System.out.printf("Employee with the id number: (%s) can take a break during the weekend%n",idOfHigherFrequency);
      else
         System.out.printf("Employees have different job titles %n");
      System.out.println();
            
      //4.employee worked for less duration
      System.out.println("The employee who worked for less duration (9876543222 or 9876543211) is:"); 
            
      String idLessDuration=minimumDuration(hiringEmployees[0] , hiringEmployees[1] );//callmethod
      if(idLessDuration.equals("9876543222") || idLessDuration.equals("9876543211"))
         System.out.printf("Employee with the id number:(%s) worked less on(%s)%n",idLessDuration ,hiringEmployees[0].getContractDate());
      else
         System.out.printf("Dates are Mismatched %n");
      System.out.println();
                
      //5.maximumFrequency
      System.out.println("The employee who has the maximum frequency (9876543211 or 9876543222) is:");
            
      idOfHigherFrequency=maximumFrequency( hiringEmployees[1],hiringEmployees[0]);
      if(idOfHigherFrequency.equals("9876543211") || idOfHigherFrequency.equals("9876543222") )
         System.out.printf("Employee with the id number: (%s) can take a break during the weekend%n" ,idOfHigherFrequency);
      else
         System.out.printf("Employees have different job titles %n");
      System.out.println();
                
      //6.employee worked for less duration
      System.out.println("The employee who worked for less duration (9876543211 or 2234567891) is:"); 
            
      idLessDuration=minimumDuration(hiringEmployees[1] , hiringEmployees[3] );
      if(idLessDuration.equals("9876543211") || idLessDuration.equals("2234567891") )
         System.out.printf("Employee with the id number:(%s) worked less on(%d)%n",idLessDuration ,hiringEmployees[1].getContractDate());
      else
         System.out.printf("Dates are Mismatched%n");
      System.out.println();
   
    //Menue
      int choice ; 
      do
      {
         System.out.println("Enter your choice : " ) ; 
         System.out.println("1. Add a new employee" ) ;
         System.out.println("2. Start a hiring contract" ) ;
         System.out.println("3. End a hiring contract" ) ;
         System.out.println("4. Display employee info" ) ;
         System.out.println("5. Display HRS system status" ) ;
         System.out.println("6. Exit" ) ;
         choice = input.nextInt(); 
         
         switch( choice )
         {
         case 1 :  // 1. Add a new employee: NOTE: We make sure that the information entered from the user is correct to store it correctly.

            if(counter == hiringEmployees.length){   //When the array is full 
               System.out.println("The list is full, No new employee can be added."); 
               break;} // then go back to menu
               
            String employeeId;
            boolean notNum;
            
            //Read the employee’s (id) from the user. the follwing code will check that its a 10 digits. 
            do{
              System.out.println("Enter id "); 
              employeeId = input.next();
              notNum=false;
              if(employeeId.length() == 10){
               for(int i = 0 ; i<10 ; i++){
                  char num = employeeId.charAt(i);
                  if (!(Character.isDigit(num))){
                     System.out.println("Only digits is acceptable!.");
                     notNum = true;
                     break;
                  }
                }    
               }
               else
                  System.out.println("Invalid input, the ID must consist of 10 digits only.");
              }while(employeeId.length()!=10||notNum);
           
            int  idFound = findId(employeeId); //validate that it does not already exist in the array
               
            if(idFound !=-1)
            {
               System.out.println("The Id is already exists."); 
               break; // then go back to menu
            } 

           input.nextLine();       
           boolean checkjobtitle = false;
           String job;
            
           // read from the user: the job title. The following code will ensure that the job name is valid (Driver, Cleaning Worker)   
            do{
               System.out.println("Enter Job"); 
               job = input.nextLine();
                 
               if((job.equalsIgnoreCase("Driver"))||(job.equalsIgnoreCase("Cleaning Worker")))
                  checkjobtitle = false;
               else{
                  System.out.println("invalid input , renter the job(driver , clening worker) ");
                  checkjobtitle = true;
                  }         
              }while(checkjobtitle);
 
            hiringEmployees[counter] =new Employee(employeeId ,job ,"N/A","N/A","N/A",false,0);
            counter++; //To go to the next location for the next employee.
            
            System.out.println("The employee has been added successfully.");
            System.out.println(); 
            break; 

         case 2: //2. Start a hiring contract:
            //read the employee ID
            System.out.print("Enter The Employee's ID: ");
            employeeId = input.next();
            
            //check if the id exist
            idFound = findId(employeeId);
           
            if(idFound == -1) //if the id is not exist
            {
               System.out.println("Sorry, The Employee's ID Is Not Found!");
               System.out.println(); 
               break; //break from the switch
            }
             
            if(hiringEmployees[idFound].getHired() == true) //if the employee is hired
            {
              System.out.println("Sorry, The Employee's Is Already Hired!");
              System.out.println(); 
              break; //break from the switch
            }
            
            System.out.println("Enter Contract Data Please Format: (dd/mm/yyyy)");
            hiringEmployees[idFound].setContractDate(input.next()); //read the Contract Data
            System.out.println("Enter Contract's Start Time By Using 24-hours Notation Please Format: (HH:00)");
            hiringEmployees[idFound].setStartTime(input.next()); //read the Contract's Start Time
            System.out.println("Enter Contract's End Time By Using 24-hours Notation Please Format: (HH:00)");
            hiringEmployees[idFound].setEndTime(input.next());//read the Contract's End Time
            hiringEmployees[idFound].setHired(true); //set hired to true
            hiringEmployees[idFound].updateFrequency(); //update the frequency
              
            System.out.println("------------Employee's Information------------");
            //display the employee's information
            hiringEmployees[idFound].displayInfo();
            System.out.println(); 
 
           break;
           
         case 3: //3. End a hiring contract:            
            System.out.print("Enter The Employee's ID: ");
            employeeId = input.next(); //read the employee id
            idFound = findId(employeeId);
            
            //check if the id exist 
            if(idFound == -1)
            //if the id is not exist
            {
               System.out.println("Sorry,The Employee's ID Is Not Found!");
               System.out.println();
               break; //break from the switch
            }
          
            if(hiringEmployees[idFound].getHired() == false)
            //if the employee is not hired
            {
               System.out.println("Sorry, The Employee's Is Not Hired!");
               System.out.println();
               break; //break from the switch 
            }
            
            System.out.println("The Employee's Duration: " + hiringEmployees[idFound].calculateDuration()); //print the employee duratuon.
            System.out.println("------------Employee's Information------------");
            hiringEmployees[idFound].displayInfo();//disaplay the employee information
            System.out.println();
             
            //reset the employee informatin to make him/her available
            hiringEmployees[idFound].setContractDate("N/A");
            hiringEmployees[idFound].setStartTime("N/A");
            hiringEmployees[idFound].setEndTime("N/A");
            hiringEmployees[idFound].setHired(false);
            break; //break from switch
            
            
         case 4: //4. Display an employee’s info: 
            System.out.print("Enter The Employee's ID: ");
            employeeId = input.next();
            //read the employee id
            idFound = findId(employeeId); //check if the id exist
           
            
            if(idFound == -1) //if the id is not exist
            {
               System.out.println("Sorry, The Employee's ID Is Not Found!");
               System.out.println();
               break; //break from the switch
            }
          
            System.out.println("------------Employee's Information------------");
            hiringEmployees[idFound].displayInfo();
            //display the employee information
            System.out.println();
            break; //break from the switch
          
         case 5: //5. Display HRS system status: 
            int hiredNum = 0;
            int availableNum = 0;
            int highest = 0;
             
            for(int i=0; i<counter; i++) //count the number of hired employees and the available employees
               if(hiringEmployees[i].getHired() == true)
                  hiredNum++;
               else
                  availableNum++;
              
            for(int i=1; i<counter; i++) //find the highest frequency
               if(hiringEmployees[highest].getFrequency()<hiringEmployees[i].getFrequency())
                  highest = i;
                 
            System.out.println("The Total Number Of Employees Who Are Currently Registered In The System: \n" + counter);
            //print the Total Number Of Registered Currently Employees
            System.out.println("The Current Number Of Hired Employees: \n" + hiredNum);
            //print the number of hired employees
            System.out.println("The Number Of Available Employees: \n" + availableNum);
            //print the number of available
            System.out.println("The id of the employee with the highest hiring frequency in the system: ");
             
            for(int i=0; i<counter; i++) //print employee/s with the highest frequency 
              if(hiringEmployees[i].getFrequency()==hiringEmployees[highest].getFrequency())
               System.out.print(hiringEmployees[i].getId()+" ");           
            System.out.println();
             
            System.out.println("\n------------The Employees' Informations------------");
            System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|\n", "ID", "Job", "Date", "sTime", "eTime", "Hire", "Frequency" );
 
            for(int i=0; i<counter; i++)
               hiringEmployees[i].displayInfo();
            //print the employees' information
              
            System.out.println(); 
            break; //break from the switch
  
         case 6: // 6. Exit:
            String choice2;
            do{
               System.out.print("All info. will be lost. Are you sure you want to exit? (Yes/No) ");
               choice2 = input.next(); //read from the user
    
               if(choice2.equalsIgnoreCase("yes")){
                  System.out.print("GoodBye");
                  break;//break from the loop
               }
   
               else if(choice2.equalsIgnoreCase("no")){
                  choice = 0;
                  break;//break from the loop
               }
   
               else
                 System.out.println("only (yes/no) is accepted!");  
            }while(!(choice2.equalsIgnoreCase("no"))||!(choice2.equalsIgnoreCase("yes")));
             
            break; //break from switch
           
          default : 
            System.out.println("Invalid selection!"); 
                  
          }// end switch
               
      }while( choice != 6 ) ; 
         
   }//endmain
         
   //start main method
   public static String maximumFrequency(Employee one , Employee two)
   {
      if(one.getJobTitle().equalsIgnoreCase(two.getJobTitle()) ) //condtion:employees should have the same job title
         if(one.getFrequency() >two.getFrequency()) //callmethod to compare which employee who has the higher frequency
            return one.getId();

         else
            return two.getId();    
      return "-1";
   }
         
   public static String minimumDuration(Employee one, Employee two)
   {
      if(one.getContractDate().equals(two.getContractDate()) ) //conditon:employees should have the same contract date
         if(one.calculateDuration()<two.calculateDuration()) //callmethod to compare which employee who has working less hour
            return one.getId();

         else
            return two.getId();   
      return "Dates are Mismatched";
   }

   // validate existivity of the ID in the array    
   public static int findId(String id )
   {
      for(int i = 0 ; i < counter ; i++)
         if( hiringEmployees[i].getId().equals( id ) ) 
            return i ;               
      return -1 ;
   }
  
}//endclass