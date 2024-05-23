package in.kp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kp.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

}
