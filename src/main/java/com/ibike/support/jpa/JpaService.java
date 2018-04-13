package com.ibike.support.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaService<T extends JpaRepository> {
    T repository();
}
