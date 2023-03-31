package com.example.common.entity.demo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.core.annotation.MergedAnnotations.Search;

import com.example.common.entity.BaseEntity;
import com.example.common.enumeration.Flg;
import com.example.common.group.Common;
import com.example.common.group.Insert;
import com.example.common.group.Update;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "sample")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Sample extends BaseEntity  {

    @NotNull(groups={Insert.class, Update.class})
	@Column(name = "int_col")
    private Integer intCol;

    @NotNull(groups={Insert.class, Update.class,})
    @Min(value=3L, groups={Common.class, Search.class, Insert.class, Update.class})
    @Max(value=8L, groups={Common.class, Search.class, Insert.class, Update.class})
	@Column(name = "long_col")
    private Long longCol;

    @Digits(integer=3, fraction=2, groups={Common.class, Search.class, Insert.class, Update.class})
	@Column(name = "decimal_col")
    private BigDecimal decimalCol;

    @Size(min=1, max=5, groups={Common.class, Search.class, Insert.class, Update.class})
	@Column(name = "text_col")
    private String textCol;

    @Size(min=1, max=255, groups={Common.class, Search.class, Insert.class, Update.class})
	@Column(name = "password_col")
    private String passwordCol;

    @Size(min=1, max=10, groups={Common.class, Search.class, Insert.class, Update.class})
	@Column(name = "textarea_col")
    private String textareaCol;

    @NotNull(groups={Insert.class, Update.class})
    @Enumerated(EnumType.ORDINAL)
	@Column(name = "radio_col")
    private Flg radioCol;

    @NotNull(groups={Insert.class, Update.class})
    @Enumerated(EnumType.ORDINAL)
	@Column(name = "select_col")
    private Flg selectCol;

	@Column(name = "date_col")
    private Date dateCol;

    @NotNull(groups={Insert.class, Update.class})
	@Column(name = "time_col")
    private Time timeCol;

	@Column(name = "datetime_col")
    private Timestamp datetimeCol;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private SampleParent sampleParent;

    @OneToMany(mappedBy = "sample")
    private List<SampleChild> sampleChildList;

}