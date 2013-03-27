package net.yummycode.jsfplate.ajax;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;

import javax.inject.Inject;
import javax.inject.Named;

import org.richfaces.cdi.push.Push;

@Named
@RequestScoped
public class PushCdiBean implements Serializable {

	private static final long serialVersionUID = 6414191802542861042L;
	public static final String PUSH_CDI_TOPIC = "pushCdi";
	private String message = "";

	@Inject
	@Push(topic = PUSH_CDI_TOPIC)
	Event<String> pushEvent;
	
	
	public void sendMessage() throws Exception {
		if (pushEvent == null) {
		} else {
			pushEvent.fire(message);
		}
		message = "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
