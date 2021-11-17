package NamPHSE150923;

public class  Main{

    public static void main(String[] args) {
        //Options in menu
        String[] options = {"Add new student", "update student", "remove food by id ", "Print the list", "Quit"};
        int choice = 0;
        StudentList list = new StudentList(); //Init empty list   

        do {
            System.out.println("\n student managing Program-SE150577-NGUYEN DO CAO KIEN");
            choice =Menu .getChoice(options);
            switch (choice) {
                case 1:
                    list.AddStudent();
                    break;
                case 2:
                    list.updateMark();
                    break;
                case 3:
                    list.deleteStudentbyCode();
                    break;
                case 4:
                  list.printCode();
                    break;
            }
        } while (choice > 0 && choice < 4);
    }
}
