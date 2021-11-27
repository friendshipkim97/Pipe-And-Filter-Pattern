package component.constant;

public class Constants {

    public enum EAddFilter1{

        eReadComplete("readComplete");

        private String content;
        EAddFilter1(String content) { this.content = content; }
        public String getContent() { return content; }
    }
}
