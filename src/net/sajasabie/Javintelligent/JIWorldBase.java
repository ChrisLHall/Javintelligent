package net.sajasabie.Javintelligent;

import java.util.ArrayList;
import java.util.List;

public class JIWorldBase {
	
	public List<JIObjectHolder> mObjectHolders;
	public int mTurns = 0;
	public int mRound = 0;
	
	public JIWorldBase() {
		mObjectHolders = new ArrayList<JIObjectHolder>();
	}
	
	public void onStep() {
		for(JIObjectHolder holder : mObjectHolders) {
			holder.onMoveUpdate();
			this.simulate(holder);
			holder.onRenderableUpdate();
		}
	}
	
	public void simulate(JIObjectHolder theObject) {
		//subclasses must implement this
	}

}

