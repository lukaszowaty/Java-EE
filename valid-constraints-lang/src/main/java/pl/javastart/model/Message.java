package pl.javastart.model;

import javax.validation.constraints.NotNull;

import pl.javastart.constraint.Lang;
import pl.javastart.constraint.NotBadWord;

public class Message {

		@NotNull
		private String title;
		@NotBadWord(lang = {Lang.PL, Lang.EN})
		private String content;
		
		Message() {}
		
		public Message(String title, String content) {
			this.setTitle(title);
			this.setContent(content);
		}
	     
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
}
