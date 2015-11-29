package ua.luckydev.zadachki.SingleList;

/**
 * Created by Lucky on 28.11.2015.
 */

//????????????? ?????? - ???????? ?????????????????? ????????? ?? ????????
public class InvertList
{

    public static void main(String[] args)

    {
        SingleList singList = new SingleList(); //???? ??????????? ????????????? ??????

        singList.add(1); //??????? ????????
        singList.add(2);
        singList.add(3);
        singList.add(4);
        singList.add(5);

        ListElement currentElement = singList.head;

        while(currentElement!=null)
        {
            System.out.println(currentElement);
            currentElement=currentElement.nextElement;
        }

        System.out.println("*****");

        singList = invert(singList);

        currentElement = singList.head;
        System.out.println("*****");

        while(currentElement!=null)
        {
            System.out.println(currentElement);
            currentElement=currentElement.nextElement;
        }
    }

    public static SingleList invert(SingleList singList) //?????? ??????? ? ??????
    {
        ListElement element = singList.head;
        singList.head = singList.tail;
        ListElement currentElement = singList.head;
        singList.tail.nextElement = element;
        singList.tail = findTail(currentElement, singList.tail);

        while (element != singList.tail)
        {
            singList.tail.nextElement = currentElement.nextElement;
            currentElement.nextElement = singList.tail;
            currentElement = singList.tail;
            singList.tail = findTail(currentElement.nextElement, singList.tail);
        }

        singList.tail.nextElement = null;

        return singList;    }


    public static ListElement findTail(ListElement el, ListElement tail) //??????? ????????? ?????
    {
        while (el.nextElement != tail)
        {
            el = el.nextElement;
        }

        return el;
    }
}
