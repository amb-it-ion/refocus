package com.amb_it_ion.refocus.view;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import rx.Observable;

import com.amb_it_ion.refocus.view.TrafficLightIndicator.TrafficLight;
import com.amb_it_ion.rxvaadin.RxVaadin;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class DevScorePresenter {
	public static final Map<String, Double> coverages = new LinkedHashMap<String, Double>() {
		{
			put(">= 90%", 1.0);
			put("50% - 89%", 0.8);
			put("1% - 49%", 0.4);
			put("<1%", 0.0);
		}
	};

	public static Collection<String> agilities = Arrays.asList(
			"There is a proper Product Owner",
			"We have a proper, prioritized backlog", "We have dailes",
			"We work in fixed-scope sprints");

	public static final Map<String, Double> PMTechnicalities = new LinkedHashMap<String, Double>() {
		{
			put("Today!", 1.0);
			put("During the last 30 days", 0.9);
			put("During the last year", 0.75);
			put("Years ago", 0.25);
			put("He/she isn't technical", 0.0);
		}
	};

	public static void setupUILogic(DevScoreView ui) {
		// Get the value streams corresponding to the events generated by the
		// input components. We use valuesWithDefault so that each Observable
		// will include the given default value immediately.
		Observable<String> coverages = RxVaadin.valuesWithDefault(
				ui.ogTestCoverage, null);
		Observable<Set<String>> agilities = RxVaadin.valuesWithDefault(
				ui.lsAgility, null);
		Observable<String> teamSizeStrings = RxVaadin.valuesWithDefault(
				ui.tfTeamSize, null);
		Observable<String> PMTechnicalities = RxVaadin.valuesWithDefault(
				ui.cbPMTechnicality, null);
		Observable<Boolean> vaadinUses = RxVaadin.valuesWithDefault(
				ui.chkVaadin, false);

		// Get a stream of scores that are calculated for each valid input
		// combination
		Observable<Double> scores = DevScoreLogic.scores(coverages, agilities,
				teamSizeStrings, PMTechnicalities, vaadinUses);

		// Get a stream of lists that contain the names of inputs that
		// have an invalid or missing value
		Observable<List<String>> faults = DevScoreLogic.faults(coverages,
				agilities, teamSizeStrings, PMTechnicalities, vaadinUses);

		setupFaultLabelLogic(ui.lblFault, scores, faults);

		setupScoreLabelLogic(ui.lblScore, scores, faults);

		setupTrafficLightLogic(ui.indicator, scores, faults);
	}

	private static void setupFaultLabelLogic(Label lblFault,
			Observable<Double> scores, Observable<List<String>> faults) {
		// Map the missing input name lists to proper fault messages
		Observable<String> faultMessages = faults.map(names -> {
			return "Please give valid a value for: "
					+ names.stream().collect(Collectors.joining(", "));
		});

		// Connect the fault label to the fault message stream
		RxVaadin.follow(lblFault, faultMessages);

		// Make a valid score clear the fault label
		RxVaadin.clearBy(lblFault, scores, "&nbsp;");
	}

	private static void setupScoreLabelLogic(Label lblScore,
			Observable<Double> scores, Observable<List<String>> faults) {
		// Map the scores to strings through a simple formatter
		Observable<String> scoreStrings = scores.map(score -> {
			return String.format("%.2f", score);
		});

		// Hook the score label to the score string stream
		RxVaadin.follow(lblScore, scoreStrings);

		// Make a fault clear the score label
		RxVaadin.clearBy(lblScore, faults, "&nbsp;");
	}

	private static void setupTrafficLightLogic(TrafficLightIndicator indicator,
			Observable<Double> scores, Observable<List<String>> faults) {
		// Map the score values into traffic light levels.
		Observable<TrafficLight> trafficLights = scores.map(score -> {
			return score <= 25 ? TrafficLight.RED
					: (score <= 75 ? TrafficLight.YELLOW : TrafficLight.GREEN);
		});

		// Connect the traffic light indicator to the light level stream
		RxVaadin.follow(indicator, trafficLights);

		// Make a fault clear the score indicator
		RxVaadin.clearBy(indicator, faults, TrafficLight.OFF);
	}
}