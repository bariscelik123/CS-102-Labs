public class ShortAnswer extends Question {

    private String[] keywords;

    public ShortAnswer(String question, String correctAnswer, String[] x) {
        super(question, correctAnswer);
        this.keywords = x; 
    }



    public void setKeywords(String[] x) {
        this.keywords = x;

    }

    public String[] getKeywords() {
        return this.keywords;

    }
    @Override
    public boolean isAnswerCorrect() {
        int count = 0;
        // setStudentAnswer(studentAnswer);
        // String[] answers = this.studentAnswer.split(" ");
        for (int i = 0; i < keywords.length; i++) {
            if (studentAnswer.contains(keywords[i])) {
                count++;
            }     
        }
        return ((2 * count)>keywords.length);
    }
}




