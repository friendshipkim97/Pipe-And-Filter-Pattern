package component.constant;

public class Constants {

    public enum ECourse{
        eSizeZero(0),
        eSizeOne(1),
        eSizeTwo(2),
        eSizeThree(3),
        eSpace(" ");

        private int number;
        private String content;
        ECourse(String content) { this.content = content; }
        ECourse(int number) { this.number = number; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
    }

    public enum EStudent{
        eSizeZero(0),
        eSizeOne(1),
        eSizeTwo(2),
        eSizeThree(3),
        eSizeFour(4),
        eSpace(" "),
        eTrue(true),
        eFalse(false);

        private int number;
        private String content;
        private boolean check;
        EStudent(String content) { this.content = content; }
        EStudent(int number) { this.number = number; }
        EStudent(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }

    public enum EStudentMajorFilter{

        ePortZero(0),
        eReadComplete("readComplete"),
        eTrue(true);

        private int number;
        private String content;
        private boolean check;
        EStudentMajorFilter(String content) { this.content = content; }
        EStudentMajorFilter(int number) { this.number = number; }
        EStudentMajorFilter(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }

    public enum EStudentNumberFilter{

        ePortZero(0),
        eReadComplete("readComplete"),
        eTrue(true);

        private int number;
        private String content;
        private boolean check;
        EStudentNumberFilter(String content) { this.content = content; }
        EStudentNumberFilter(int number) { this.number = number; }
        EStudentNumberFilter(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }

    public enum ETakingCourseFilter{

        ePortZero(0),
        eReadComplete("readComplete"),
        eTrue(true);

        private int number;
        private String content;
        private boolean check;
        ETakingCourseFilter(String content) { this.content = content; }
        ETakingCourseFilter(int number) { this.number = number; }
        ETakingCourseFilter(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }

    public enum ECommonFilterImpl{

        ePortZero(0),
        ePortOne(1);

        private int number;
        ECommonFilterImpl(int number) { this.number = number; }
        public int getNumber() { return number; }

    }

    public enum EFileUtility{

        eMinusOne(-1),
        eFilteringFinishMessage("::Filtering is finished; Output file is created."),
        eTrue(true);

        private int number;
        private String content;
        private boolean check;
        EFileUtility(String content) { this.content = content; }
        EFileUtility(int number) { this.number = number; }
        EFileUtility(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }

    }

    public enum ELineUtility{
        ePortZero(0),
        ePortOne(1),
        eMinusOne(-1),
        eSizeZero(0),
        eBytes64(64),
        eEnter('\n'),
        eEnterString("\n"),
        eReadComplete("readComplete"),
        eSpace(" "),
        eEmpty(""),
        eTrue(true),
        eFalse(false);

        private int number;
        private String content;
        private boolean check;
        ELineUtility(String content) { this.content = content; }
        ELineUtility(int number) { this.number = number; }
        ELineUtility(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }

    public enum EAdvancedCourseFilter{

        ePortZero(0),
        ePortOne(1),
        eMinusOne(-1),
        eSizeZero(0),
        eReadComplete("readComplete"),
        eTrue(true),
        eFalse(false);

        private int number;
        private String content;
        private boolean check;
        EAdvancedCourseFilter(String content) { this.content = content; }
        EAdvancedCourseFilter(int number) { this.number = number; }
        EAdvancedCourseFilter(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }

    public enum ELifeCycleManager{

        eCSMajor("CS"),
        eEEMajor("EE"),
        eCourseNumber12345("12345"),
        eCourseNumber23456("23456"),
        eCourseNumber17651("17651"),
        eCourseNumber17652("17652"),
        eStudentNumber2013("2013"),
        ePortZero(0),
        ePortOne(1),
        eStudentFileName("Students.txt"),
        eCourseFileName("Courses.txt"),
        eOutputFileName("Output.txt"),
        eOutput1FileName("Output-1.txt"),
        eOutput2FileName("Output-2.txt"),
        eTrue(true),
        eFalse(false);

        private int number;
        private String content;
        private boolean check;
        ELifeCycleManager(String content) { this.content = content; }
        ELifeCycleManager(int number) { this.number = number; }
        ELifeCycleManager(boolean check) { this.check = check; }
        public String getContent() { return content; }
        public int getNumber() { return number; }
        public boolean isCheck() { return check; }
    }
}
