package com.amb_it_ion.refocus.view;

import com.amb_it_ion.refocus.view.ui.MainView;
import com.amb_it_ion.refocus.view.ui.StartView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme(DevScoreTheme.THEME_NAME)
public class DevScoreUI extends UI {
	public static final String MAINVIEW = "main";

//	@Override
//	protected void init(VaadinRequest request) {
//		Navigator  navigator;
//	    
//	    
//		DevScoreView mainView = new DevScoreView();
//		
//		
//		setContent(new VerticalLayout() {
//			{
//				setMargin(true);
//
//				addComponent(mainView);
//				setComponentAlignment(mainView, Alignment.MIDDLE_CENTER);
//			}
//		});
//
//
//		
//		
//		DevScorePresenter.setupUILogic(mainView);
//	}
//	

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");
        
        // Create a navigator to control the views
        setNavigator( new Navigator(this, this));
        
        // Create and register the views
        getNavigator().addView("", new StartView(  getNavigator() ));
        getNavigator().addView(MAINVIEW, new MainView( getNavigator() ));
    }
}