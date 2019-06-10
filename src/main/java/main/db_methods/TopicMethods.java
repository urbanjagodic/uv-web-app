package main.db_methods;

import main.Topic;
import main.TopicRepository;

import java.util.ArrayList;
import java.util.List;

public class TopicMethods {

    TopicRepository userRepo;

    public TopicMethods(TopicRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<Topic> getTopics() {
        return this.userRepo.findAll();
    }

    public List<String> getTopicNames() {
        List<String> topicNames = new ArrayList<>();
        for (Topic topic : this.getTopics()) {
            topicNames.add(topic.getName());
        }
        return topicNames;
    }

    public int returnIdByName(String name) {
        for (Topic topic : this.getTopics()) {
            if(topic.getName().equals(name)) {
                return topic.getId();
            }
        }
        return -1;
    }

}
