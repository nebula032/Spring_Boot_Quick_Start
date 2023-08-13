package com.sjacob.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sjacob.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
