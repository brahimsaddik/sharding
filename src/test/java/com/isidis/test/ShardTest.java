package com.isidis.test;


import com.isidis.model.*;
import org.apache.log4j.Logger;
import org.hibernate.shards.ShardId;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShardTest {
    final static Logger logger = Logger.getLogger(ShardTest.class.getName());
    Transporter transporterCodeZip75;
    Transporter transporterCodeZip92;
    Transporter transporterCodeZip94;


    TransporterPricing transporterPricingCodeZip94;
    TransporterPricing transporterPricingCodeZip75;
    TransporterPricing transporterPricingCodeZip92;
    PriceType priceType;
    VehicleRange vehicleRange;
    VehicleType vehicleType;

    com.isidis.main.ApplicationShardSelectionStrategy applicationShardSelectionStrategy;


    @Before
    public void setupBeforeClass() {

        transporterPricingCodeZip94 = new TransporterPricing();
        transporterPricingCodeZip75 = new TransporterPricing();
        transporterPricingCodeZip92 = new TransporterPricing();
        priceType = new PriceType();
        vehicleRange = new VehicleRange();
        vehicleType = new VehicleType();
        logger.info("creation transporterCodeZip94");
        transporterCodeZip94 = new Transporter();
        transporterCodeZip94.setId(1000);
        transporterCodeZip94.setName("Brenner");
        transporterCodeZip94.setMail("Brenner@gmail.com");
        transporterCodeZip94.setZip_code("94200");
        transporterCodeZip94.setAddress("43 rue mkewar ivry sur seine");
        transporterCodeZip94.setPhone("056387321");


        logger.info("creation transporterCodeZip75");

        transporterCodeZip75 = new Transporter();
        transporterCodeZip75.setId(1001);
        transporterCodeZip75.setName("Gilles");
        transporterCodeZip75.setMail("Gilles@gmail.com");
        transporterCodeZip75.setZip_code("75200");
        transporterCodeZip75.setAddress("8 avenue gamebetta paris");
        transporterCodeZip75.setPhone("066928343");

        logger.info("creation transporterCodeZip92");

        transporterCodeZip92 = new Transporter();
        transporterCodeZip92.setId(1002);
        transporterCodeZip92.setName("clement");
        transporterCodeZip92.setMail("clement@gmail.com");
        transporterCodeZip92.setZip_code("92110");
        transporterCodeZip92.setAddress("51 rue du val d'or saint cloud");
        transporterCodeZip92.setPhone("0667284352");

        logger.info("creation applicationShardSelectionStrategy");
        applicationShardSelectionStrategy = new com.isidis.main.ApplicationShardSelectionStrategy();
    }


    @Test
    public void insertCarrier() {
        logger.info("------ Strating the Tests  ------");

        int resultExpectedIfBetweenCodeZip94 = 2;
        int resultExpectedIfBetweenCodeZip75 = 0;
        int resultExpectedIfBetweenCodeZip92 = 1;
        ShardId idResultCodeZip94 = applicationShardSelectionStrategy.selectShardIdForNewObject(transporterCodeZip94);
        Assert.assertEquals(resultExpectedIfBetweenCodeZip94, idResultCodeZip94.getId());
        logger.info("transporterCodeZip94 in Shard" + idResultCodeZip94.getId());
        ShardId idResultCodeZip75 = applicationShardSelectionStrategy.selectShardIdForNewObject(transporterCodeZip75);
        Assert.assertEquals(resultExpectedIfBetweenCodeZip75, idResultCodeZip75.getId());
        logger.info("transporterCodeZip75 in Shard" + (idResultCodeZip75.getId() ));
        ShardId idResultCodeZip92 = applicationShardSelectionStrategy.selectShardIdForNewObject(transporterCodeZip92);
        Assert.assertEquals(resultExpectedIfBetweenCodeZip92, idResultCodeZip92.getId());
        logger.info("transporterCodeZip92 in Shard" + (idResultCodeZip92.getId()));


    }


    @After
    public void endTestCarrier() {
        logger.info("------ Finish Test ------");
    }


}
