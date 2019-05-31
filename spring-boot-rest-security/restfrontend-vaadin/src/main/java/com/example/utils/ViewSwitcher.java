package com.example.utils;

import com.example.view.RegisterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
@Service
public class ViewSwitcher {
    @Autowired
    private RegisterView registerView;

    public void showRegisterView() {
        registerView.setVisible(true);
    }

    public void hideRegisterView() {
        registerView.setVisible(false);
    }
}
