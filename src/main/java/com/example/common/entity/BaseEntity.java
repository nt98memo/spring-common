package com.example.common.entity;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.core.annotation.MergedAnnotations.Search;

import com.example.common.form.BaseForm;
import com.example.common.group.Common;
import com.example.common.group.Delete;
import com.example.common.group.Update;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class BaseEntity extends BaseForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    @NotNull(groups={Update.class, Delete.class})
    @Min(value=1L, groups={Common.class, Search.class, Update.class, Delete.class})
    @Max(value=9223372036854775807L, groups={Common.class, Search.class, Update.class, Delete.class})
    private Long id;

	@Column(name = "create_system")
    private String createSystem;

	@Column(name = "create_url")
    private String createUrl;

	@Column(name = "create_user_id")
    private Long createUserId;

	@Column(name = "create_datetime")
    private Timestamp createDatetime;

	@Column(name = "update_system")
    private String updateSystem;

	@Column(name = "update_url")
    private String updateUrl;

	@Column(name = "update_user_id")
    private Long updateUserId;

	@Column(name = "update_datetime")
    private Timestamp updateDatetime;

    @PrePersist
    public void prePersist() {

		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

		this.setCreateDatetime(new Timestamp(now.getTimeInMillis()));
		this.setUpdateUrl(null);
		this.setUpdateDatetime(null);
    }
    
    @PreUpdate
    public void preUpdate() {

		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

		this.setUpdateDatetime(new Timestamp(now.getTimeInMillis()));
    }
    
    @PreRemove
    public void preRemove() {
    }
}
