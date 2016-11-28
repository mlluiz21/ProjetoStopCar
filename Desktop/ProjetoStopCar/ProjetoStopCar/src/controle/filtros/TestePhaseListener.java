package controle.filtros;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class TestePhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent evento) {
		System.out.println(getClass().getName() + " - " + evento.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent evento) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
