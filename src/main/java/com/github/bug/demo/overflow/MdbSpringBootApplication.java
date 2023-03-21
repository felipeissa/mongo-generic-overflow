package com.github.bug.demo.overflow;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.bug.demo.overflow.pojo.BiscuitMetadata;
import com.github.bug.demo.overflow.pojo.GrainMetadata;
import com.github.bug.demo.overflow.pojo.GroceryItem;
import com.github.bug.demo.overflow.pojo.GroceryMetadata;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) {

		// Clean up any previous data
		mongoTemplate.dropCollection(GroceryItem.class);

		System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");

		createGroceryItems();

		searchData();
	}

	// CREATE
	void createGroceryItems() {
		System.out.println("Data creation started...");

		this.mongoTemplate.save(new GroceryItem<>("Whole Wheat Biscuit", 5, new GroceryMetadata<>(new BiscuitMetadata("chocolate", 3))));
		this.mongoTemplate.save(new GroceryItem<>("Oreo Biscuit", 1, new GroceryMetadata<>(new BiscuitMetadata("chocolate", 1))));
		this.mongoTemplate.save(new GroceryItem<>("Kodo Millet", 3, new GroceryMetadata<>(new GrainMetadata(3))));
		this.mongoTemplate.save(new GroceryItem<>("Dried Red Chilli", 3, new GroceryMetadata<>(Collections.singletonMap("spiciness", "2"))));

		System.out.println("Data creation complete...");
	}
	
	void searchData() {
		System.out.println("Searching data");
		
		Query query = new Query(Criteria.where("quantity").gt(2));
		List<GroceryItem> foundData = this.mongoTemplate.find(query, GroceryItem.class);
		
		System.out.println(MessageFormat.format("Found a total of {0} items", foundData.size()));
	}

}
