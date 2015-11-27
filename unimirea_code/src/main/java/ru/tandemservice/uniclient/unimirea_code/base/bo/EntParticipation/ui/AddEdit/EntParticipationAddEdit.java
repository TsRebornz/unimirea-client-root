package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.ui.config.BusinessComponentManager;
import org.tandemframework.caf.ui.config.presenter.PresenterExtPoint;

/**
 * Created by ocean on 05.11.2015.
 */
@Configuration
public class EntParticipationAddEdit extends BusinessComponentManager
{
    @Override
    @Bean
    public PresenterExtPoint presenterExtPoint() {
        return presenterExtPointBuilder().create();
    }
}
