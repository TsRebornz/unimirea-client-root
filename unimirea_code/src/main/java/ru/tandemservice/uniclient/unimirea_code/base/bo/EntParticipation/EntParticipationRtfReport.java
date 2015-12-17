package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation;

import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.dao.ICommonDAO;
import org.tandemframework.rtf.document.RtfDocument;
import org.tandemframework.rtf.io.RtfReader;
import org.tandemframework.rtf.modifiers.RtfTableModifier;
import org.tandemframework.shared.employeebase.catalog.entity.EmployeeRosterTemplateDocument;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ocean on 11.11.2015.
 */
public class EntParticipationRtfReport
{


    private final String templatePath = "C:\\TandemWS\\mirea\\unimirea\\unimirea_code\\src\\main\\resources\\templates\\EntertainmentParticipation.rtf";

    //TODO Запилить шаблон в формате 010101010001


    public RtfDocument initRtfDocument(){
        ICommonDAO dao = DataAccessServices.dao();
        RtfDocument document = new RtfReader().read(dao.getByCode(EmployeeRosterTemplateDocument.class, "employeePostReference").getContent());

        List<EntertainmentPrtcption> list = DataAccessServices.dao().getList(EntertainmentPrtcption.class);

        RtfTableModifier tableModifier = new RtfTableModifier();
        tableModifier.put("T", getEntParticipationTableData(list));
        tableModifier.modify(document);
        //resultDoc.getElementList().addAll(resultDoc.getElementList());

        return document;
    }

    public String[][] getEntParticipationTableData(List<EntertainmentPrtcption> list){
        List<String[]> lines = new ArrayList<>();
        Iterator<EntertainmentPrtcption> entityListIterator = list.iterator();
        while(entityListIterator.hasNext()){
            EntertainmentPrtcption entPart = entityListIterator.next();
            List<String> cells = new ArrayList<>();
            cells.add(entPart.getUnit().getTitile());
            cells.add(entPart.getUnit().getDateBegin().toString());
            cells.add(entPart.getUnit().getDateEnd().toString());
            cells.add(entPart.getType().getEmployee().getFullFio());
            cells.add(entPart.getOverseerAsString());
            lines.add(cells.toArray(new String[cells.size()]));
        }
//        String[][] result = new String[lines.size()][6];
//
//        for(int x =0 ; x < lines.size(); x++){
//            for(int y=0; y < 5; y++ ){
//                result[x][y] = lines.get(x)[y];
//            }
//        }

        return lines.toArray(new String[lines.size()][6]);
    }


}
