public class RationalNumber extends Number {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = nume;
      denominator = deno;
      reduce();
      if (denominator < 0) {
        numerator *= -1;
        denominator *= -1;
      }
    }
  }

  public double getValue(){
    return (double)numerator / denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber out = new RationalNumber(getDenominator(), getNumerator());
    return out;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (getDenominator() == 1) {
      return "" + getNumerator();
    }
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int divisor = gcd(numerator,denominator);
    numerator /= divisor;
    denominator /= divisor;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber out = new RationalNumber(getNumerator() * other.getNumerator(), getDenominator() * other.getDenominator());
    return out;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int outNumerator = getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator();
    int outDenominator = getDenominator() * other.getDenominator();
    RationalNumber out = new RationalNumber(outNumerator, outDenominator);
    return out;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int outNumerator = getNumerator() * other.getDenominator() - other.getNumerator() * getDenominator();
    int outDenominator = getDenominator() * other.getDenominator();
    RationalNumber out = new RationalNumber(outNumerator, outDenominator);
    return out;
  }
} 