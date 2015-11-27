package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.PrintXml;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.core.CoreExceptionUtils;
import org.tandemframework.core.component.BusinessComponentUtils;
import org.tandemframework.core.process.BackgroundProcessBase;
import org.tandemframework.core.process.IBackgroundProcess;
import org.tandemframework.core.process.ProcessResult;
import org.tandemframework.core.process.ProcessState;
import org.tandemframework.shared.commonbase.base.util.CommonBaseRenderer;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationManager;

import java.io.ByteArrayOutputStream;

/**
 * Created by ocean on 27.11.2015.
 */
public class EntParticipationPrintXmlUI extends UIPresenter
{

    private byte[] report = null;

    @Override
    public void onComponentPrepareRender()
    {
        if (report != null) {
            BusinessComponentUtils.downloadDocument(new CommonBaseRenderer().xls().fileName("EntParticipationReport.xls").document(report), true);
            report = null;
        }
    }


    @Override
    public void onComponentRefresh()
    {
        ByteArrayOutputStream out = null;
        try
        {
            out = EntParticipationManager.instance()._entParticipationExcelReport().genereteExcelReport();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        report = out.toByteArray();


    }


    //            IBackgroundProcess process = new BackgroundProcessBase()
//            {
//                @Override
//                public ProcessResult run(ProcessState state)
//                {
    //try {


    //                    }
//                    catch (Throwable t)
//                    {
//                        throw CoreExceptionUtils.getRuntimeException(t);
//                    }
    //return null;
//                }
//            };








}
