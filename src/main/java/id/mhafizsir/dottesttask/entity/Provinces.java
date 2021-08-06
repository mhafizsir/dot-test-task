package id.mhafizsir.dottesttask.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "provinces")
public class Provinces {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "province_id", nullable = false)
  private String provinceId;

  @Column(name = "province_name", nullable = false)
  private String provinceName;

  @Basic
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @Basic
  @Column(name = "modified_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified_at;

  @Basic
  @Column(name = "deleted_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deletedAt;
}
