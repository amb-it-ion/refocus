package com.amb_it_ion.refocus.view.ui;

import java.util.Collection;

import rx.Observable;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.business.interaction.impl.view.ViewInteraction;
import com.amb_it_ion.refocus.business.interaction.impl.view.navigation.NavigationViewInteraction;
import com.amb_it_ion.refocus.view.DevScoreUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/** A start view for navigating to the main view */
public class StartView extends VerticalLayout implements View,
		NavigationViewInteraction {

	private Navigator navigator;

	public StartView(Navigator navigator) {

		this.navigator = navigator;

		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome to the Animal Farm");
	}

	@Override
	public Observable<NavigationSection> navigateTo(
			Collection<NavigationSection> collection) {

		Button button = new Button("Go to Main View",
				new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						navigator.navigateTo(DevScoreUI.MAINVIEW);
					}
				});
		addComponent(button);
		setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		
		return null;
	}
}