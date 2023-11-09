package io.github.icodegarden.vines.data;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Fangfang.Xu
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class VinesEmail {

	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private Map<String, String> images;
	private boolean html;

}
