package com.isidis.main;


import com.isidis.model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main
{
    Logger lo = Logger.getLogger(Main.class.getName());
    public void list()
    {
        SessionFactory sessionFactory = HibernateSharedUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Transporter> userList = session.createQuery("FROM Transporter").list();
        Iterator<Transporter> iterator = userList.iterator();
        while(iterator.hasNext())
        {
        	Transporter user = (Transporter) iterator.next();
            System.out.println(user);
        }
        session.close();
    }

    public void input()
    {
        SessionFactory sessionFactory = HibernateSharedUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try
        {
            transaction = session.beginTransaction();

            for(int i=0;i<5;i++){
            	Transporter transporter = new Transporter();
            	transporter.setId(i);
            	transporter.setAddress("transporter"+i);
            	transporter.setMail("transporter"+i);
            	transporter.setName("transporter"+i);
            	transporter.setPhone("transporter"+i);
            	transporter.setZip_code("transporter"+i);
                session.save(transporter);

                if(i==4)
                {
                	Transporter transporter2 = new Transporter();
                	transporter2.setId(i);
                	transporter2.setAddress("transporter"+i);
                	transporter2.setMail("transporter"+i);
                	transporter2.setName("marrier"+i);
                	transporter2.setPhone("transporter"+i);
                	transporter2.setZip_code("transporter"+i);
                    session.save(transporter2);
                }
            }

            TransporterPricing transporterpricing = new TransporterPricing();
            PriceType priceType = new PriceType();
            VehicleRange vehicleRange = new VehicleRange();
            VehicleType vehicleType = new VehicleType();
            Transporter transporter = new Transporter();

            Set<VehicleRange> listRange = new HashSet<>();
            Set<VehicleType> listType = new HashSet<>();

            transporter.setId(1);
            transporter.setAddress("tak");
            transporter.setMail("tak");
            transporter.setName("tak");
            transporter.setPhone("tak");
            transporter.setZip_code("tak");

            session.save(transporter);


            priceType.setId(1);
            priceType.setLibelle("Prix D'un transporteur");

            session.save(priceType);

            vehicleRange.setIdVehicleRange(1);
            vehicleRange.setLibelle("test");
            vehicleRange.setComfort(3);


            vehicleType.setVehicleID(1);
            vehicleType.setLibelle("test");
            vehicleType.setNbPassenger(3);

            listRange.add(vehicleRange);

            listType.add(vehicleType);

            vehicleRange.setRangeTypeSet(listType);
            vehicleType.setTypeRangeSet(listRange);

            session.save(vehicleRange);

            session.save(vehicleType);

            transporterpricing.setId(1);
            transporterpricing.setTransporter(transporter);
            transporterpricing.setPriceType(priceType);
            transporterpricing.setVehicleType(vehicleType);
            transporterpricing.setVehicleRange(vehicleRange);

            session.save(transporterpricing);

            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public static void main(String[] args)
    {
        Main obj = new Main();
        obj.list();
        //obj.input();
        //obj.list();
    }
}