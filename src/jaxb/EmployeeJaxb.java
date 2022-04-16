package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.stream.XMLEventWriter;
import java.io.*;
public class EmployeeJaxb {

    public void marshell(){
        try {
            Employe emp=new Employe("101","Bingoo","banglore",20000);

            //create JAXBcontext object, to create JAXB Context object we can use new Instance
            //newInstance () is a static factory method
            JAXBContext jaxbContext=JAXBContext.newInstance(Employe.class);
            //create marshaller object from jaxb context
            Marshaller ms=jaxbContext.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(emp, System.out);
            ms.marshal(emp, new File("src\\data\\Employee.xml"));
        }catch (Exception e){
            System.out.println(""+e.getMessage());
        }
    }

    public void Unmarshell(){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Employe.class);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            Employe employe=(Employe) unmarshaller.unmarshal(new File("src\\data\\Employee.xml"));
            System.out.println("Employee info :");
            System.out.println("id : "+employe.getId());
            System.out.println("name : "+employe.getName());
            System.out.println("address : "+employe.getAddress());
            System.out.println("salary : "+employe.getSalary());

        }catch (Exception e){
            System.out.println(""+e.getMessage());
        }
    }

}
