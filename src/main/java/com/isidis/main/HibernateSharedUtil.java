package com.isidis.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.shards.ShardId;
import org.hibernate.shards.ShardedConfiguration;
import org.hibernate.shards.cfg.ConfigurationToShardConfigurationAdapter;
import org.hibernate.shards.strategy.ShardStrategy;
import org.hibernate.shards.strategy.ShardStrategyFactory;
import org.hibernate.shards.strategy.ShardStrategyImpl;
import org.hibernate.shards.strategy.access.SequentialShardAccessStrategy;
import org.hibernate.shards.strategy.access.ShardAccessStrategy;
import org.hibernate.shards.strategy.resolution.AllShardsShardResolutionStrategy;
import org.hibernate.shards.strategy.resolution.ShardResolutionStrategy;
import org.hibernate.shards.strategy.selection.ShardSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class HibernateSharedUtil {
    //static Logger lo = Logger.getLogger(HibernateSharedUtil.class.getName());
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }


//  whene we call this " static" like a constructor  for a static class
    static {
        try {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.configure("/shard1/hibernate.cfg.xml");
//            config.addResource("user.hbm.xml");
            List shardConfigs = new ArrayList();
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new AnnotationConfiguration().configure("/shard1/hibernate.cfg.xml")));
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new AnnotationConfiguration().configure("/shard2/hibernate.cfg.xml")));
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new AnnotationConfiguration().configure("/shard3/hibernate.cfg.xml")));
            ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
            ShardedConfiguration shardedConfig = new ShardedConfiguration(config, shardConfigs, shardStrategyFactory);
            sessionFactory = shardedConfig.buildShardedSessionFactory();
//sessionfactory is talking to 3 of  the databases

        } catch (Throwable ex) {
            ex.printStackTrace();
            sessionFactory = null;
        }
    }

    public static ShardStrategyFactory buildShardStrategyFactory() {
        ShardStrategyFactory shardStrategyFactory = new ShardStrategyFactory() {
            public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
                // we using our strategy  for segmentation
                ShardSelectionStrategy pss = new ApplicationShardSelectionStrategy();

                ShardResolutionStrategy prs = new AllShardsShardResolutionStrategy(shardIds);
                ShardAccessStrategy pas = new SequentialShardAccessStrategy();
                return new ShardStrategyImpl(pss, prs, pas);
            }
        };
        return shardStrategyFactory;
    }
}