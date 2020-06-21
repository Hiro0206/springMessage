package com.example;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "message")
@Builder
@AllArgsConstructor
public class Message implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String text;

  @Column(nullable = false)
  private String remoteAddr;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(updatable = false)
  private Date createdAt;

  // JPA requirement
  protected Message() {}

  @PrePersist
  public void prePersist() {
    this.createdAt = new Date();
  }

  @Override
  public String toString() {
    return String.format("Message[id=%d, name='%s', text='%s']", id, name, text);
  }
}
