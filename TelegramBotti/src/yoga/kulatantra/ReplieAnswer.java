package yoga.kulatantra;

import lombok.Getter;
import lombok.Setter;

// https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/
@Getter
@Setter
public class ReplieAnswer {
	String responseForString;
	String responseForPhoto;
	String responseForVideo;
	String responseForDocument;
}