package mongo;
import static org.bson.codecs.configuration.CodecRegistries.*;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
	private static MongoClient _connection;

	public static MongoDatabase getDatabase() throws Exception{
		try {
			if (_connection == null) {
				_connection = MongoClients.create();
			}

			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));

			var dtb = _connection.getDatabase("AulaMongo").withCodecRegistry(pojoCodecRegistry);
			return dtb;

		} catch (Exception e) {
			throw e;
		}
	}

	public static void closeConnection() {
		if (_connection != null) {
			_connection.close();
		}
	}
}
