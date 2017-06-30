package com.isidis.main;

import com.isidis.model.Transporter;
import org.apache.log4j.Logger;
import org.hibernate.shards.ShardId;
import org.hibernate.shards.strategy.selection.ShardSelectionStrategy;

public class ApplicationShardSelectionStrategy implements ShardSelectionStrategy {
	 final static Logger logger = Logger.getLogger(ApplicationShardSelectionStrategy.class.getName());
	@Override
	public ShardId selectShardIdForNewObject(Object obj) {
        if (obj instanceof Transporter) {
            return this.getShardId((Transporter)obj);
        }
        else
        {
            logger.info("The Selected Shard is  : "+1);
            return new ShardId(0);
        }
    }

    private ShardId getShardId(Transporter transporter){
        String zipCode = transporter.getZip_code();

        if (zipCode.startsWith("7")){
            return new ShardId(0);
        }
        if (zipCode.startsWith("91")||zipCode.startsWith("92")||zipCode.startsWith("93")){
            return new ShardId(1);
        }
        return new ShardId(2);

    }

}
