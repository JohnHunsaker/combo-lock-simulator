
/**
 * Represents a combination lock, with members for user-entered digits,
 * current position of dial, whether turning motion has began, and
 * for the correct pin numbers in the combination.
 */
public class ComboLock {

	private int mFirstDigit, mSecondDigit, mThirdDigit;
	private int mPosition;
	private boolean mStartedSpinning;
	private boolean mPin1, mPin2, mPin3;

	/**
	 * Constructs a ComboLock object with three given digits.
	 * 
	 * @param digit1
	 * @param digit2
	 * @param digit3 
	 */
	public ComboLock(int digit1, int digit2, int digit3){
	  mFirstDigit = digit1;
	  mSecondDigit = digit2;
	  mThirdDigit = digit3;
	}
	
	/**
	 * Gets the position of the dial.
	 * 
	 * @return an integer for the number position
	 */
	public int getDialPosition(){
		return mPosition;
	}
	
	/**
	 * Resets the combination lock.
	 */
	public void reset(){
	  mStartedSpinning = false; 
	  mPin1 = false;
	  mPin2 = false;
	  mPin3 = false;
	}
	
	/**
	 * Turns the dial left.
	 * 
	 * @param ticks is the distance required to reach the new position.
	 */
	public void turnLeft(int ticks){
		if (mPosition + ticks < 40 ){
			mPosition += ticks;
		}
		else{
			mPosition = ((mPosition + ticks) - 40);
		}
		if (mPosition == mSecondDigit){
		  mPin2 = true; 
		}
	}
	
	/**
	 * Turns the dial right.
	 * 
	 * @param ticks is the distance required to reach the new position.
	 */
	public void turnRight(int ticks){
		if (!mStartedSpinning){
			mPosition = (40 - ticks);
			mStartedSpinning = true;
			if (mPosition == mFirstDigit){
			  mPin1 = true;
			}
		}
		else{
			if (mPosition - ticks > 0){
				mPosition -= ticks;
			}
			else{
				mPosition = (40 - (ticks - mPosition));
			}
			if (mPosition == mThirdDigit){
			 mPin3 = true;
			}
		}
	}
	
	/**
	 * Returns true or false if the lock is opened.
	 * 
	 * @return boolean value.
	 */
	public boolean open(){
		if (mPin1 && mPin2 && mPin3){
		  return true;
		}
		else{
			return false;
		}
	}
}