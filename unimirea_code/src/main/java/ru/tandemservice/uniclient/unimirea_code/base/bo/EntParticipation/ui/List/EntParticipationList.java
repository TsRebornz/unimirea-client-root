package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.command.io.DSInput;
import org.tandemframework.caf.command.io.DSOutput;
import org.tandemframework.caf.logic.handler.IReadAggregateHandler;
import org.tandemframework.caf.ui.config.BusinessComponentManager;
import org.tandemframework.caf.ui.config.datasource.ColumnListExtPoint;
import org.tandemframework.caf.ui.config.presenter.PresenterExtPoint;
import org.tandemframework.core.component.PublisherActivator;
import org.tandemframework.core.entity.IEntity;
import org.tandemframework.core.util.ParametersMap;
import org.tandemframework.core.view.list.column.IPublisherLinkResolver;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDSHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View.EntParticipationView;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View.EntParticipationViewUI;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

/**
 * Created by ocean on 14.10.2015.


Source should be ISingleSelectModel or array or collection.
But source type is : org.tandemframework.core.view.list.source.DynamicListDataSource
*/
@Configuration
public class EntParticipationList extends BusinessComponentManager
{
    public static final String SELECT_ENT_DS = "selectEntDS";

    @Bean
    @Override
    public PresenterExtPoint presenterExtPoint()
    {
        //Регистрируем data source типа searchListDS c именем SELECT_ENT_DS
        return presenterExtPointBuilder().addDataSource(searchListDS(SELECT_ENT_DS, selectEntDS(), this.entParticipationDSHandler())).create();
    }

    @Bean
    public IReadAggregateHandler<DSInput, DSOutput> entParticipationDSHandler()
    {
        return new EntParticipationDSHandler(this.getName());
    }


    @Bean
    public ColumnListExtPoint selectEntDS()
    {

        //Сюда пишем привязку из i18n.properties
        return columnListExtPointBuilder(SELECT_ENT_DS)
                /*.addColumn(publisherColumn("entertainmentTypeUnit", EntertainmentPrtcption.unit().titile().s())
                .order().create())*/
                //EntertainmentPrtcption.overseer().s())
                .addColumn(publisherColumn("title", EntertainmentPrtcption.fullEntertainmentName().s()).publisherLinkResolver(new IPublisherLinkResolver()
                {
                    @Override

                    public Object getParameters(IEntity entity)
                    {
                        EntertainmentPrtcption entPrtcption = (EntertainmentPrtcption) entity;
                        return new ParametersMap().add(PublisherActivator.PUBLISHER_ID_KEY, entPrtcption != null ? entPrtcption.getId().toString() : null).add(EntParticipationViewUI.PUBLISHER_ID, entPrtcption.getId().toString());
                    }

                    @Override
                    public String getComponentName(IEntity entity)
                    {
                        return EntParticipationView.class.getSimpleName();
                    }
                }).create())
                .addColumn(textColumn("employeePost", EntertainmentPrtcption.type().person().identityCard().fullFio().s())
                        .order().create())
                .addColumn(textColumn("overseer", (EntertainmentPrtcption.overseerAsString())).create())
                        .create() ;
    }



}
