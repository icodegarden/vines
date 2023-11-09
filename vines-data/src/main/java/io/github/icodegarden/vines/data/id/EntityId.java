package io.github.icodegarden.vines.data.id;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.icodegarden.vines.data.biz.core.EntityType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *  
 * @author Fangfang.Xu
 *
 */
@EqualsAndHashCode//需要
@Getter
@ToString
public class EntityId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String NULL_UUID = "13814000-1dd2-11b2-8080-808080808080";
	public static final String SYS_TENANT_ID = NULL_UUID;
//	public static final String NULL_UUID_STARTOF0 = Uuids.startOf(0).toString();
	
	private String id;
	
	private EntityType entityType;
	
	/**
	 * DTO自动构造用
	 */
	public EntityId() {}

	public EntityId(String id, EntityType entityType) {
		super();
		this.id = id;
		this.entityType = entityType;
	}
	
	@JsonIgnore
    public boolean isNullUid() {
        return NULL_UUID.equals(getId());
    }

}
