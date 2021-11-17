    
package NamPHSE150923;
import java.util.Scanner;

public class StudentList {
    StudentNode root;
    Scanner sc = new Scanner(System.in);
    
    public StudentList(){
        root=null;
    }
    
    StudentNode search(String code){
        StudentNode p=this.root;
        if(root==null){
            return null;
        }
       
        int d=code.compareTo(p.code);
        while(p!=null && d!=0){
           d=code.compareTo(p.code);
           if(d<0) p=p.left;
           else if (d>0) p =p.right;
        }
        return p;
    }
    
    public void insert(String code, String name, float mark) {
        if (root == null) {
            root = new StudentNode(code, name, mark);
            return;
        }
        StudentNode p = root;
        StudentNode prev = null;
        while (p != null) {
            prev = p;
            if (code.compareTo(p.code) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (prev.code.compareTo(code) < 0) {
            prev.right = new StudentNode(code, name, mark);
        } else {
            prev.left = new StudentNode(code, name, mark);
        }
    }
    
    public void AddStudent(){
        String code1;
        String name1;
        float mark1;
        StudentNode p = null;
        do {
            code1=Check.getID("Enter ID Student you want to update (dxxx): ", "(dxxx) x is a number.(0 to 9)", "^[d|D]\\d{3}$");
            p = this.search(code1);
            if (p != null) {
                System.out.println("The ID is duplicated !");
                }
        } while (p != null);
        name1=Check.getString("enter a name for student :", "try again");
        mark1=Check.getAnFloatForWeight("enter a mark for studnet:", "try again", 0, 10);
        insert(code1, name1, mark1);
        StudentNode t1=new StudentNode(code1,name1,mark1);
        System.out.println("The new student has been added successfully !");
        System.out.println(t1);        
    }
 
    public void updateMark(){
        String code1;
        Float x;
        code1=Check.getID("Enter ID Student you want to update (dxxx): ", "(dxxx) x is a number.(0 to 9)", "^[d|D]\\d{3}$");
        StudentNode p = search(code1);
        if (p != null) {
            System.out.print("Here it is : ");
            System.out.println(p.toString());
            System.out.print("Please input the new mark of the student which you want to replaced with : ");
            x=Check.getAnFloatForWeight("enter a mark for studnet:", "try again", 0, 10);
                p.setMark(x);
            System.out.println("The mark of the student has been changed successfully !");
        } else {
            System.out.println("The ID of the student: " + code1 + "which you input hasn't existed yet. Not available ! ");
        }
    }
     
    public void printCode() {
        if (root == null)
                System.err.println("Empty list!!");
        else {
                System.err.println("Student List: ");
                printCode(root);
        }
    }

    public void printCode(StudentNode p) { 
        if (p != null) {
                if (p.left != null)
                        printCode(p.left);
                System.out.println(p.code + ", " + p.name + ", " + p.mark);
                if (p.right != null)
                        printCode(p.right);
        }
    }
    
    public void deleteStudentbyCode() {// duyen theo kieu mergin ,coi lại cái này quan trọng và khó nhất của bài
        String code=Check.getID("Enter ID Student you want to update (dxxx): ", "(dxxx) x is a number.(0 to 9)", "^[d|D]\\d{3}$");
        StudentNode p = root;
        StudentNode prev = null;
        boolean flag;
        String yon;
             StudentNode p1 = search(code);
             System.out.println(p1);
               yon = Check.getString("Are you sure delete Injection (Y or N): ", "Not valid.Input again!!");
            flag = Check.yesOrNO(yon);
            if(flag){              
            while (p != null && !p.code.equals(code)) {
                prev = p;
                if (p.code.compareTo(code) < 0) {
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
        StudentNode node = p;
        if (p != null && p.code.equals(code)) {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                StudentNode previous = node;
                StudentNode tmp = node.left;
                while (tmp.right != null) {
                    previous = tmp;
                    tmp = tmp.right;
                }
                node.code = tmp.code;
                if (previous == node) {
                    previous.left = tmp.left;
                } else {
                    previous.right = tmp.left;
                }
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node;
            }
            System.out.println("You have removed it successfully !");            
        } else if (root != null) {
            System.out.println("The ID of the student student : " + code+ "which you input is not in the student list. Not available !");
            } 
        else System.out.println("The list is emptied !");
                }           
            else System.out.println("remove fail");
    }      
}
