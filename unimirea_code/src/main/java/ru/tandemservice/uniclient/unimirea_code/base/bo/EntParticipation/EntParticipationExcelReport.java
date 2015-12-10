package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.tandemframework.hibsupport.DataAccessServices;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;


/**
 * Created by ocean on 27.11.2015.
 */
public class EntParticipationExcelReport
{
    //int currentRow = 1;
    //Макарона - код
    public ByteArrayOutputStream genereteExcelReport()throws Exception {
        List<EntertainmentPrtcption> list = DataAccessServices.dao().getList(EntertainmentPrtcption.class );
        Iterator<EntertainmentPrtcption> entityListIterator = list.iterator();

        // ������� �������� �����
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("UTF-8");
        ws.setMergedCellChecking(false);
        ws.setRationalization(false);
        ws.setGCDisabled(true);
        WritableWorkbook workbook = Workbook.createWorkbook(out,ws);
        WritableSheet sheet = workbook.createSheet("First Sheet", 0);

        int currentRow = 1;

        sheet.setColumnView(1,5);
        sheet.setColumnView(2,20);
        sheet.setColumnView(3,13);
        sheet.setColumnView(4,13);
        sheet.setColumnView(5,25);
        sheet.setColumnView(6,15);

        Label clName1 = new Label(1, 0, "№" );
        sheet.addCell(clName1);

        Label clName2 = new Label(2, 0, "Название мероприятия" );
        sheet.addCell(clName2);

        Label clName3 = new Label(3, 0, "Дата начала" );
        sheet.addCell(clName3);

        Label clName4 = new Label(4, 0, "Дата окончания" );
        sheet.addCell(clName4);

        Label clName5 = new Label(5, 0, "ФИО участника" );
        sheet.addCell(clName5);

        Label clName6 = new Label(6, 0, "Наблюдатель" );
        sheet.addCell(clName6);
        while (entityListIterator.hasNext()){
            EntertainmentPrtcption entPart = entityListIterator.next();

            Number number = new Number(1, currentRow, currentRow);

            sheet.addCell(number);

            Label title = new Label(2, currentRow, entPart.getUnit().getTitile());

            sheet.addCell(title);

            Label dateBegin = new Label(3, currentRow, entPart.getUnit().getDateBegin().toString());
            sheet.addCell(dateBegin);

            Label dateEnd = new Label(4, currentRow, entPart.getUnit().getDateEnd().toString());
            sheet.addCell(dateEnd);

            Label fio = new Label(5, currentRow, entPart.getType().getEmployee().getFullFio());
            sheet.addCell(fio);

            Label isOverseer = new Label(6, currentRow, entPart.getOverseerAsString());
            sheet.addCell(isOverseer);
            currentRow++;
        }
        workbook.write();
        workbook.close();
        return out;
    }
}
