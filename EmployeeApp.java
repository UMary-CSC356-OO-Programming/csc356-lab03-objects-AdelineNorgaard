import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	private String firstName;
	private String lastName;
	private int employeeId;
	private double salary;
   
	/* Task 3C: Add three constructors */
	
	//first constructor: initialize the four instance variables
	public Employee()
	{
		firstName = " ";
		lastName = " ";
		employeeId = 0;
		salary = 0;
	}
	
	//second contructor: set first and last name + initialize other two 
	public Employee(String last, String first)
	{
		lastName = last;
		firstName = first;
		employeeId = 0;
		salary = 0; 
	}
	
	//third constructor: set the instance variables
	public Employee(String last, String first, int id, double wage)
	{
		lastName = last;
		firstName = first;
		employeeId = id;
		salary = wage;
	}
	
	/* Task 3D: Add set (mutator) and get (accessor) meethods */
	//set methods
	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}
	
	public void setLastName(String newLastName)
	{
		firstName = newLastName;
	}
	
	public void setEmployeeId(int newEmployeeId)
	{
		employeeId = newEmployeeId;
	}
	
	public void setSalary(double newSalary)
	{
		salary = newSalary;
	}
	
	//get methods
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public int getEmployeeID()
	{
		return employeeId;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	
	/* Task 3F: Add toString method */
	public String toString()
	{
		return (this.lastName + ", " + this.firstName + "\n  ID Number: " + this.employeeId + "\n  Salary   : $" + this.salary);
	}
	/* Task 3G: Add equals method */
	
	public Boolean equals(String name)
	{
		//System.out.println(name);
		//System.out.println(this.lastName);
		//String lastTEST = this.lastName;
		
		if (name == this.lastName)
		{
			return true;
		}
		return false;
	}
	

}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						
						System.out.println( "Enter employee last name: " );
						String newLastName = keyboard.nextLine();
						//Employee.setLastName(newLastName);
						
						System.out.println( "Enter employee first name: " );
						String newFirstName= keyboard.nextLine();
						//Employee.setFirstName(newFirstName);
						
						System.out.println( "Enter employee ID: " );
						int newEmployeeId = keyboard.nextInt();
						//Employee.setEmployeeId(newEmployeeId);
						
						System.out.println( "Enter employee salary: " );
						double newSalary = keyboard.nextDouble();
						//Employee.setSalary(newSalary);
						
						
						// Create object for new Employee
						employees[empCount] = new Employee(newLastName, newFirstName, newEmployeeId, newSalary);
						
						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{							
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}