
public class Bowling {
	
	private Frame[] scoresheet; //array that holds all the frames of a bowling game
	private int frameNum; //the number of the frame the player is currently on
	
	private class Frame{ //Frame of a bowling game
		
		int t1, t2, frameScore;
		
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
	
	
	public Bowling(){ //constructor
		scoresheet = new Frame[10];
		frameNum = 0;
	}
	
	public int getFrameScore(int frame){ //returns the score in that frame, at the current time
		return scoresheet[frame].frameScore;
	}
	
	public int getTotalScore(){ //returns current total score
		
		int finalScore = 0;
		
		if (scoresheet[0] == null) return finalScore; //prevents case that no bowling has yet occurred
		
		for(int i = 0; i < frameNum + 1; i ++){
			finalScore += getFrameScore(i);
		}
		
		return finalScore;
	}
	
	public void addThrow(int first, int second){ //adds new Frame, updates frameScores & increments
		
		if(first + second > 10 || first > 10 || second > 10) throw new IllegalArgumentException("Invalid bowling entry.");
		
		scoresheet[frameNum] = new Frame(first, second);
		
		for(int i = 0; i < frameNum + 1; i++){
			
			if(scoresheet[i].isStrike() && frameNum >= i + 2)
				scoresheet[i].frameScore = scoresheet[i].getRawScore() + scoresheet[i+1].getRawScore()
					+ scoresheet[i+2].getRawScore();
			
			else if(scoresheet[i].isSpare() && frameNum >= i + 1)
				scoresheet[i].frameScore = scoresheet[i].getRawScore() + scoresheet[i+1].getRawScore();
			else
				scoresheet[i].frameScore = scoresheet[i].getRawScore();
			
		}
		
		frameNum++;
	}
	
	public int getCurrentFrameNum(){
		return frameNum + 1; //0 to 1 index system
	}
	
}
