/* A complete software which can store data(name,salary,no of leave left) of 100 permanent and 100 temporary employee. for the very first time u 
   have to register to this software by entering your name,Employye type,year of employee.then u will be given a registration no.u can manage your
   data...u can allocate leave and check your remaining leave and salary whenever you need it*/
import java.util.*;
abstract class Employee{
      int empld;//employee duration
      String empName;//employee name
      int total_leave;
      double total_salary;

        public void calculate_balance_leaves(){

        }

            public boolean avail_leave(int no_of_leave,char type_of_leave){
              return(true);
            }
          
                public void calculate_salary(){
                      
                      
                }  

}

class PermanentEmp extends Employee{//class PermanentEmp extends the parent class Employee
      Scanner sc=new Scanner(System.in);
      int paid_leave,sick_leave,casual_leave;
      double basic,hra,pfa;
         public PermanentEmp(String name,int dur){//contructor of class permanentEmp which initializes the variable
          
            empld=dur;//dur is year of employee duration
            empName=name;
            total_leave=60;
             total_salary=(dur * 10000);
            paid_leave=20;sick_leave=20;casual_leave=20;
         }
         void print_leave_detail(){//prints leave detais of permanent employee
                   System.out.println(empName+" your remaining leave is\n "+"paid_leave="+paid_leave+" sick_leave="+sick_leave+
                                       " casual leave="+casual_leave);
         }

             public void calculate_balance_leaves(){//overrides same method of parent class
                    System.out.println("Enter your category(P/S/C)  P.paid leave  S.sick leave C.casual leave");
                      
                     char choice=sc.next().charAt(0);//takes P or S or C as input
                     System.out.println("Enter no of days of leave");
                     int no=sc.nextInt();
                     if(avail_leave(no,choice)){
                             if(choice== 'P'){//user select paid leave
                                   paid_leave=paid_leave-no;
                                   System.out.println("Leave alloted sucessfully");
                             }

                               else if(choice== 'S'){//user select sick leave
                                   sick_leave=sick_leave-no;
                                   System.out.println("Leave alloted sucessfully");
                                }
           
                                   else if(choice== 'C'){//user select casual leave
                                       casual_leave=casual_leave-no;
                                       System.out.println("Leave alloted sucessfully");
                                   }                         
                     }
                      
                         else{
                               System.out.println("leave not alloted because of less or no due leave");   
                         }
         
             }

                public boolean avail_leave(int no_of_leave,char type_of_leave){//overrides same method of parent class.return true if leave available 
                       if(type_of_leave== 'P'){
                                   if(no_of_leave<=paid_leave)
                                       return(true);
                                   else
                                       return(false);  
                             }

                                if(type_of_leave== 'S'){
                                     if(no_of_leave<=sick_leave)
                                         return(true);
                                     else
                                         return(false);  
                                }
           
                                   else if(type_of_leave== 'C'){
                                          if(no_of_leave<=casual_leave)
                                             return(true);
                                          else
                                             return(false);  
                                   } 
                         return(false); 
                }
          
                   public void calculate_salary(){//calcualte total salary of permanentEmp and overrides same method of parent class
                         double basic=(10000 * empld);
                         total_salary= basic +( 0.5 * basic) -(12/100 * basic);
                         System.out.println(empName+" ,your total salary is Rs:"+total_salary);
                   }               

}

class TemporaryEmp extends Employee{//class TemperoryEmp extends the parent class Employee
       Scanner sc=new Scanner(System.in);
      public TemporaryEmp(String name,int dur){//constructor which initalizes the variable
           
            empld=dur;
             empName=name;
            total_leave=60;
             total_salary=(dur *8000);
      }

      public void calculate_balance_leaves(){//overrides method calculate_balance_leaves() of parent class
            System.out.println("Enter no of leave");
            int no=sc.nextInt();
            if(avail_leave(no,'a')){
                   total_leave=total_leave-no;
                   System.out.println("leave alloted successfully");
            }
              
               else{
                    System.out.println("leave not alloted because of less or no due leave");
               }
      }

            public boolean avail_leave(int no_of_leave,char type_of_leave){//overrides method avail_leave of parent class
                     if(total_leave>= no_of_leave)
                             return(true);
                     else
                             return(false);
            }
          
                public void calculate_salary(){//overrides method calculate_salary() of parent class
                       total_salary=(empld *8000);
                         System.out.println(empName+" ,your total salary is Rs:"+total_salary);
                }  
}

public class Session5c{

      public static void main(String []args){
          int choice,i=-1,j=-1;
          TemporaryEmp tE[]=new TemporaryEmp[100];//array declaration of object of TemperoryEmp class
          PermanentEmp pE[]=new PermanentEmp[100];//array declaration of object of PermanentEmp class
          while(true){
                System.out.println("Enter your category.  1.Unreeg.Permanent Employee   2.Unreg.Temporary Employee  3.Registered employee  4.Exit");
                Scanner sc=new Scanner(System.in);
                choice=sc.nextInt();
               
                if(choice==1){//Unreeg.Permanent Employee
                         System.out.println("Enter your name and Employee duration");
                         String name=sc.next();
                         int dur=sc.nextInt();
                         pE[++i]=new PermanentEmp(name,dur);
                         System.out.println("your registration number is "+i);
                 }
     
                    else if(choice==2){//Unreg.Temporary Employee 
                         System.out.println("Enter your name and Employee duration");
                         String name=sc.next();
                         int dur=sc.nextInt();
                         tE[++j]=new TemporaryEmp(name,dur);
                          System.out.println("your registration number is "+j);
                     }
       
                         
                       else if(choice==3){//Registered employee
                            
                            System.out.println("Enter your category.  1.Permanent Employee   2.Temporary Employee");
                            choice=sc.nextInt();
                            if(choice==1){//permanent Emplyee
                                 System.out.println("Enter your registration number");
                                 int sNo=sc.nextInt();
                                 System.out.println("Enter your category.  1.view leave and salary detail    2.need leave");
                                 choice=sc.nextInt();
                                 if(choice==1){//view leave and salary detail
                                   pE[sNo].print_leave_detail();
                                   pE[sNo].calculate_salary();
                                 }
 
                                    else{//need leave
                                        pE[sNo].calculate_balance_leaves();
                                    }
                            }

                               else if(choice==2){//.Temporary Employee
                                    System.out.println("Enter your registration number");
                                    int sNo=sc.nextInt();
                                    System.out.println("Enter your category.  1.view leave and salary detail    2.need leave");
                                    choice=sc.nextInt();
                                    if(choice==1){//view leave and salary detail
                                         tE[sNo].calculate_salary();
                                        System.out.println("total leave is "+tE[sNo].total_leave);
                                       
                                 }
 
                                    else{//need leave
                                        tE[sNo].calculate_balance_leaves();
                                    }
                            }
                        }
                     
                          else if(choice==4)//exit
                                System.exit(0);  
        

          }
     
      }
}
