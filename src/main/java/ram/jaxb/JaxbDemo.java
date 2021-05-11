package ram.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxbDemo {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        convertObjectToXml();
        convertXmlToObject();
    }
    private static void convertObjectToXml() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        Employee employee = new Employee(1,"Peter",5000);
        marshaller.marshal(employee,new FileOutputStream("employe.xml"));
        System.out.println("employee.xml is created sucessfully");
    }
    private static void convertXmlToObject(){
        try{
            File file = new File("employe.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Employee employee = (Employee) unmarshaller.unmarshal(file);
            System.out.println(employee);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
