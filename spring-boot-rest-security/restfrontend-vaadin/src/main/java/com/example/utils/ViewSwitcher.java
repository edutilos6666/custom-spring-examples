package com.example.utils;

import com.example.view.HomeView;
import com.example.view.LoginView;
import com.example.view.MainView;
import com.example.view.RegisterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
@Service
public class ViewSwitcher {
    @Autowired
    private MainView mainView;
    @Autowired
    private LoginView loginView;
    @Autowired
    private RegisterView registerView;
    @Autowired
    private HomeView homeView;

    public void switchToLoginView() {
        mainView.removeAll();
        mainView.add(loginView);
    }

    public void switchToRegisterView() {
        mainView.removeAll();
        mainView.add(registerView);
    }

    public void switchToHomeView() {
        mainView.removeAll();
        homeView.fill();
        mainView.add(homeView);
    }
}
