package model;

public class Examen{

    private String question;
    private String WrAnswer;
    private String WrAnswer2;
    private String CorrAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getWrAnswer() {
        return WrAnswer;
    }

    public void setWrAnswer(String wrAnswer) {
        WrAnswer = wrAnswer;
    }

    public String getWrAnswer2() {
        return WrAnswer2;
    }

    public void setWrAnswer2(String wrAnswer2) {
        WrAnswer2 = wrAnswer2;
    }

    public String getCorrAnswer() {
        return CorrAnswer;
    }

    public void setCorrAnswer(String corrAnswer) {
        CorrAnswer = corrAnswer;
    }
}
