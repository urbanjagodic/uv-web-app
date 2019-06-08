package main;

import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
