import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 7790620252680329776L;

	private String text;
	private Object data;
	
	private Message(MessageBuilder builder) {
		this.text = builder.text;
		this.data = builder.data;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static class MessageBuilder {
		
		private String text;
		private Object data;
		public MessageBuilder(String text, Object data) {
			super();
			this.text = text;
			this.data = data;
		}
		public MessageBuilder setText(String text) {
			this.text = text;
			return this;
		}
		public MessageBuilder setData(Object data) {
			this.data = data;
			return this;
		}
		
		public Message build() {
			return new Message(this);
		}
	}
}
