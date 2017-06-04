
public class Loan {
	
	public static final double ELEG_PERC = .25;	
	
  private double salaryAndWages; 
  private double interestIncome; 
  private double investmentIncome; 
  private double otherIncome; 
  private double totalIncome; 
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private double monthlyInterestRate; 
  private int termInMonths;
  //private String elegibility; 
  //private double periodicPayment; 
  //private java.util.Date loanDate;
 
 /** Default constructor */
  public Loan() {
  this(2.5, 1, 1000, 0.0, 0.0, 0.0, 0.0);
 }

 public Loan(double annualInterestRate, int numberOfYears,
 double loanAmount, double salaryAndWages, double interestIncome, double investmentIncome, double otherIncome) {
 this.annualInterestRate = annualInterestRate/100;
 this.numberOfYears = numberOfYears;
 this.loanAmount = loanAmount;
 this.salaryAndWages = salaryAndWages; 
 this.interestIncome = interestIncome; 
 this.investmentIncome = investmentIncome;
 this.otherIncome = otherIncome; 
 //this.periodicPayment = periodicPayment; 
 //this.elegibility = elegibility; 
 //loanDate = new java.util.Date();
 }

 //return salary and wages
 public double getSalaryAndWages(){
   return salaryAndWages; 
 }
 
 //setSalaryAndWages
 public void setSalaryAndWages(double salaryAndWages) {
   this.salaryAndWages = salaryAndWages; 
   }
 
 
 //return interstIncome
 public double getInterestIncome(){
   return interestIncome; 
 }
 
 //setInterestIncome
 public void setInterestIncome(double interestIncome) {
   this.interestIncome = interestIncome; 
 }
 
  //return interstIncome
 public double getInvestmentIncome(){
   return investmentIncome; 
 }
 
 //setInvestmentIncome
 public void setInvestmentIncome(double investmentIncome) {
   this.investmentIncome = investmentIncome; 
 }
 
  //return otherIncome
 public double getOtherIncome(){
   return otherIncome; 
 }
 
 //setOtherIncome
 public void setOtherIncome(double otherIncome) {
   this.otherIncome = otherIncome; 
 }
 
  //return totalIncome
 public double gettotalIncome(){
   return totalIncome; 
 }
 
 //setTotalIncome
 public double getTotalIncome(){
   double totalIncome = getSalaryAndWages()+ getInterestIncome() + getInvestmentIncome() + getOtherIncome();
   return totalIncome; 
 }
 
 /** Return annualInterestRate */
 public double getAnnualInterestRate() {
 return annualInterestRate;
 }

 /** Set a new annualInterestRate */
 public void setAnnualInterestRate(double annualInterestRate) {
 this.annualInterestRate = annualInterestRate;
 }

 /** Return numberOfYears */
 public int getNumberOfYears() {
 return numberOfYears;
 }

 /** Set a new numberOfYears */
 public void setNumberOfYears(int numberOfYears) {
 this.numberOfYears = numberOfYears;
 }

 /** Return loanAmount */
 public double getLoanAmount() {
 return loanAmount;
 }

 /** Set a new loanAmount */
 public void setLoanAmount(double loanAmount) {
 this.loanAmount = loanAmount;
 }

 /** Find monthly payment */
 public double getMonthlyPayment() {
 monthlyInterestRate = annualInterestRate / 12;
 
 double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
 (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
 return monthlyPayment;
 
 }

 /** Find total payment */
 public double getTotalPayment() {
 double totalPayment = getMonthlyPayment() * numberOfYears * 12;
 return totalPayment;
 }
 

  public double getPeriodicPayment ()
  {
	monthlyInterestRate = getAnnualInterestRate()/12; 
	termInMonths = (getNumberOfYears() * 12);
	double power = Math.pow((1 + monthlyInterestRate), termInMonths);
	double annuityFactor = (1 - power)/monthlyInterestRate;  
    //double annuityFactor = (( 1 - (Math.pow((1 + monthlyInterestRate ), (termInMonths)/ monthlyInterestRate);
    double periodicPayment = getLoanAmount() / annuityFactor;
    return periodicPayment; 
  } 
  


 public String getElegibility(){
	 
	String elegibility = ""; 
	double monthlyIncome = getTotalIncome()/12; 
	double elegibilityPercentage = (getMonthlyPayment()/monthlyIncome)*100;  
	
	if (getMonthlyPayment()/monthlyIncome <= ELEG_PERC){
     elegibility = "Elegible" + Double.toString(elegibilityPercentage);
   } else {
       elegibility = "InElegible" + Double.toString(elegibilityPercentage);
     }
   return elegibility;

 }


 }

