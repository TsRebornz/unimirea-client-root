package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.PublisherActivator;
import org.tandemframework.core.component.State;
import org.tandemframework.hibsupport.entity.EntityHolder;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

/**
 * Created by ocean on 10.11.2015.
 */
@State({
        @Bind(key= PublisherActivator.PUBLISHER_ID_KEY, binding="pubIdKey", required=true)
})
public class EntParticipationViewUI extends UIPresenter
{
    private String pubIdKey;
    private String employeeFulFio;
    private final EntityHolder<EntertainmentPrtcption> entPrtcptionHolder = new EntityHolder<>();



    // getters and setters


    public String getEmployeeFulFio()
    {
        if(null != entPrtcptionHolder.getValue())
        {
            return entPrtcptionHolder.getValue().getType().getEmployee().getFullFio();
        }else{
            return "";
        }
    }



    public String getPubIdKey()
    {
        return pubIdKey;
    }

    public void setPubIdKey(String pubIdKey)
    {
        // Be careful this is Govno code
        this.pubIdKey = pubIdKey;
        this.entPrtcptionHolder.setId(Long.parseLong(pubIdKey));
    }

    public EntityHolder<EntertainmentPrtcption> getEntPrtcptionHolder()
    {
        return this.entPrtcptionHolder;
    }
    public EntertainmentPrtcption getEntPrtcption(){
        return this.getEntPrtcptionHolder().getValue();
    }
}
