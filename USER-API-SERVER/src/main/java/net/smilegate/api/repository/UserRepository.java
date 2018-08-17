package net.smilegate.api.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import net.smilegate.api.domain.User;

/**
 * Spring Data JPA
 * User Domain
 * @author dsbae
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	
	/**
	 * Delete 메소드 재 정의
	 * JPA의 Delete가 내부적으로 find를 한번 하고 삭제를 진행하기 때문에, 재 정의
	 * @param user_idx : User Resource index
	 */
	@Transactional
    @Modifying
    @Query("DELETE User u where u.user_idx = :user_idx")
    void deleteByUserIdx(@Param("user_idx") final int user_idx);
}
