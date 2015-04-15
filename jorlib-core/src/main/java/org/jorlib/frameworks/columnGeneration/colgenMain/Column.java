package org.jorlib.frameworks.columnGeneration.colgenMain;

import org.jorlib.frameworks.columnGeneration.pricing.AbstractPricingProblem;


/**
 * Abstract Class modeling a column in the column generation procedure.
 * @author jkinable
 *
 */
public abstract class Column<T, U extends Column<T,U,V>, V extends AbstractPricingProblem<T,U,V>>/*<T, V extends PricingProblem<T, C>, C extends Column<T,V, C>> */{
	//The value of this ExamSchedule as determined by the master problem
	public double value;
	//Indicates whether this is a real column generated by a pricing problem, or whether it has been generated to obtain an intial feasible solution.
	//Optimal solutions may NOT contain artificial columns unless the problem is infeasible
	public final boolean isArtificialColumn;
	//Textual description of the method who created this column, e.g. a pricing problem, initial solution, artificial, etc.
	//Used for debugging purposes only to determine where a column is comming from
	public final String creator;
	
	//public final PricingProblem<T, U> associatedPricingProblem;
	public final V associatedPricingProblem;
	
	/**
	 * Constructs a new column
	 * @param creator Who/What created this column?
	 * @param isArtificial Is this an artificial column?
	 */
//	public Column(String creator, boolean isArtificial, PricingProblem<T, U> associatedPricingProblem){
	public Column(String creator, boolean isArtificial, V associatedPricingProblem){
		this.creator=creator;
		this.isArtificialColumn=isArtificial;
		this.associatedPricingProblem=associatedPricingProblem;
	}
	
	/**
	 * Compares two columns mutually
	 */
	public abstract boolean equals(Object o);
	/**
	 * Creates a hashCode for the given column
	 */
	public abstract int hashCode();
	/**
	 * Gives a textual representation of a column
	 */
	public abstract String toString();

}
