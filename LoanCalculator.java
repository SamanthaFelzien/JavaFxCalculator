

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javafx.application.Application; // JavaFX Application
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Font; // needed for JavaFX Font object
import javafx.scene.text.FontWeight; // needed for JavaFX FontWeight object
import javafx.scene.text.Text; // needed for JavaFX Text object
import javafx.scene.layout.HBox; // Needed for HBox object
import javafx.scene.Scene; // needed for JavaFX scene object
import javafx.scene.layout.GridPane; // needed for JavaFX GridPane object
import javafx.scene.control.Label; // needed for JavaFX Label object
import javafx.scene.control.TextField; // needed for JavaFX TextField control
import javafx.scene.control.PasswordField; // needed for JavaFX PasswordField control
import javafx.scene.control.Button; // needed for JavaFX Button control
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color; // needed for JavaFX color object
import javafx.geometry.Insets; // needed for JavaFX Insets object
import javafx.geometry.Pos; // needed for JavaFX Pos object
import javafx.event.ActionEvent; // needed for JavaFX ActionEvent
import javafx.event.EventHandler; // needed for JavaFX EventHandler
import javafx.scene.input.KeyEvent; // needed for JavaFX KeyEvent
import javafx.scene.input.KeyCode; // needed for JavaFX KeyCodes
import javafx.stage.Stage; // needed for JavaFX Stage object
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.Font; // needed for JavaFX Font object
import javafx.scene.text.FontWeight; // needed for JavaFX FontWeight object
import javafx.scene.text.Text;// needed for JavaFX Text object
import javafx.scene.layout.HBox; // Needed for HBox object
import javafx.scene.Scene; // needed for JavaFX scene object
import javafx.scene.layout.GridPane; // needed for JavaFX GridPane object
import javafx.scene.control.Label; // needed for JavaFX Label object
import javafx.scene.control.TextField; // needed for JavaFX TextField control
import javafx.scene.control.PasswordField; // needed for JavaFX PasswordField control
import javafx.scene.control.Button; // needed for JavaFX Button control
import javafx.scene.paint.Color; // needed for JavaFX color object
import javafx.geometry.Insets; // needed for JavaFX Insets object
import javafx.geometry.Pos; // needed for JavaFX Pos object
import javafx.geometry.HPos;
import javafx.event.ActionEvent; // needed for JavaFX ActionEvent
import javafx.event.EventHandler; // needed for JavaFX EventHandler
import javafx.scene.input.KeyEvent; // needed for JavaFX KeyEvent
import javafx.scene.input.KeyCode; // needed for JavaFX KeyCodes
import javafx.stage.Stage; // needed for JavaFX Stage object
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.layout.CornerRadii;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader ;

import java.util.StringTokenizer;

import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class LoanCalculator extends Application {
  
  private TextField tfSalaryAndWages = new TextField();
  private TextField tfInterestIncome = new TextField();
  private TextField tfInvestmentIncome = new TextField();
  private TextField tfOtherIncome = new TextField();
  private TextField tfTotalIncome = new TextField();
  //private TextField tfAnnualInterestRate = new TextField();
 // private TextField tfNumberOfYears = new TextField();
  private TextField tfLoanAmount = new TextField();
  private TextField tfMonthlyPayment = new TextField();
  private TextField tfTotalPayment = new TextField();
  private TextField tfElegibility = new TextField(); 
  private Button btCalculate = new Button("Calculate");
  private Button btCancel = new Button("Cancel");
  
  private String selectedInterest;
  private Text termText = null; 

  private ComboBox<String> interestRateCombo = null;
  private ComboBox<String> loanTermCombo = null;
  
  File interestRate = new File(System.getProperty("Samantha Felzien.dir") + "/annual_interest_rates.txt");
  File loanTerm = new File(System.getProperty("Samantha Felzien.dir") + "/loan_terms.txt");
  
  private final String INTEREST_RATES = "annual_interest_rates.txt";
  private final String LOAN_TERMS = "loan_terms.txt";
  
  private List<String[]> interestRateArrayList = new ArrayList<String[]>();
  private List<String> interestRateList = new ArrayList<String>(); // An ArrayList of states used for populating the stateCombo. getData adds items to this ArrayList.

  private List<String[]> loanTermArrayList = new ArrayList<String[]>();  
  private List<String> loanTermList = new ArrayList<String>(); // An ArrayList of cities used for populating the cityCombo. This ArrayList is extracted from stateCityList.

  final int INTEREST_ELEMENT = 0;

  final int LOAN_ELEMENT = 0;
 
 

  
  public static void main(String[] args)
  {
	  launch(args);
  }
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
      gridPane.setHgap(25);
    gridPane.setVgap(25);
    gridPane.add(new Label("Salary and Wages:"), 0,0);
    gridPane.add(tfSalaryAndWages, 1, 0);
     gridPane.add(new Label("Interest Income:"), 0,1);
    gridPane.add(tfInterestIncome, 1, 1);
     gridPane.add(new Label("Investment Income:"), 0,2);
    gridPane.add(tfInvestmentIncome, 1, 2);
     gridPane.add(new Label("Other Income:"), 0,3);
    gridPane.add(tfOtherIncome, 1, 3);
     gridPane.add(new Label("Total Income:"), 0,4);
    gridPane.add(tfTotalIncome, 1, 4);
    gridPane.add(btCalculate, 0, 5);
    gridPane.add(btCancel, 1, 5);
    //gridPane.add(new Label("Annual Interest Rate:"), 5, 0);
  
   // gridPane.add(new Label("Number of Years:"), 5, 1);
   // gridPane.add(tfNumberOfYears, 6, 1);
    gridPane.add(new Label("Loan Amount:"), 5, 2);
    gridPane.add(tfLoanAmount, 6,2);
    gridPane.add(new Label("Monthly Payment:"), 5, 3);
    gridPane.add(tfMonthlyPayment, 6, 3);
    gridPane.add(new Label("Total Payment:"), 5, 4);
    gridPane.add(tfTotalPayment, 6, 4);
    gridPane.add(new Label("Eligibility:"), 5, 5);
    gridPane.add(tfElegibility, 6, 5);
    
    getInterestData();
    getLoanData(); 

	ObservableList<String> olInterest = FXCollections.observableArrayList( interestRateList ); 	
	ObservableList<String> olLoan = FXCollections.observableArrayList( loanTermList );
	
	interestRateCombo = new ComboBox<String>();				
	interestRateCombo.setEditable(false); 					
	interestRateCombo.setPrefWidth(150);
	interestRateCombo.setPromptText("Select Rate");				
	interestRateCombo.setItems( olInterest);
	  gridPane.add(interestRateCombo, 5, 0); 



	loanTermCombo = new ComboBox<String>();
	loanTermCombo.setEditable(false); 	
	loanTermCombo.setPrefWidth( 150);
	loanTermCombo.setPromptText("Select Loan Term");
	loanTermCombo.setItems( olLoan);
    gridPane.add(loanTermCombo, 6, 0); 

    
    gridPane.setAlignment(Pos.CENTER);
    tfSalaryAndWages.setAlignment(Pos.BOTTOM_LEFT);
    tfInterestIncome.setAlignment(Pos.BOTTOM_LEFT);
    tfInvestmentIncome.setAlignment(Pos.BOTTOM_LEFT);
    tfOtherIncome.setAlignment(Pos.BOTTOM_LEFT);
    tfSalaryAndWages.setAlignment(Pos.BOTTOM_LEFT);
    tfTotalIncome.setAlignment(Pos.BOTTOM_RIGHT);
    //loanTermCombo.setAlignment(Pos.BOTTOM_RIGHT);
    tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
    tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfElegibility.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalIncome.setEditable(false);
    tfMonthlyPayment.setEditable(false);
    tfTotalPayment.setEditable(false);
    tfElegibility.setEditable(false);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);
    
    /*
   
    tfSalaryAndWages.setOnKeyTyped( typedKeyHandler ) ;
    tfInterestIncome.setOnKeyTyped( typedKeyHandler ) ;
    tfInvestmentIncome.setOnKeyTyped( typedKeyHandler ) ;
    tfOtherIncome.setOnKeyTyped( typedKeyHandler ) ;
    tfNumberOfYears.setOnKeyTyped( typedKeyHandler ) ;
    tfLoanAmount.setOnKeyTyped( typedKeyHandler ) ;
    tfAnnualInterestRate.setOnKeyTyped( typedKeyHandler ) ;
    */
   
    
    // Process events
    btCalculate.setOnAction(
        new EventHandler<ActionEvent> () {
      @Override
      public void handle(ActionEvent e) {
      calculateLoanPayment();
    	  
    }
    });
    
    btCancel.setOnAction(
    		new EventHandler<ActionEvent> () {
    			@Override
    			public void handle(ActionEvent e){
    				primaryStage.close(); 
    			}
    		});
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 700, 350);
    primaryStage.setTitle("LoanCalculator"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  


 

  public void getInterestData() 
  {
	 String inputValue       = "";

	File olInterestRateList         = null; 

	FileReader frObject1     = null;

	BufferedReader brObject1 = null;

	try
	{
		olInterestRateList = new File( INTEREST_RATES);

		frObject1   = new FileReader( olInterestRateList );

		brObject1 = new BufferedReader( frObject1 );
	}

	catch (Exception ex)
	{
		System.out.println("\nAn Exception occured while creating a BufferedReader for " + INTEREST_RATES + " : " + ex.getMessage() + ".\n");

		Platform.exit();
	}
	
	
	try
	{
		String previousInterest =""; 

		while ( (inputValue = brObject1.readLine()) != null)
		{
			String[] interestRateArray = new String[2]; 
 
			StringTokenizer st = new StringTokenizer(inputValue); 

     			while (st.hasMoreTokens()) 
			{
         				interestRateArray[ INTEREST_ELEMENT] = st.nextToken(); 


				interestRateArrayList.add( interestRateArray);

				if ( !interestRateArray[ INTEREST_ELEMENT].equals( previousInterest )) 
				{
					interestRateList.add( interestRateArray[ INTEREST_ELEMENT] ); 

					previousInterest = interestRateArray[ INTEREST_ELEMENT] ;
				}
			}
		}

	}

	catch (IOException ex)
	{
		System.out.println("\nAn IOException occured while reading " + INTEREST_RATES + " : " + ex.getMessage() + ".\n");
	}

	catch (Exception ex)
	{
		System.out.println("\nAn Exception occured while reading " + INTEREST_RATES+ " : " + ex.getMessage() + ".\n");
	}



	finally
	{
		try
		{
			brObject1.close();
		}

		catch( Exception ex)
		{
			System.out.println("\nAn Exception occured while closing " + INTEREST_RATES + " : " + ex.getMessage() + ".\n");
		}
	
	}

  }
  
  public void getLoanData() 
  {
	String inputValue       = "";

	File olLoanTermList = null; 

	FileReader frObject   = null;

	BufferedReader brObject = null;
	

	try
	{
		olLoanTermList = new File( LOAN_TERMS);
		
		frObject   = new FileReader( olLoanTermList );

		brObject = new BufferedReader( frObject );
		

	}

	catch (Exception ex)
	{
		System.out.println("\nAn Exception occured while creating a BufferedReader for " + LOAN_TERMS + " : " + ex.getMessage() + ".\n");

		Platform.exit();
	}
	
	try
	{
		String previousTerm =""; 

		while ( (inputValue = brObject.readLine()) != null)
		{
			String[] loanTermArray = new String[2]; 
 
			StringTokenizer st = new StringTokenizer(inputValue); 
     			while (st.hasMoreTokens()) 
			{
         				loanTermArray[ LOAN_ELEMENT] = st.nextToken(); // From the file organization we know that state precedes city.

				//stateCityArray[CITY_ELEMENT] = st.nextToken(); // From the file organization we know that city follows state.

				loanTermArrayList.add( loanTermArray);

				if ( !loanTermArray[ LOAN_ELEMENT].equals( previousTerm )) // Notice the "!". Don't add duplicate state values to stateList.
				{
					loanTermList.add( loanTermArray[ LOAN_ELEMENT] ); // We need a separate list of states for stateCombo.

					previousTerm = loanTermArray[ LOAN_ELEMENT] ;
				}
			}
		}

	}

	catch (IOException ex)
	{
		System.out.println("\nAn IOException occured while reading " + LOAN_TERMS + " : " + ex.getMessage() + ".\n");
	}

	catch (Exception ex)
	{
		System.out.println("\nAn Exception occured while reading " + LOAN_TERMS + " : " + ex.getMessage() + ".\n");
	}


	finally
	{
		try
		{
			brObject.close(); 
		}

		catch( Exception ex)
		{
			System.out.println("\nAn Exception occured while closing " + LOAN_TERMS + " : " + ex.getMessage() + ".\n");
		}
	
	}

  }

/*
  public void addInterestRatesToCombo() // This method reads the stateAndCity ArrayList to extract cities related to a selected state and add them to an ArrayList that populates cityCombo.
  {
	interestRateList.removeAll(interestRateList); // Make sure the list is empty before the cities of another state are added to it. It's odd, but you must pass the list of elements to remove.

	ObservableList<String> olInterestRateList = FXCollections.observableArrayList( interestRateList);

	interestRateCombo.setItems( olInterestRateList );
  }

  public void addLoanTermsToCombo() // This method reads the stateAndCity ArrayList to extract cities related to a selected state and add them to an ArrayList that populates cityCombo.
  {
	loanTermList.removeAll(loanTermList); // Make sure the list is empty before the cities of another state are added to it. It's odd, but you must pass the list of elements to remove.

	ObservableList<String> olLoanTermList = FXCollections.observableArrayList( loanTermList );

	loanTermCombo.setItems( olLoanTermList );
  }
  
  */
  /*
  class InterestComboClicked implements EventHandler<ActionEvent>
  {
  	 LoanCalculator formObj = null; // Declare a data member to represent an object of the form class.

  	public  InterestComboClicked(LoanCalculator formObj) // This constructor receives an object of the form class.
  	{
  		this.formObj = formObj;
  	}

  	public void handle(ActionEvent e) 
  	{
  		formObj.getValue();
  		//interestRateCombo.setItems(interestRateCombo.getValue());
  		//formObj.addInterestRatesToCombo();

  		formObj.unselectInterestRate();

  	}
  }

  class LoanComboClicked implements EventHandler<ActionEvent>
  {
  	 LoanCalculator formObj = null; // Declare a data member to represent an object of the form class.

  	public  LoanComboClicked(LoanCalculator formObj) // This constructor receives an object of the form class.
  	{
  		this.formObj = formObj;
  	}

  	public void handle(ActionEvent e) 
  	{

  		//formObj.addLoanTermsToCombo();

  		formObj.unselectLoanTerm();

  	}
  }
  */
  
  
  private void calculateLoanPayment() {
	    // Get values from text fields
	    double salaryAndWages = Double.parseDouble(tfSalaryAndWages.getText());
	    double interestIncome = Double.parseDouble(tfInterestIncome.getText());
	    double investmentIncome = Double.parseDouble(tfInvestmentIncome.getText());
	    double otherIncome = Double.parseDouble(tfOtherIncome.getText());
	   // double totalIncome = Double.parseDouble(tfTotalIncome.getText());
	 
	    double interest =
	      Double.parseDouble(interestRateCombo.getValue());
	    int year = Integer.parseInt(loanTermCombo.getValue());
	    double loanAmount =
	      Double.parseDouble(tfLoanAmount.getText());
	    
	    // Create a loan object. Loan defined in Listing 10.2
	    Loan loan = new Loan(interest, year, loanAmount, salaryAndWages, interestIncome, investmentIncome, otherIncome);
	    
	    // Display monthly payment and total payment
	    
	    tfTotalIncome.setText(String.format("$%.2f",
	            loan.getTotalIncome()));
	    
	    tfMonthlyPayment.setText(String.format("$%.2f",
	                                           loan.getMonthlyPayment()));
	    tfTotalPayment.setText(String.format("$%.2f",
	                                         loan.getTotalPayment()));
	    tfElegibility.setText(loan.getElegibility());
	  }
/*  
  TypedKey typedKeyHandler = new TypedKey( this ) ;
}
  

 class TypedKey implements EventHandler<KeyEvent>  
 {
   LoanCalculator formObj = null; // Declare a data member to represent an object of the form class.

  public TypedKey(LoanCalculator salaryAndWages) // This constructor receives an object of the form class.
  {
   this.formObj = formObj;
  }

  public void handle(KeyEvent e) 
  {
   if ( (e.getCharacter().compareTo("a") >= 0 && e.getCharacter().compareTo("z") <= 0) || (e.getCharacter().compareTo("A") >= 0 && e.getCharacter().compareTo("Z") <= 0))
   {
      //formObj.setStyle("-fx-background-color: white;");
   }

   else if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
   {
	   //formObj.setStyle("-fx-background-color: red;");

   }

  }

@Override
public void start(Stage arg0) throws Exception {
	// TODO Auto-generated method stub
	
}
*/
 }
  
