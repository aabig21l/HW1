/**
 * Created By Abigail Abeyta
 * Date: 1/15/2023
 * EGR 227-A
 * Collaborated/ Discussed with: tutoring group
 */

import java.util.*;
public class HtmlValidator {
    Queue<HtmlTag> q;

    public HtmlValidator() {
        q = new LinkedList<HtmlTag>();
        // initializes validator to store an empty queue of HTML tags
    }

    public HtmlValidator(Queue<HtmlTag> tags) {
        if (tags == null) {
            throw new IllegalArgumentException();
        }
        q = tags;
        //initializes the validator with copy of the queue
    }

    public void addTag(HtmlTag tag) {
        if (tag == null) {
            throw new IllegalArgumentException();
        }
        q.add(tag);
        //add tag to the end of the validators q, if/ when the tag is null Illegal
        // argument exception
    }
    
    public Queue<HtmlTag> getTags() {
        return q;
        //returns validators q of Html tags
    }
    public void removeAll(String element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        q.removeIf(tag -> tag.getElement().equals(element));

        // removes any given tags that match the element

    }
    private void indent(HtmlTag t, int d){
        String indentation="    ";
        for (int i = 0; i < d; i++) {
            System.out.print(indentation);
        }
        System.out.println(t.toString());
    }
    //Indentation method


    //indented text representation of the Html tags in the queue
    //every opening tag that requires a closing tag increases the indentation
    // by 4 spaces (tab)
    public void validate() {
        Stack<HtmlTag> tags = new Stack<HtmlTag>();
        int tab = 0;
        int size = q.size();
        for (int i= 0; i < size; i++) {
            HtmlTag h2 = q.remove();

            if (!h2.isOpenTag()) {
                if (!tags.isEmpty() && tags.peek().matches(h2)) {
                    tab--;
                    indent(h2, tab);
                    tags.pop();
                } else {
                    System.out.println("Error unexpected tag:" + " " + h2.toString());
                }
            } else if (h2.isSelfClosing()){
                    indent(h2, tab);
            } else {
                    indent(h2, tab);
                    tags.push(h2);
                    tab++;
                }
                q.add(h2);
            }
            while (!tags.isEmpty()) {
                HtmlTag error = tags.pop();
                System.out.println("Error unclosed tag:" + " " + error.toString());
            }
        }
    }


//assignment notes: need some way to put values into the structure
//equivalent t0 (adding operation)
//way to remove values (a removing operation)
//need a way to test if there is anything left in the structure

//both store a sequence of values in a particular order
//stacks, LIFO
//queue, FIFO

//stack: adding operation "push", removing operation: "pop"
