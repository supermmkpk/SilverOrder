package com.sliverorder.domain.menu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_user", indexes =
@Index(name = "idx_userNickname", columnList = "user_nickname"))
public class Menu {
}
