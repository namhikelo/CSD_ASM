/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NamPHSE150923;

/**
 *
 * @author caoki
 */
public class StudentNode implements Comparable{
    String code;
    String name;
    float mark;
    StudentNode left;
    StudentNode right;

    public StudentNode(String code, String name, float mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
 
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
   
    @Override
    public int compareTo(Object st) {
            return this.code.compareTo(((StudentNode)st).code);
    }

    @Override
    public String toString() {
        return "StudentNode{" + "Code =" + code + ", Name =" + name + ", Mark =" + mark + '}';
    }
    
}
