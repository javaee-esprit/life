package ego.life.web.lifecycle;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycleListener implements PhaseListener{

	private static final long serialVersionUID = -2760388591683908783L;

	public void afterPhase(PhaseEvent event) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "------------------------end "+event.getPhaseId());
	}

	public void beforePhase(PhaseEvent event) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "------------------------begin "+event.getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
