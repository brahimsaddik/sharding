package com.isidis.controller;

import com.isidis.main.HibernateSharedUtil;
import com.isidis.model.Transporter;
import com.isidis.model.TransporterPricing;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
// like a api to  send some requests with http   and we communiticating with JSON
public class ShardingController {


    public final static Logger logger = Logger.getLogger(ShardingController.class.getName());


    @RequestMapping(value = "/insert", method = RequestMethod.GET)

    public @ResponseBody Transporter insertTransporter(@RequestParam("nom") String nom,
                                                         @RequestParam("adresse") String adresse,
                                                         @RequestParam("zipcode") String zipcode,
                                                         @RequestParam("phone") String phone,
                                                         @RequestParam("mail") String mail) {
        Transaction transaction = null;
        try {
            // HibernateSharedUtil.init();
            logger.info("sessionFactory");
            SessionFactory sessionFactory = HibernateSharedUtil.getSessionFactory();
            logger.info("session");
            Session session = sessionFactory.openSession();
            logger.info("transporter");

            Transporter transporter = new Transporter();
            logger.info("transaction");
            transaction = session.beginTransaction();

            transporter.setAddress(adresse);
            transporter.setMail(mail);
            transporter.setName(nom);
            transporter.setPhone(phone);
            transporter.setZip_code(zipcode);
            logger.info("session.save(transporter);");
            session.save(transporter);
            logger.info("transaction.commit();");
            transaction.commit();
            logger.info("session.close();");
            session.close();
            logger.info("return");
            return transporter;

        } catch (Exception e) {
            logger.info("machakil");
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/getTransporter1/", method = RequestMethod.GET)
    public @ResponseBody List<Transporter> listAllSession1() {
        // prb 3andak fih

        SessionFactory sf = new AnnotationConfiguration().configure("/shard1/hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        List transporterList = session.createQuery("FROM Transporter").list();
        session.close();
        System.out.println(transporterList);
        if (transporterList.isEmpty()) {
            return null;
        }

        return transporterList;
    }

    @RequestMapping(value = "/getTransporter2/", method = RequestMethod.GET)
    public @ResponseBody List<Transporter> listAllSession2() {

        SessionFactory sf = new AnnotationConfiguration().configure("/shard2/hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        List transporterList = session.createQuery("FROM Transporter").list();
        session.close();
        System.out.println(transporterList);
        if (transporterList.isEmpty()) {
            return null;
        }

        return transporterList;
    }

    @RequestMapping(value = "/getTransporter3/", method = RequestMethod.GET)
    public @ResponseBody List<Transporter> listAllSession3() {

        SessionFactory sf = new AnnotationConfiguration().configure("/shard3/hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        List transporterList = session.createQuery("FROM Transporter").list();
        session.close();
        System.out.println(transporterList);
        if (transporterList.isEmpty()) {
            return null;        }

        return transporterList;
    }
}