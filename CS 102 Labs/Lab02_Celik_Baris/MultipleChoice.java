public class MultipleChoice extends Question {

    private String choices;

    public MultipleChoice(String question, String correctAnswer, String key) {

    super(question, correctAnswer);
    this.choices = key;
        
    }

    public void setChoices(String key) {
        this.choices = key;
    }

    public String getChoices() {
        return this.choices;
    }

    public String displayQuestion() {
        String string = super.displayQuestion();
        string = string + "\n" + getChoices();
        return "Here is the question \n" + string;
    }
    
}
