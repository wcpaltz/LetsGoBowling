
public class Bowling {
	
	private Frame[] scoresheet;
	private int frameNum;
	
	private class Frame{
		
		int t1, t2;
		
		private Frame(int t1, int t2){
			this.t1 = t1;
			this.t2 = t2;
		}
		
		public boolean isStrike(){
			return t1 == 10;
		}
		
		public boolean isSpare(){
			return !isStrike() && (t1 + t2 == 10);
		}
		
		public int getRawScore(){
			return t1 + t2;
		}
		
	}
	
	
	public Bowling(){
		scoresheet = new Frame[10];
		frameNum = 0;
	}
	
	public int getFrameScore(int frameNum){
		return -1;
	}
	
	public int getTotalScore(){
		return -1;
	}
	
	public void addThrow(int first, int second){
		scoresheet[frameNum] = new Frame(first, second);
	}
	
	public int getCurrentFrameNum(){
		return frameNum + 1;
	}
	
}
