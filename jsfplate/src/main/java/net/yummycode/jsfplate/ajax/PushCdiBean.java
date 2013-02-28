package net.yummycode.jsfplate.ajax;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.inject.Inject;

import org.richfaces.application.push.TopicKey;
import org.richfaces.application.push.TopicsContext;
import org.richfaces.cdi.push.Push;

@SessionScoped
@ManagedBean(name = "pushCdiBean")
public class PushCdiBean implements Serializable {

	private static final long serialVersionUID = 6414191802542861042L;
	private String userIdentifier;
	public static final String PUSH_CDI_TOPIC = "pushCdi";
	private String message = "";

	@Inject
	@Push(topic = PUSH_CDI_TOPIC, subtopic = "#{pushCdiBean.userIdentifier}")
	Event<String> pushEvent;
	
	private transient TopicKey topicKey;     
	private transient TopicsContext topicsContext;      
	
	@PostConstruct
	public void init() {

		System.out.println("*** init()...");

		if (userIdentifier == null) {
			userIdentifier = UUID.randomUUID().toString().replace("-", "");
		}

		try {
			topicsContext = TopicsContext.lookup();
			topicKey = new TopicKey(PUSH_CDI_TOPIC, userIdentifier);
			topicsContext.getOrCreateTopic(topicKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMessage() throws Exception {
		if (pushEvent == null) {
			System.out.println("*** pushEvent = null!");
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

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
}
