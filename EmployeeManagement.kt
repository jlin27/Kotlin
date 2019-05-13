abstract class BaseEmployee(val name:String, val id:Int)
{
    
    // Non-abstract function
    fun displayName() {
        println("Employee name is: $name")
    }
    
    // Non-abstract function
    fun displayID() {
        println("Employee ID is: $id")
    }
    
    // Abstract function (must be implemented by subclasses)
    abstract fun calculateSalary(hoursWorked: Int)
    
}


class FullTimeEmployee(name:String, id:Int): BaseEmployee(name, id)
{
	override fun calculateSalary(hoursWorked:Int)
	{
		val salary =  hoursWorked * 60 + 4000
		println("Full-Time Employee salary is: $$salary")
	}
}

class ContractEmployee(name:String, id:Int): BaseEmployee(name, id)
{
	override fun calculateSalary(hoursWorked:Int)
	{
		val salary =  hoursWorked * 65
		println("Contract Employee salary is: $$salary")
	}
}


fun main(args: Array<String>){
	val fullTimeEmployee = FullTimeEmployee("Tom",1)
	fullTimeEmployee.displayName()
	fullTimeEmployee.displayID()
	fullTimeEmployee.calculateSalary(10)


	val contractEmployee = ContractEmployee("Bob",2)
	contractEmployee.displayName()
	contractEmployee.displayID()
	contractEmployee.calculateSalary(10)
}