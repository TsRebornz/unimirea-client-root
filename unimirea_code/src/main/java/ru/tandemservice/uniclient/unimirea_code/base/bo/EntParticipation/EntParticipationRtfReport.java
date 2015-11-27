package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.tandemframework.core.i18n.russian.RussianDateFormatUtils;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.builder.MQBuilder;
import org.tandemframework.hibsupport.builder.expression.MQExpression;
import org.tandemframework.hibsupport.dao.ICommonDAO;
import org.tandemframework.rtf.document.RtfDocument;
import org.tandemframework.rtf.io.RtfReader;
import org.tandemframework.rtf.modifiers.RtfInjectModifier;
import org.tandemframework.rtf.modifiers.RtfTableModifier;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.text.SimpleDateFormat;
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
        byte[] bytes = "".getBytes();
        try{
            bytes = this.getData(templatePath);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        RtfDocument document = new RtfReader().read(bytes);
        List<EntertainmentPrtcption> list = DataAccessServices.dao().getList(EntertainmentPrtcption.class);

        RtfTableModifier tableModifier = new RtfTableModifier();
        tableModifier.put("T", getEntParticipationTableData(list));
        tableModifier.modify(document);
        //resultDoc.getElementList().addAll(resultDoc.getElementList());

        return document;
    }

    public byte[] getData(String path) throws IOException
    {
        File file = new File(path);
        InputStream is = new FileInputStream(file);

        //RTFEditorKit rtfEditorKit = new RTFEditorKit();
        //rtfEditorKit.read();

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            throw new IOException("Could not completely read file " + file.getName() + " as it is too long (" + length + " bytes, max supported " + Integer.MAX_VALUE + ")");
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    public String[][] getEntParticipationTableData(List<EntertainmentPrtcption> list){
        List<String[]> lines = new ArrayList<>();
        Iterator<EntertainmentPrtcption> entityListIterator = list.iterator();
        while(entityListIterator.hasNext()){
            EntertainmentPrtcption entPart = entityListIterator.next();
            List<String> cells = new ArrayList<>();
            cells.add(entPart.getUnit().getTitile());
            cells.add(entPart.getUnit().getType().getTitle());
            cells.add(entPart.getUnit().getDateBegin().toString());
            cells.add(entPart.getUnit().getDateEnd().toString());
            cells.add(entPart.getType().getEmployee().getFullFio());
            cells.add(entPart.isOverseer() ? "Присутствует" : "Отсутствует");
            lines.add(cells.toArray(new String[cells.size()]));
        }
        String[][] result = new String[lines.size()][6];

        for(int x =0 ; x < lines.size(); x++){
            for(int y=0; y < 6; y++ ){
                result[x][y] = lines.get(x)[y];
            }
        }
        return result;
    }


}
