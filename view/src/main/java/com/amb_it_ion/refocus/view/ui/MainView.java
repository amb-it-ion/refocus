package com.amb_it_ion.refocus.view.ui;

import java.util.Collection;

import rx.Observable;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.external.plug.api.ViewPlug;
import com.amb_it_ion.refocus.view.DevScoreUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

/** Main view with a menu */
public class MainView extends VerticalLayout implements View, ViewPlug {

	private static final long serialVersionUID = -3398565663865641952L;
	Panel panel;

	private Navigator navigator;
	private VerticalLayout menuContent;

	// Menu navigation button listener
	class ButtonListener implements Button.ClickListener {
		String menuitem;

		public ButtonListener(String menuitem) {
			this.menuitem = menuitem;
		}

		@Override
		public void buttonClick(ClickEvent event) {
			// Navigate to a specific state
			navigator.navigateTo(DevScoreUI.MAINVIEW + "/" + menuitem);
		}
	}

	public MainView(Navigator navigator) {

		this.navigator = navigator;

		setSizeFull();

		// Layout with menu on left and view area on right
		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.setSizeFull();

		// Have a menu on the left side of the screen
		Panel menu = new Panel("List of NavigationSections");
		menu.setHeight("100%");
		menu.setWidth(null);

		menuContent = new VerticalLayout();
		menu.setContent(menuContent);
		hLayout.addComponent(menu);

		// A panel that contains a content area on right
		panel = new Panel("An Equal");
		panel.setSizeFull();
		hLayout.addComponent(panel);
		hLayout.setExpandRatio(panel, 1.0f);

		addComponent(hLayout);
		setExpandRatio(hLayout, 1.0f);

		// Allow going back to the start
		Button logout = new com.vaadin.ui.Button("Logout",
				new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						navigator.navigateTo("");
					}
				});
		addComponent(logout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setSizeFull();
		panelContent.setMargin(true);
		panel.setContent(panelContent); // Also clears

		if (event.getParameters() == null || event.getParameters().isEmpty()) {
			panelContent.addComponent(new Label("Nothing to see here, "
					+ "just pass along."));
			return;
		}

		Label back = new Label("The " + event.getParameters()
				+ " is watching you");
		back.setSizeUndefined();
		panelContent.addComponent(back);
		panelContent.setComponentAlignment(back, Alignment.MIDDLE_CENTER);
	}

	@Override
	public Observable<NavigationSection> selectOnList(
			Collection<NavigationSection> collection) {

		for (NavigationSection navigationSection : collection) {
			menuContent.addComponent(new Button( navigationSection.getName(), new ButtonListener(navigationSection.getName())));
		}

		menuContent.setWidth(null);
		menuContent.setMargin(true);
		
		return null;
	}
}