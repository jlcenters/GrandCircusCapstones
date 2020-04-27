package co.grandcircus.capstone6.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.capstone6.entities.Task;

public interface TaskRepo extends JpaRepository<Task,Long>{

	Task findByUserId(Long id);

	List<Task> findAllByUserId(Long id);

	List<Task> findAll();

	Task findTaskById(Long id);

	void update(Task task);

}
