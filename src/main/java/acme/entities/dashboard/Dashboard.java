
package acme.entities.dashboard;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	String[]					labels;
	String[]					numTech;
	String[]					numTool;
	Integer						totalNotices;
	Integer						totalTechRecords;
	Integer						totalToolRecords;
	Double						inqMinMoney;
	Double						inqMaxMoney;
	Double						inqAvgMoney;
	Double						inqStdDevMoney;
	Double						ovtMinMoney;
	Double						ovtMaxMoney;
	Double						ovtAvgMoney;
	Double						ovtStdDevMoney;

	//---- D04 ----

	Double						avgInvRoundXEnterpreneur;
	Double						avgAppsXEnterpreneur;
	Double						avgInvRoundXInvestor;
}
