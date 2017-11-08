package hello;


import org.springframework.data.jpa.repository.JpaRepository;


public interface PaperListRepository extends JpaRepository<PaperList, Long> {

}
